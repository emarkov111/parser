package test.org.mav;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mav.Parser;

import static junit.framework.TestCase.assertEquals;

/**
 * Parser Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>фев 5, 2017</pre>
 */
public class ParserTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getTitle()
     */
    @Test
    public void testGetTitle() throws Exception {
        Parser parser = new Parser("https://www.us-proxy.org");
        assertEquals(true, parser.getTitle());
    }

    /**
     * Method: getTable()
     */
    @Test
    public void testGetTable() throws Exception {

    }


} 
