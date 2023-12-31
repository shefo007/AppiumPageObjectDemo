package tests.workflows;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class BaseTestWorkflow {

    public static AppiumDriver driver;
    private static final String DEFAULT_URL = "http://localhost:4723/";


    @BeforeTest
    public void Android_setUp() throws URISyntaxException, MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setPlatformVersion("11.0");
        options.setDeviceName("emulator-5554");
        options.setApp("https://github.com/shefo007/AppiumPageObjectDemo/blob/5cee44b5f77ab2216dc2176ff4b789e82a8fd48b/apps/ToDo.apk");

        driver = new AndroidDriver(new URI(DEFAULT_URL).toURL(), options);
    }

    @AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}
