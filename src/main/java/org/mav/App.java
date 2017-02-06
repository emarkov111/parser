package org.mav;

import org.mav.parsers.Urls.RusAuto24EE;

/**
 *
 */
public class App {
    public static void main(String[] args) {
        String userAgent = "Mozilla/5.0 (X11; Linux x86_64; rv:53.0) Gecko/20100101 Firefox/53.0";
        String userAgent1 = "Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6";
        String url = "http://rus.auto24.ee/kasutatud/nimekiri.php?bn=2&a=100&aj=&b=4&ae=2&af=200&ag=0&ag=1&otsi=поиск&ak=0";
//                    http://rus.auto24.ee/kasutatud/nimekiri.php?bn=2&a=100&aj=&b=2&f1=1990&f2=2017&g1=100&g2=10000&ae=2&af=200&ag=0&ag=1&otsi=поиск
//        ProxyFile proxyFile = new ProxyFile("https://www.us-proxy.org");
//        proxyFile.getProxyFile();
        RusAuto24EE rusAuto24EE = new RusAuto24EE(url, userAgent);
        rusAuto24EE.getDataSite();
    }
}