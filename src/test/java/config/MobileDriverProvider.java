package config;

import com.codeborne.selenide.Configuration;
import drivers.BrowserstackDriver;
import drivers.LocalDriver;

public class MobileDriverProvider {

    public void setMobileConfig() {
        Configuration.browserSize = null;
        Configuration.timeout = 30000;
        if (System.getProperty("deviceHost").equals("browserstack")) {
            Configuration.browser = BrowserstackDriver.class.getName();
        } else {
            Configuration.browser = LocalDriver.class.getName();
        }
    }
}