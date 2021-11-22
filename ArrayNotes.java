import java.util.GregorianCalendar;

/**
 * Write a description of class Notes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArrayNotes
{
    public static void createArrayOfEvens()
    {
        /*
         * An array is an ordered collection of elements of the same type. The type
         *      can be a primitive type (e.g., int) or a class (e.g., Turtle or String).
         *      
         *  An array variable is like an object variable in that is must be declared
         *      and initialized.
         *      
         *  The number is the square brackets (i.e., []) specifies the number of elements
         *      in the array. The number of elements in the array cannot be changed.
         *      
         *  All elements in the array are initialized to their default values
         *      (e.g., 0, false, null).
         *  
         *  This code creates an array that contains 10 int elements.
         */
        int[] evens = new int[10];
        
        /*
         * Set the value of each element in the array to the first 10 positive even
         *      integers.
         *      
         *  "length" is used to query the number of elements in the array
         *  
         *  Square brackets are used to reference a specific element in the array
         *      based on its index. Indicies are zero based.
         */
        for(int i = 0; i < evens.length; i++)
        {
            evens[i] = (i + 1) * 2;
        }
        
        // prints the reference to the array
        System.out.println(evens);
        
        for(int i = 0; i < evens.length; i++)
        {
            System.out.println(i + ": " + evens[i]);
        }
    }
    
    public static void createArrayOfOdds()
    {
        /*
         * An array literal (i.e., curly brackets and comma-separated values) can be
         *      used to initialize an array. The size of the array is inferred based
         *      on the number of elements in the literal.
         */
        int[] odds = new int[] { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 };
        
        /*
         * ArrayIndexOutOfBoundsException
         * 
         *  Arrays have a fixed size once intialized. The index specified must refer
         *      to a valid element. Otherwise, an ArrayIndexOutOfBoundsException is
         *      generated.
         */
        for(int i = 0; i <= odds.length; i++)
        {
            //System.out.println(i + ": " + odds[i]);
        }
        
        /*
         * Array References
         * 
         *  Variables of type array, contain a reference to the array stored in the
         *      computer's memory.
         *      
         *  Assigning one array variable's value to another, copies the reference, not
         *      the array's elements.
         */
        int[] moreOdds = odds;
        odds[2] = 6;
        System.out.println(moreOdds[2]);        // prints 6
    }
}





