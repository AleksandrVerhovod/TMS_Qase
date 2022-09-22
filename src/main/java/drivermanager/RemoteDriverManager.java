package drivermanager;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class RemoteDriverManager extends DriverManager {
    @Override
    public void createDriver() {
        SafariOptions browserOptions = new SafariOptions();
        browserOptions.setCapability("platformName", "macOS 12");
        browserOptions.setCapability("browserVersion", "15");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("build", "1.0");
        sauceOptions.put("name", "Qase.io");
        browserOptions.setCapability("sauce:options", sauceOptions);

        try {

            driver = new RemoteWebDriver(new URL("https://SouceLabsVerhovod:90156063-dad8-45e5-8f95-9aedaf870fd8@ondemand.us-west-1.saucelabs.com:443/wd/hub"), browserOptions);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
