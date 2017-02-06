package org.mav;

import org.mav.parsers.Urls.RusAuto24EE;

/**
 *
 */
public class App {
    public static void main(String[] args) {
//        ProxyFile proxyFile = new ProxyFile("https://www.us-proxy.org");
//        proxyFile.getProxyFile();
        RusAuto24EE rusAuto24EE = new RusAuto24EE("http://rus.auto24.ee/kasutatud/nimekiri.php?bn=2&a=100&aj=&b=4&ae=2&af=50&ag=0&ag=1&otsi=поиск");
        rusAuto24EE.getDataSite();
    }
}