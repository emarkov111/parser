package org.mav.config;

import java.util.Random;

public class BrouserAgent {

    private String[] userAgentArray = new String[5];

    public BrouserAgent() {
        userAgentArray[0] = "Mozilla/5.0 (X11; Linux x86_64; rv:53.0) Gecko/20100101 Firefox/53.0";
        userAgentArray[1] = "Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6";
        userAgentArray[2] = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36";
        userAgentArray[3] = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36 OPR/42.0.2393.517";
        userAgentArray[4] = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.98 Safari/537.36 Viv/1.6.689.46";
    }

    public String getUserAgent() {
        Random random = new Random();
        return userAgentArray[random.nextInt(5)];
    }
}
