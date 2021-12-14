
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

/**
 * The test class TourTest.
 *
 * @author  gcschmit
 * @version 03jun2020
 */
public class TourTest
{
    /**
     * Default constructor for test class UtilTest
     */
    public TourTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    // !!! how best to test that distance is updated propertly?

    @Test
    public void testDefaultConstructor()
    {
        Tour tour = new Tour();
        int[] cityIndices = tour.getCityIndices();
        assertEquals(BigTenData.getCities().length, cityIndices.length);
        for(int i = 0; i < cityIndices.length; i++)
        {
            assertEquals(0, cityIndices[i]);
        }
        assertEquals(0, tour.getDistance());
    }

    @Test
    public void testCopyConstructor()
    {
        Tour tour1 = new Tour();
        int[] cityIndices = tour1.getCityIndices();
        for(int i = 0; i < cityIndices.length; i++)
        {
            cityIndices[i] = i;
        }
        tour1.updateDistance();
        Tour tour2 = new Tour(tour1);

        assertArrayEquals(tour1.getCityIndices(), tour2.getCityIndices());
        assertNotSame(tour1.getCityIndices(), tour2.getCityIndices());
        assertEquals(tour1.getDistance(), tour2.getDistance());
    }

    @Test
    public void testSwapRandTwo()
    {
        int randCount = 0;

        Tour tour = new Tour();
        int[] cityIndices = tour.getCityIndices();
        for(int i = 0; i < cityIndices.length; i++)
        {
            cityIndices[i] = i;
        }
        tour.updateDistance();

        for(int i = 0; i < 1000; i++)
        {
            Tour prevTour = new Tour(tour);
            int[] prevCityIndices = prevTour.getCityIndices();

            tour.swapRandTwo();
            int index1 = 0, index2 = 0;

            for(int j = 0; j < cityIndices.length; j++)
            {
                if(cityIndices[j] != prevCityIndices[j])
                {
                    if(index1 == 0)
                    {
                        index1 = j;
                        randCount++;
                    }
                    else if(index2 == 0)
                    {
                        index2 = j;
                    }
                    else
                    {
                        fail("more than 2 elements were swapped");
                    }
                }
            }

            assertEquals(prevCityIndices[index1], cityIndices[index2]);
            assertEquals(prevCityIndices[index2], cityIndices[index1]);
        }

        assertTrue(randCount >= 800, "elements should be swapped a majority of the time");
    }

    @Test
    public void testCreateRandomTour()
    {
        double prevDistance = 0;
        int dupTourCount = 0;
        for(int i = 0; i < 1000; i++)
        {
            Tour tour = Tour.createRandomTour();
            int[] cityIndices = tour.getCityIndices();
            for(int j = 0; j < BigTenData.getCities().length; j++)
            {
                assertEquals(1, Util.count(cityIndices, j, 0, BigTenData.getCities().length));
            }

            assertEquals(0, cityIndices[0], "the first element must always be 0");
            assertNotEquals(0.0, tour.getDistance());
            if(tour.getDistance() == prevDistance)
            {
                dupTourCount++;
            }
            prevDistance = tour.getDistance();
        }

        assertTrue(dupTourCount < 5, "consecutive random tours should be very rare");

    }

    @Test
    public void testUpdateDistance()
    {
        Tour tour = new Tour();
        int[] cityIndices = tour.getCityIndices();
        for(int i = 0; i < cityIndices.length; i++)
        {
            cityIndices[i] = i;
        }
        tour.updateDistance();
        assertEquals(5105, tour.getDistance(), 10);
    }

    @Test
    public void testMutate()
    {
        int mutateCount = 0;

        Tour tour = Tour.createRandomTour();
        double prevDistance = tour.getDistance();

        for(int i = 0; i < 1000; i++)
        {
            tour.mutate();
            if(tour.getDistance() != prevDistance)
            {
                mutateCount++;
            }
            prevDistance = tour.getDistance();
        }

        assertEquals(TravelingStudent.mutationProbability, mutateCount/1000.0, 0.05);
    }

    @Test
    public void testCrossOver()
    {
        Tour parentA;
        Tour parentB;
        do
        {
            parentA = Tour.createRandomTour();
            parentB = Tour.createRandomTour();
        }
        while(Arrays.equals(parentA.getCityIndices(), parentB.getCityIndices()));

        int[][] testIndexPairs = new int[][] { {1, 1}, {11, 11}, {7, 7} };

        for(int[] indexPair : testIndexPairs)
        {
            Tour child = parentA.crossOver(parentB, indexPair[0], indexPair[1]);
            int[] cityIndices = child.getCityIndices();
            for(int j = 0; j < BigTenData.getCities().length; j++)
            {
                assertEquals(1, Util.count(cityIndices, j, 0, BigTenData.getCities().length),
                		"value " + j + " missing in child");
            }

            assertEquals(0, cityIndices[0], "the first element must always be 0");
            assertArrayEquals(cityIndices, parentA.getCityIndices(),
            		"child expected to match parentA");

        }

        testIndexPairs = new int[][] { {1, 13} };
        for(int[] indexPair : testIndexPairs)
        {
            Tour child = parentA.crossOver(parentB, indexPair[0], indexPair[1]);
            int[] cityIndices = child.getCityIndices();
            for(int j = 0; j < BigTenData.getCities().length; j++)
            {
                assertEquals(1, Util.count(cityIndices, j, 0, BigTenData.getCities().length),
                		"value " + j + " missing in child");
            }

            assertEquals(0, cityIndices[0], "the first element must always be 0");
            assertArrayEquals(cityIndices, parentB.getCityIndices(),
            		"child expected to match parentB");

        }

        for(int x1 = 1; x1 < BigTenData.getCities().length - 2; x1++)
        {
            for(int x2 = x1; x2 < BigTenData.getCities().length; x2++)
            {
                Tour child = parentA.crossOver(parentB, x1, x2);
                int[] cityIndices = child.getCityIndices();
                for(int j = 0; j < BigTenData.getCities().length; j++)
                {
                    assertEquals(1, Util.count(cityIndices, j, 0, BigTenData.getCities().length),
                    		"value " + j + " missing in child");
                }

                assertEquals(0, cityIndices[0], "the first element must always be 0");
            }
        }
    }
    
    @Test
    public void testGetCities()
    {
        Tour tour = new Tour();
        int[] cityIndices = tour.getCityIndices();
        for(int i = 0; i < cityIndices.length; i++)
        {
            cityIndices[i] = cityIndices.length - i - 1;
        }
        tour.updateDistance();
        
        City[] expectedCities = BigTenData.getCities();
        City[] actualCities = tour.getCities();
        for(int i = 0; i < expectedCities.length; i++)
        {
            assertEquals(expectedCities[i], actualCities[expectedCities.length - i - 1]);
        }
    }
    
    @Test
    public void testCompareTo()
    {
        Tour[] tours = new Tour[1000];
        for(int i = 0; i < tours.length; i++)
        {
            tours[i] = Tour.createRandomTour();
        }
        
        Arrays.sort(tours);
        
        double prevDistance = 0;
        for(int i = 0; i < tours.length; i++)
        {
            assertTrue(tours[i].getDistance() >= prevDistance, "tours incorrectly compared");
            prevDistance = tours[i].getDistance();
        }
    }
}
