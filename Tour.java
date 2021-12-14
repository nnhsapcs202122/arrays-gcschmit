import java.lang.Comparable;

/**
 * Models a tour of cities. 
 * 
 * @author @gcschmit (inspired by and high-level structure from Raja Sooriamurthi's
 *      SIGCSE nifty assignment)
 * @version 02jun2020
 */
public class Tour implements Comparable
{
    /*
     * The cityIndicies instance variable is an array of indicies of elements in the array
     *      of references to City objects provided by the BigTenData.getCities method. The order
     *      of element is the order in which the corresponding cities are visited. It is
     *      implied that we return to the first city at the end of the tour to "complete" it.
     *  
     *  For example, if the cityIndices had the following values:
     *          [  0, 13, 12,  1,  4,  5,  6,  7,  2,  3,  9, 10,  8, 11 ]
     *   indices:  0   1   2   3   4   5   6   7   8   9  10  11  12  13
     * 
     *      The value of the element at index 9 is 3. That value corresponds to the element
     *          in the cities array at index 3. Looking in the BitTenData class, the City
     *          object at index 3 is Michigan.
     *          
     *  Understanding this array is critical to implementing this class. If you aren't sure,
     *      please ask for clarification before starting to implement this class.
     */
    private int[] cityIndices;

    private double distance;

    /**
     * Constructs a new Tour object.
     * 
     *  postcondition: The cityIndices array has a length equal to the number of cities in
     *      the BigTenData class's cities array. 
     *  postcondition: The cityIndices array is initialized such that all elements have a value
     *      of 0.
     *  postcondition: The distance instance variable is initialized to 0.
     *      
     *  Other methods will populate the cityIndices array such that it contains a valid tour
     *			and then update the distance.
     */
    protected Tour()
    {
        // TODO
    }

    /**
     * Constructs a new Tour object by copying the specified tour.
     *      
     *  postcondition: The reference to the cityIndices array is NOT copied. This constructor
     *      initializes the cityIndices array to a new array of the appropriate length
     *		and then copies the value of each element from the specified tour's cityIndices
     *		array to this tour's cityIndices array.
     *  postcondition: This tour's distance must equal the specified tour's distance.
     *      
     *  @param tour     the tour from which to copy
     */
    public Tour(Tour tour) 
    {
        // TODO
    }

    /**
     * Updates the distance of this tour to reflect the current values in the citiIndices array.
     *      The distance of a tour is defined as the sum of the distances between each city in
     *      tour visited in the order specified in the cityIndices array. The distance includes
     *      the distance from the last city visited back to the first city (i.e. home).
     *      
     *  tip: The BigTenData class contains the distance matrix; read the documentation for the
     *				BigTenData.getDistanceMatrix method.
     */
    protected void updateDistance() 
    {
        // TODO
    }

    /**
     * Swaps two elements in the cityIndices array. The element at index 0 is never swapped
     *      since the first city visited (i.e., home) must always be the city corresponding
     *      to index 0.
     *      
     *  tip: Use the randRange method in the Util class.
     */
    protected void swapRandTwo() 
    {
        // TODO
    }

    /**
     * Creates a new Tour object in which the cities are visited in a randomly determined order
     *      other than that the first city visited (i.e., home) is always the city
     *      corresponding to index 0.
     *      
     *  tip: The swapRandTwo method can be used repeatedly to randomize order of elements.
     *  
     *  postcondition: The distance of the new tour reflects the order of its cities.
     * 
     * @return a Tour in which the cities are visited in a randomly determined order
     */
    public static Tour createRandomTour() 
    {
        // TODO
        
        return null;
    }

    /**
     * Mutates this tour by randomly selecting two cities in the tour and swapping their position
     *      in the cityIndices array if the mutation condition is triggered. The probability of
     *      a mutation is defined in the TravelingStudent class (mutationProbability). The
     *      distance must be updated if a mutation occurs.
     *      
     *  tip: Use the swapRandTwo method to perform the mutation.
     *      
     *  postcondition: The distance of this tour reflects the new order of its cities. 
     */
    public void mutate()
    {
        // TODO
    }

    /**
     * Creates the child tour by crossing this tour with the specified tour parentB. The
     *      specified crossover values determine the indices that define the crossover
     *      operation as shown: 
     *      <pre>
     *        this ---------------------------------
     *                    ^           ^
     *                    x1          x2
     *     parentB +++++++++++++++++++++++++++++++++
     *                    ^           ^
     *                    x1          x2
     *      
     *      
     *       child ------+++++++++++++--------------
     *      </pre>
     *      
     *      At a high level the array copying takes place in three stages:
     *      <pre>
     *        child[    0 .. x1-1     ]  = this    [    0 .. x1-1     ]
     *        child[   x1 .. x2       ]  = parentB [   x1 .. x2       ]
     *        child[ x2+1 .. length-1 ]  = this    [ x2+1 .. length-1 ]
     *      </pre>
     *      
     *      The potential problem is that after we copy the array segments we may have an
     *      invalid tour with duplicate cities. The replaceDuplicates method addresses this.
     *      
     *  postcondition: the child tour is a valid tour (i.e., contains all cities exactly once)
     *  postcondition: The distance of the child tour reflects the order of its cities.
     *  
     *  @param parentB  the tour to cross with this tour
     *  @param x1   the first crossover index
     *  @param x2   the second crossover index
     *  @return the child tour by crossing this tour with the specified tour
     */
    public Tour crossOver(Tour parentB, int x1, int x2) 
    {
        /*
         * 1. make a new "empty" (i.e., all values 0) tour which will be the child
         */
        
        Tour child = new Tour();
        
        
        /*
         * 2. copy the 1st segment of parentA (this) to the child
         */
        
        // TODO
        

        /*
         * 3. copy the cross-over portion of parentB to the child
         */
        
        // TODO
        
        
        /*
         * 4. copy the last segment of parentA (this) to the child
         */ 
        
        // TODO
        
        
        /*
         *  5 & 6. Now we need to correct the child for any duplicate cities
         */
        replaceDuplicates(parentB, x1, x2, child);

        /*
         * 7. update the child's distance
         */
        
        // TODO
        
        
        return child;
    }

    /**
     * Returns an array of references to City objects. The order of the elements in the
     *      returned array correspond to the order the cities are visited in this tour.
     *      
     *  tip: The BigTenData class contains an array of references to City objects. Refer to
     *      the comment at the top of this class for more information on how these arrays
     *      are correlated.
     *      
     *  @return an array of references to City objects corresponding to the order the cities
     *      are visited in this tour.
     */
    public City[] getCities()
    {
        // TODO
        
        return null;
    }

    /**
     * Compares this tour to the specified tour based on their distances.
     * 
     *  The obj parameter must be casted to a Tour.
     *  
     *  If this tour's distance is less than the specified tour's distance, a value less than 0
     *      must be returned.
     *  If this tour's distance is greater than the specified tour's distance, a value greater
     *      than 0 must be returned.
     *  If both tours' distances are equal, 0 must be returned.
     *  
     *  @return a values less than 0, greater than 0, or 0 if this tour's distance is less than,
     *      greater than, or equal to the specified tour's
     */
    @Override
    public int compareTo(Object obj) 
    {
        // TODO
        
        return 0;
    }
    
    /**
     * Replaces any duplicate cities in the child tour with cities unique to the crossover
     *      segment of this tour.
     *      
     *  This method solves the potential problem is that after we copy the array segments we
     *      may have an invalid tour with duplicate cities as shown below:
     *      <pre>
     *        this    a b c d e f g h i
     *                      ^^^^^
     *        parentB d h i c b e a g f
     *                      ^^^^^
     *        child   a b c c b e g h i
     *                      ^^^^^
     *      </pre>
     *      We can resolve this by: (tip: use the count method in the Util class)
     *      <ol>
     *          <li> scan the crossover segment of 'this' for elements that don't occur in
     *              the crossover segment of parentB:
     *              <pre>
     *                  uniq: d f 
     *              </pre>
     *          <li> scan the beginning and end segments of the child looking for duplicate
     *              elements in the crossed-over segment. When we find a duplicate replace it
     *              with an element of the 'uniq' array.
     *              <pre>
     *                  For example, replace 'b' with 'd'
     *                                       'c' with 'f'
     *              </pre>
     *              giving the new child:
     *      <pre>
     *                a d f c b e g h i
     *      </pre>
     *      </ol>
     *      
     *  postcondition: the child tour is a valid tour (i.e., contains all cities exactly once)
     *  
     *  @param parentB  the tour to cross with this tour
     *  @param x1   the first crossover index
     *  @param x2   the second crossover index
     *  @return the child tour by crossing this tour with the specified tour
     */
    public void replaceDuplicates(Tour parentB, int x1, int x2, Tour child)
    {
        // Extension: delete this implementation (leave the comments) and write your own!
        
        /*
         * 5. find the unique elements of the cross-over segment (i.e., those elements of the
         *      crossover segment of parentA that are not in parentB) and store in a new array
         *      variable
         *      
         *   tip: use the count method in the Util class
         */
        
        int[] uniq = new int[x2 - x1 + 1];
        int uniqCount = 0;
        
        for(int i = x1; i < x2; i++)
        {
            if(Util.count(parentB.cityIndices, this.cityIndices[i], x1, x2) == 0)
            {
                uniq[uniqCount] = this.cityIndices[i];
                uniqCount++;
            }
        }

        /*
         * 6. scan the first and third portions of the child (corresponding to the portions of
         *      this (parentA) that have been crossed into the child) for any duplicates in the
         *      second portion of the child (crossed-over segment from parentB) and, if so,
         *      replace with an element from the uniq list
         *      
         *   tip: use the count method in the Util class
         */
        int uniqIndex = 0;
        for(int i = 0; i < x1; i++)
        {
            if(Util.count(child.cityIndices, child.cityIndices[i], x1, x2) > 0)
            {
                child.cityIndices[i] = uniq[uniqIndex];
                uniqIndex++;
            }
        }

        for(int i = x2; i < child.cityIndices.length; i++)
        {
            if(Util.count(child.cityIndices, child.cityIndices[i], x1, x2) > 0)
            {
                child.cityIndices[i] = uniq[uniqIndex];
                uniqIndex++;
            }
        }
    }
    
    /**
     * Returns the total distance traveled for this tour.
     * 
     * @return the total distance traveled for this tour
     */
    public double getDistance()
    {
        return this.distance;
    }

    /**
     * Creates and returns a string containing the distance of the tour and a list of the
     *  cities visited in the tour.
     *  
     *  @return a string containing the distance of the tour and a list of the cities visited
     *      in the tour
     */
    public String toStringWithNames() 
    {
        City[] cities = this.getCities();

        String s = String.format("%6.1f :", this.distance);
        for (int i = 0; i < cities.length; i++) 
        {
            s += "\n" + i + ": " + cities[i];
        }
        s += "\n" + 0 + ": " + cities[0];
        return s;
    }

    /**
     * Creates and returns a string containing the distance of the tour and a list of the
     *      city indices in the tour.
     *      
     *  @return a string containing the distance of the tour and a list of the city indices in
     *      the tour
     */
    @Override
    public String toString() 
    {
        String s = String.format("%6.1f :", this.distance);
        for (int i = 0; i < this.cityIndices.length; i++) 
        {
            s += String.format("%3d", cityIndices[i]);
        }
        return s;
    }
    
    /**
     * Returns a reference to the city indices array. Only used by unit tests.
     */
    protected int[] getCityIndices()
    {
        return this.cityIndices;
    }

}
