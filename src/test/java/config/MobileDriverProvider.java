package config;

import com.codeborne.selenide.Configuration;
import drivers.BrowserstackDriver;
import drivers.LocalDriver;
import helpers.Environment;

public class MobileDriverProvider {

    public void setMobileConfig() {
        Environment env = new Environment();
        Configuration.browserSize = null;
        Configuration.timeout = 30000;
        if (env.isBrowserstack()) {
            Configuration.browser = BrowserstackDriver.class.getName();
        } else {
            Configuration.browser = LocalDriver.class.getName();
        }
    }
}