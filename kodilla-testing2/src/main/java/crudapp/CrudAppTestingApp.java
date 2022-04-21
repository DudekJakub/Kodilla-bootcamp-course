package crudapp;

import config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CrudAppTestingApp {
    private final static String XPATH_INPUT = "/html/body/main/section/form/fieldset/input";
    private final static String XPATH_TEXTAREA = "//html/body/main/section/form/fieldset[2]/textarea";
    private final static String XPATH_WAIT_FOR = "//select[1]";
    private final static String XPATH_SELECT = "//div[contains(@class, \"tasks-container\")]/form/div/fieldset/select[1]";

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://dudekjakub.github.io/");

        WebElement searchInput = driver.findElement(By.xpath(XPATH_INPUT));
        searchInput.sendKeys("New robotic task");

        WebElement searchTestArea = driver.findElement(By.xpath(XPATH_TEXTAREA));
        searchTestArea.sendKeys("The robotic context");

        while (!driver.findElement(By.xpath(XPATH_WAIT_FOR)).isDisplayed());

        WebElement selectCombo = driver.findElement(By.xpath(XPATH_SELECT));
        Select selectBoard = new Select(selectCombo);
        selectBoard.selectByIndex(1);

        Thread.sleep(2000);
    }
}
