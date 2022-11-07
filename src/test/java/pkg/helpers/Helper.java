package pkg.helpers;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileInputStream;
import java.util.Properties;

public class Helper {
    //Logger Setup
    public static Logger log = LoggerFactory.getLogger("Logger");
    static public Faker faker = new Faker();
    public static WebDriver driver;

    //Setup properties file
    public static Properties property() {
        try {
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream("/Users/ravis/Documents/Ravi Sharma QA/Successive.Tech/MarketCube Project/API Automation/ui-automation-poc/src/test/resources/config/configuration.properties");
            properties.load(fileInputStream);
            return properties;
        } catch (Exception e) {
            log.error("Exception occurred property!!!");
            e.printStackTrace();
        }
        return null;
    }

    public static void webDriverStart() {
        System.setProperty("webdriver.chrome.driver", "/Users/ravis/Documents/Ravi Sharma QA/Successive.Tech/MarketCube Project/API Automation/ui-automation-poc/src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    public static void webDriverQuit() {
        driver.quit();
    }

}
