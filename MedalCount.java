
/**
 * Write a description of class MedalCount here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MedalCount
{
    private final int COUNTRIES = 7;
    private final int MEDALS = 3;
    
    /*
     * Can use array literals to create 2D arrays by nesting curly brackets.
     */
    private int[][] counts = new int[][]
        {
            { 1, 0, 1 },
            { 1, 1, 0 },
            { 0, 1, 0 },
            { 1, 1, 0 },
            { 0, 1, 1 },
            { 0, 0, 0 },
            { 1, 1, 1 }
        };
    
    /**
     * Constructor for objects of class MedalCount
     */
    public MedalCount()
    {
        /*
         * Alternate way to create a 2D array. The initialization would be followed
         *      by nested loops to intialize each element.
         */
        // this.counts = new int[COUNTRIES][MEDALS];
        // for ...
        //      for ...
    }
    
    /**
     * Prints the entire table.
     */
    public void printTable()
    {
        // good: for(int row = 0; row < COUNTRIES; row++)
        // better:
        for(int row = 0; row < this.counts.length; row++)
        {
            // good: for(int col = 0; col < MEDALS; col++)
            // better: for(int col = 0; col < this.counts[0].length; col++)
            // best:
            for(int col = 0; col < this.counts[row].length; col++)
            {
                System.out.print(this.counts[row][col] + "\t");
            }
            System.out.println();
        }
    }
    
    /**
     * Sum the medals for the specified country index (i.e., the specified row)
     * 
     * @param countryIndex the index of the country in the table whose medals to sum
     * @return the sum of medals for the specified country index
     */
    public int sumMedalsForCountry(int countryIndex)
    {
        int sum = 0;
        
        for(int col = 0; col < this.counts[countryIndex].length; col++)
        {
            sum += this.counts[countryIndex][col];
        }
        
        return sum;
    }
    
    /**
     * Sum the medals for the specified medal index for all countries (i.e., the
     *      specified column)
     *      
     *  @param medalIndex the index of the medal type in the table to sum for all
     *                      countries
     *  @return the sum of medals for the specified medal index for all countries
     */
    public int sumMedalsForType(int medalIndex)
    {
        int sum = 0;
        
        for(int row = 0; row < this.counts.length; row++)
        {
            sum += this.counts[row][medalIndex];
        }
        
        return sum;
    }
}





