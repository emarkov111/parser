package org.mav;

/**
 *
 */
public class App {
    public static void main(String[] args) {
        Parser parser = new Parser("https://www.us-proxy.org");
//        parser.getTitle();
        parser.getProxyFile();
    }
}
