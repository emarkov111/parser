package org.mav;

import org.mav.config.BrouserAgent;
import org.mav.config.Urls;
import org.mav.parsers.Urls.RusAuto24EE;

public class App {

    public static void main(String[] args) {

        BrouserAgent brouserAgent = new BrouserAgent();

        Urls url = new Urls();

//        ProxyFile proxyFile = new ProxyFile("https://www.us-proxy.org");
//        proxyFile.getProxyFile();
        RusAuto24EE rusAuto24EE = new RusAuto24EE(url.getUrl(), brouserAgent.getUserAgent());
//        rusAuto24EE.getDataSite();
    }
}