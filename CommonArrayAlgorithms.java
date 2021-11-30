public class CommonArrayAlgorithms
{
    /*
     * Create array of the specified size filled with
     *      random values based on the maximum value.
     */
    public static int[] createRandomArray( int length, int maxValue )
    {
        int[] randomArray = new int[ length ];
        for( int i = 0; i < randomArray.length; i++ )
        {
            randomArray[ i ] = (int)( Math.random() * maxValue );
        }

        return randomArray;
    }

    /*
     * Prints the specified array to System.out
     */
    public static void printArray( int[] array )
    {
        System.out.print("[");

        for(int i = 0; i < array.length; i++)
        {
            System.out.print(array[i]);
            if(i < array.length - 1)
            {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }

    /*
     * Array Algorithm #0: Sum and Average
     *  creates an array filled with random numbers
     *  calculates the sum and average of the numbers
     *  prints the array and the sum and average
     *  @returns the average
     */
    public static double sumAndAverage()
    {
        double sum = 0;
        double average = 0;

        int[] array = createRandomArray( 10, 50 );

        for( int element : array)
        {
            sum += element;
        }

        average = sum / array.length;

        printArray( array );
        System.out.println( "sum: " + sum + " average: " + average );

        return average;
    }

    /*
     * Array Algorithm #1: Mode
     *  creates an array filled with random numbers
     *  calculates the mode (most frequent value in the array)
     *  prints the array and the mode
     *  @returns the mode of the elements in the array
     */
    public static int mode()
    {
        /* hint: when creating the random array, specify parameters that will
         *    likely result in a value being repeated multiple times;
         *    create another array to keep track of how many times each value
         *    occurs (index is the number and the value is the number of occurrences)
         */

        int maxValue = 10;
        int[] array = createRandomArray(20, maxValue);
        int maxfreq = 0;
        int mode = 0;
        int[] freq = new int[maxValue];
        for(int i = 0; i < array.length; i++) // could have used an enhanced for loop
        {
            freq[array[i]]++;
        }

        for(int j = 0; j < freq.length; j++)
        {
            if(freq[j] > maxfreq)
            {
                maxfreq = freq[j];
                mode = j;
            }
        }
        
        printArray(array);
        return mode;
    }

    /*
     * Array Algorithm #2: Print Element Separators
     *  creates an array filled with random numbers
     *  prints each element of the array with a '|' between each element
     *      but not at the beginning or end of the array
     */
    public static void printElementSeparators()
    {
        int[] array = createRandomArray( 10, 50 );

        for(int x = 0; x < array.length; x++)
        {
            System.out.print(array[x]);
            if(x == array.length - 1)
            {
                break;
            }
            System.out.print("|");

        }
    }

    /*
     * Array Algorithm #3: Linear Search
     *  creates an array filled with random numbers
     *  find the index of the first element with the specified value
     *  prints the array and the index (or -1 if not found)
     *    @returns the index of the first element with the specified value (or -1 if not found)
     */
    public static int linearSearch( int valueToFind )
    {
        int[] array = createRandomArray( 10, 5 );
        printArray(array);
        for(int i = 0; i != 10; i++){
            if(array[i] == valueToFind)
                return i;
        }
        return -1;
    }

    /*
     * Array Algorithm #4: Count Less Than
     *  creates an array filled with random numbers
     *  counts the number of elements that are less than the specified value
     *  prints the array and the count
     *  @return returns the number of elements that are less than the specified value
     */
    public static int countLessThan( int limit )
    {
        int[] array = createRandomArray(10, 100);
        int count = 0;
        for(int value : array ){
            if(value < limit) {
                count++;
            }
        }
        System.out.println();
        printArray(array);
        System.out.println(count + " elements under the limit.");
        return count;
    }

    /*
     * Array Algorithm #5: findMax
     *  creates an array filled with random numbers
     *  prints the array and the greatest number
     * @return returns the greatest number in the array
     */
    public static int findMax() 
    {
        int maxi;
        int[] testArray = createRandomArray(20,100);
        printArray(testArray);
        maxi = testArray[0];
        for(int i = 1; i < testArray.length; i++)       // could have used enhanced for loop
        {
            if(testArray[i] > maxi)
            {
                maxi = testArray[i];
            }
        }
        System.out.println("max: " + maxi);
        return maxi;

    }

    /*
     * Array Algorithm #6: Reverse Array
     *  creates an array filled with random numbers
     *  creates a new array of the same size
     *  copies elements from the first array into the new array in reverse order
     *  prints the original array and the new array
     *  returns the new array
     */
    public static int[] reverseArray()
    {
        int[] array = createRandomArray(10, 100);
        int[] newArray = new int[array.length];
        for(int x = 0; x < array.length; x++)
        {
            int a = array[x];
            newArray[array.length - x - 1] = a;
        }
        printArray(array);
        printArray(newArray);
        return newArray;

    }

}