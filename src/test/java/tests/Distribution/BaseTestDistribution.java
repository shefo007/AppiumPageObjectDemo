package tests.Distribution;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class BaseTestDistribution {

    public static AppiumDriver driver;
    private static final String DEFAULT_URL = "http://localhost:4723/";
    private AppiumDriverLocalService service;


    private void startServer(int port) {
        service = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingPort(port)
                .withAppiumJS(new File("C:\\Users\\Sheri\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
                .withTimeout(Duration.ofSeconds(60))
                .build();

        service.start();
    }

    private void stopServer() {
        service.stop();
    }

    public void Android_setUp(int port, String pfVersion, String udId) throws URISyntaxException, MalformedURLException {
//        startServer(port);

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setPlatformVersion(pfVersion);
        options.setAutomationName("UiAutomator2");
        options.setUdid(udId);
        options.setAppPackage("com.jeffprod.todo");
        options.setAppActivity(".ActivityMain");
        options.setNoReset(true);

        driver = new AndroidDriver(new URI("http://localhost:"+port+"/").toURL(), options);
    }


    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
//        stopServer();
    }
}
