package ebay;

import config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EBayTestingApp {
    private static final String GOOGLE_SEARCHFIELD = "q";
    private static final String GOOGLE_SEARCHKEY = "ebay";
    private static final String EBAY_Xpath = "//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div[1]/a/h3";
    private static final String EBAY_SEARCHFIELD = "_nkw";
    private static final String EBAY_SEARCHKEY = "Laptop";

    public static void main(String[] args) {
        var driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);

        driver.get("https://www.google.com");
        driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div")).click();

        WebElement searchElement = driver.findElement(By.name(GOOGLE_SEARCHFIELD));
        searchElement.sendKeys(GOOGLE_SEARCHKEY);
        searchElement.submit();

        WebElement google_ClickElement = driver.findElement(By.xpath(EBAY_Xpath));
        google_ClickElement.click();

        WebElement searchEbayElement = driver.findElement(By.name(EBAY_SEARCHFIELD));
        searchEbayElement.sendKeys(EBAY_SEARCHKEY);
        searchEbayElement.submit();
    }
}
