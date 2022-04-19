package config;

import net.bytebuddy.utility.nullability.NeverNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverConfig {
    public final static String CHROME = "CHROME_DRIVER";
    public final static String FIREFOX = "FIREFOX_DRIVER";

    public static WebDriver getDriver(@NeverNull final String driver) {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium-drivers\\Chrome100\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "C:\\Selenium-drivers\\Firefox\\geckodriver.exe");

        if (driver.equals(FIREFOX)) {
            return new FirefoxDriver();
        } else if (driver.equals(CHROME)) {
            return new ChromeDriver();
        } else {
            return null;
        }
    }
}
