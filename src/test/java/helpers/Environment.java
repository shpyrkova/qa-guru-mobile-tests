package helpers;

public class Environment {

    public boolean isBrowserstack() {
        String deviceHost = System.getProperty("deviceHost");

        if (deviceHost == null || deviceHost.equals("browserstack")) {
            return true;
        }
        return false;
    }
}
