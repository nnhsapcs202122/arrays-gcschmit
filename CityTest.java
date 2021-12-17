

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class CityTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CityTest
{
    /**
     * Default constructor for test class CityTest
     */
    public CityTest()
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
    public void test()
    {
    	City testCity = new City(42.2808256, -83.7430378, "Michigan", "Ann Arbor, MI");
    	assertEquals(42.2808256, testCity.getLat(), 0.1);
    	assertEquals(-83.7430378, testCity.getLng(), 0.1);
    	assertNotEquals("", testCity.toString());
    }
}
