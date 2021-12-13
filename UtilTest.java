

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class UtilTest.
 *
 * @author  gcschmit
 * @version 03jun2020
 */
public class UtilTest
{
    /**
     * Default constructor for test class UtilTest
     */
    public UtilTest()
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
    
    @Test
    public void testRandRange()
    {
        for(int i = 0; i < 1000; i++)
        {
            int value = Util.randRange(1, 10);
            assertTrue((value >= 1 && value < 10), "value (" + value + ") must be in the range [1, 10)");
        }
    }
    
    @Test
    public void testCount()
    {
        int[] testArray = new int[] { 0, 1, 2, 3, 4, 4, 6, 7, 4, 9 };
        
        // test if value never occurs in array
        assertEquals(0, Util.count(testArray, 10, 0, 10));
        
        // test if value occurs once at start of array/range
        assertEquals(1, Util.count(testArray, 0, 0, 10));
        
        // test if value occurs once at end of array/range
        assertEquals(1, Util.count(testArray, 9, 0, 10));
        
        
        testArray = new int[] { 0, 1, 2, 0, 4, 4, 9, 7, 4, 9 };
        
        // test if value occurs 2 times (including at start)
        assertEquals(2, Util.count(testArray, 0, 0, 10));
        
        // test if value occurs 2 times (including at end)
        assertEquals(2, Util.count(testArray, 9, 0, 10));
        
        // test if value occurs 3 times (including twice in a row)
        assertEquals(3, Util.count(testArray, 4, 0, 10));
        
        
        testArray = new int[] { 9, 1, 2, 0, 9, 4, 9, 7, 4, 9 };
        
        // test if value occurs within subset of array
        assertEquals(2, Util.count(testArray, 9, 4, 7));
    }
}