package driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getDriver()  {
        if (webDriver.get() == null) {
            webDriver.set(createDriver());
        }
        return webDriver.get();
    }

    private static WebDriver createDriver()  {
        WebDriver driver = null;

        // use it if you are going to read browser from configuration.properties
        //String browserType = getBrowserType();

        // use this if you read browser type as parameter (running mvn test -Dbrowser="chrome")
        String browserType = getBrowserType();

        switch (browserType) {
            case "chrome" :
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/driver/drivers/chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox" :
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/java/driver/drivers/geckodriver.exe");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new FirefoxDriver(firefoxOptions);
                break;

        }
        driver.manage().window().maximize();
        return driver;
    }

    private static String getBrowserType() {
        String browserType=null;
        Properties properties = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/properties/configuration.properties");
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        try {
            properties.load(fis);
        } catch (IOException e) {
            System.out.println(e);
        }
        browserType = properties.getProperty("browser").toLowerCase().trim();
        return browserType;
    }

    public static void cleanupDriver() {
        webDriver.get().quit();
        webDriver.remove();
    }
}
