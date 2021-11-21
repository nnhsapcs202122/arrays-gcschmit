import java.util.Arrays;
import javax.swing.JFrame;

/**
 * Solves the problem of visiting all Big Ten Conference schools with the least amount of
 *      distance travled. Utilizies a genetic algorithm to determine a near-optimal solution. 
 * 
 * @author gcschmit
 * @version 02jun2020
 */
public class TravelingStudent
{
    public static final double mutationProbability = 0.1;

    private static final int POP_SIZE = 1000;
    private static final int TOTAL_GENERATIONS = 100;

    private Tour[] newPool;
    private Tour[] oldPool;
    private int numCities;
    private Map map;
    private int newPoolIndex;

    /**
     * Constructs a new TravelingStudent.
     *  Creates a new JFrame (Window) for the application.
     */
    TravelingStudent() 
    {
        this.oldPool = new Tour[POP_SIZE];
        this.newPool = new Tour[POP_SIZE];
        this.numCities = BigTenData.getCities().length;

        JFrame frame = new JFrame();
        frame.setTitle("TSP Lab");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // a frame contains a single component; create the map component and add it to the frame
        this.map = new Map();
        frame.add(this.map);

        // set the size of the frame to encompass the contained component
        frame.pack();

        // make the frame visible which will result in the paintComponent method being 
        //  invoked on the component.
        frame.setVisible(true);

    }

    private void run() 
    {
        Tour[] tmp_pool;

        // print cities and their indicies
        City[] cities = BigTenData.getCities();
        for(int i = 0; i < cities.length; i++)
        {
            System.out.println(i + ": " + cities[i]);
        }

        // create an initial random population of tours
        for (int i = 0; i < POP_SIZE ; i++) 
        {
            oldPool[i] = Tour.createRandomTour();
        }

        // display the best initial tour
        Arrays.sort(oldPool);
        map.setCurrentTour(oldPool[0], 0);
        pause(2000);

        // iterate for the specified number of generations
        for(int i = 0; i < TOTAL_GENERATIONS; i++) 
        {
            printTopOfPool(oldPool, "Gen: " + i, 5);

            // display the best tour so far
            map.setCurrentTour(oldPool[0], i);
            pause(250);

            // reset the index into the new pool
            newPoolIndex = 0;

            /* 
             * repeatedly perform the genetic algorithm to populate the new pool
             * 
             *  each invocation of performGeneticAlgorithm generates two child tours;
             *      therefore, invoke the method POP_SIZE / 2 times to create a new
             *      pool of size POP_SIZE
             */
            for (int j = 0; j < POP_SIZE / 2; j++) 
            {
                performGeneticAlgorithm();
            }

            // swap old and new pools
            tmp_pool = oldPool;
            oldPool = newPool;
            newPool = tmp_pool;

            // sort the oldPool in ascending order
            Arrays.sort(oldPool);
        }

        // print the best tour
        System.out.println(oldPool[0].toStringWithNames());
    }

    private void performGeneticAlgorithm() 
    {
        // STEP 1: SELECT two individuals to mate from the top half of the pool
        Tour parentA = this.oldPool[Util.randRange(0, POP_SIZE / 2)];
        Tour parentB = this.oldPool[Util.randRange(0, POP_SIZE / 2)];

        // STEP 2: CROSS-OVER
        //  determine two cross-over points
        int x1 = Util.randRange(1, this.numCities - 2);
        int x2 = Util.randRange(x1, this.numCities);

        // determine the children by first crossing parentA with parentB
        //  and then crossing parentB with parentA
        Tour childA = parentA.crossOver(parentB, x1, x2);
        Tour childB = parentB.crossOver(parentA, x1, x2);

        // * STEP 3: MUTATE both childA and childB
        childA.mutate();
        childB.mutate();

        // finally add childA and childB the new pool
        this.newPool[newPoolIndex++] = childA;
        this.newPool[newPoolIndex++] = childB;
    }

    private void printTopOfPool(Tour[] pool, String msg, int n) 
    {
        System.out.println(msg);
        for (int i = 0; i < n; i++) 
        {
            System.out.println(i + " " + pool[i]);
        }
        System.out.println();
    }

    /**
     * Pauses execution of the problem for the specified number of milliseconds.
     * 
     * @param n     the number of milliseconds for which to pause execution
     */
    private static void pause(int n) 
    {
        try 
        {
            Thread.sleep(n);
        }
        catch (Exception e) 
        {
        }
    }
    
    
    public static void main(String[] args) 
    {
        TravelingStudent traveler = new TravelingStudent();
        traveler.run();
    }
}
