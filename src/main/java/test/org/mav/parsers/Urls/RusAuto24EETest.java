package test.org.mav.parsers.Urls;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class RusAuto24EETest {

    Document document;

    private String PageProvider1() {

        StringBuffer html = new StringBuffer();

        html.append("<!DOCTYPE html>");
        html.append("<html lang=\"en\">");
        html.append("<head>");
        html.append("<link rel=\"icon\" href=\"http://example.com/image.ico\" />");
        html.append("</head>");
        html.append("<body>");
        html.append("something");
        html.append("</body>");
        html.append("</html>");

        return html.toString();

    }

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getDataSite()
     */
    @Test
    public void testGetDataSite() throws Exception {
        Document doc = Jsoup.parse(PageProvider1());
        Element element = doc.head().select("link[href~=.*\\.(ico|png)]").first();
        assertEquals(element.attr("href"),"http://example.com/image.ico");
    }


} 
