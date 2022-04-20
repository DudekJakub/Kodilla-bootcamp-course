package facebook;

import config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.time.LocalDate;

public class FacebookTestingApp {
    private static final int BIRTH_YEAR = 1994;
    private static final String EMAIL = "jakub.dudek94@gmail.com";
    private static final String FACEBOOK_COOKIES = "//*[@data-cookiebanner=\"accept_only_essential_button\"]";
    private static final String FACEBOOK_CREATE_NEW_ACC = "//*[@data-testid=\"open-registration-form-button\"]";
    private static final String FACEBOOK_INSERT_FIRSTNAME = "//*[contains(@name, \"firstname\")]";
    private static final String FACEBOOK_INSERT_LASTNAME = "//*[contains(@name, \"lastname\")]";
    private static final String FACEBOOK_INSERT_EMAIL = "//*[contains(@name, \"reg_email_\")]";
    private static final String FACEBOOK_INSERT_REPEAT_EMAIL = "//*[contains(@name, \"reg_email_confirmation_\")]";
    private static final String FACEBOOK_INSERT_PASSWORD = "//*[contains(@name, \"reg_passwd_\")]";
    private static final String FACEBOOK_INSERT_DAY = "//div[contains(@class, \"_58mq _5dbb\")]/div[2]/span/span/select[1]";
    private static final String FACEBOOK_INSERT_MONTH = "//*[contains(@name, \"birthday_month\")]";
    private static final String FACEBOOK_INSERT_YEAR = "//*[contains(@name, \"birthday_year\")]";
    private static final String FACEBOOK_CHOOSE_SEX = "//*[@name=\"sex\" and @value=\"2\"]";

    public static void main(String[] args)  {
        int birthday_index = LocalDate.now().getYear() - BIRTH_YEAR;

        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);

        assert driver !=null;
        driver.get("https://pl-pl.facebook.com/");

        var facebookCookiesElement = driver.findElement(By.xpath(FACEBOOK_COOKIES));
        facebookCookiesElement.click();

        var facebookNewAccountButtonElement = driver.findElement(By.xpath(FACEBOOK_CREATE_NEW_ACC));
        facebookNewAccountButtonElement.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        var facebookInsertFirstname = driver.findElement(By.xpath(FACEBOOK_INSERT_FIRSTNAME));
        facebookInsertFirstname.sendKeys("Jakub");

        var facebookInsertLastname = driver.findElement(By.xpath(FACEBOOK_INSERT_LASTNAME));
        facebookInsertLastname.sendKeys("Dudek");

        var facebookInsertEmail = driver.findElement(By.xpath(FACEBOOK_INSERT_EMAIL));
        facebookInsertEmail.sendKeys(EMAIL);

        var facebookInsertEmailConfirmation = driver.findElement(By.xpath(FACEBOOK_INSERT_REPEAT_EMAIL));
        facebookInsertEmailConfirmation.sendKeys(EMAIL);

        var facebookInsertPassword = driver.findElement(By.xpath(FACEBOOK_INSERT_PASSWORD));
        facebookInsertPassword.sendKeys("Qxvie43pl");

        var facebookInsertDay = driver.findElement(By.xpath(FACEBOOK_INSERT_DAY));
        Select daySelect = new Select(facebookInsertDay);
        daySelect.selectByIndex(16);

        var facebookInsertMonth = driver.findElement(By.xpath(FACEBOOK_INSERT_MONTH));
        Select monthSelect = new Select(facebookInsertMonth);
        monthSelect.selectByIndex(5);

        var facebookInsertYear = driver.findElement(By.xpath(FACEBOOK_INSERT_YEAR));
        Select yearSelect = new Select(facebookInsertYear);
        yearSelect.selectByIndex(birthday_index);

        var facebookChooseSex = driver.findElement(By.xpath(FACEBOOK_CHOOSE_SEX));
        facebookChooseSex.click();
    }
}
