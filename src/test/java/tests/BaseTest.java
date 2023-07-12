package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class BaseTest extends AbstractTestNGCucumberTests {

    public static AppiumDriver driver;
    private static final String DEFAULT_URL = "http://localhost:4723/";
    private AppiumDriverLocalService service;

    private void startServer() {
        service = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withAppiumJS(new File("C:\\Users\\Sheri\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
                .withTimeout(Duration.ofSeconds(50))
                .build();

        service.start();
    }


    @BeforeTest
    public void Android_setUp() throws URISyntaxException, MalformedURLException {
//        startServer();

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setPlatformVersion("11.0");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("emulator-5554");
        options.setAppPackage("com.jeffprod.todo");
        options.setAppActivity(".ActivityMain");
        options.setNoReset(true);

        driver = new AndroidDriver(new URI(DEFAULT_URL).toURL(), options);
    }

    @AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
//        service.stop();
    }
}
