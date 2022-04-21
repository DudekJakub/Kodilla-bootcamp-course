package crudapp;

import config.WebDriverConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CrudAppTestSuite {
    private static final String BASE_URL = "https://dudekjakub.github.io/";
    private static final String TRELLO_PASSWORD = System.getenv("TRELLO_PASSWORD");
    private WebDriver driver;
    private Random generator;


    @BeforeEach
    public void initTests() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(BASE_URL);
        generator = new Random();
    }

    @AfterEach
    public void cleanUpAfterTests() {
        driver.close();
    }

    private String createCrudAppTestTask() throws InterruptedException {
        final String XPATH_TASK_NAME = "//form[contains(@action, \"createTask\")]/fieldset[1]/input";
        final String XPATH_TASK_CONTENT = "//form[contains(@action, \"createTask\")]/fieldset[2]/textarea";
        final String XPATH_TASK_ADD = "//form[contains(@action, \"createTask\")]/fieldset[3]/button";
        String taskName = "Task number " + generator.nextInt(100000);
        String taskContent = taskName + " content";

        WebElement name = driver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);

        WebElement content = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);

        driver.findElement(By.xpath(XPATH_TASK_ADD)).click();

        Thread.sleep(2000);

        return taskName;
    }

    private void sendTestTaskToTrello(String taskName) throws InterruptedException {
        driver.navigate().refresh();

        while (!driver.findElement(By.xpath("//select[1]")).isDisplayed());

        driver.findElements(
                By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm -> anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                        .getText()
                        .contains(taskName))
                .forEach(theForm -> {
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));
                    Select select = new Select(selectElement);
                    select.selectByVisibleText("Kodilla Aplication");

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    WebElement buttonCreateCard = theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]"));
                    buttonCreateCard.click();
                        });
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
    }

    private boolean checkTaskExistsInTrello(String taskName) throws InterruptedException {
        final String TRELLO_URL = "https://trello.com/login";
        boolean result;
        WebDriver driverTrello = WebDriverConfig.getDriver(WebDriverConfig.CHROME);

        assert driverTrello != null;
        driverTrello.get(TRELLO_URL);

        driverTrello.findElement(By.id("user")).sendKeys("jakub.dudek94@gmail.com");
        driverTrello.findElement(By.id("password")).sendKeys(TRELLO_PASSWORD);
        WebElement el = driverTrello.findElement(By.id("login"));
        el.submit();

        Thread.sleep(4000);

        driverTrello.findElement(By.id("password")).sendKeys(TRELLO_PASSWORD);
        driverTrello.findElement(By.id("login-submit")).submit();

        Thread.sleep(4000);

        driverTrello.findElement(By.xpath(".//a[@class=\"boards-page-board-section-header-options-item\"]")).click();

        Thread.sleep(4000);

        driverTrello.findElement(By.xpath(".//div[@title=\"Kodilla Aplication\"]")).click();

        Thread.sleep(4000);

        result = driverTrello.findElements(By.xpath("//span")).stream()
                .anyMatch(theSpan -> theSpan.getText().equalsIgnoreCase(taskName));

        driverTrello.close();

        return result;
    }

    private boolean deleteCrudAppTestTasks() throws InterruptedException {
        driver.navigate().refresh();

        while (!driver.findElement(By.xpath("//select[1]")).isDisplayed());

        driver.findElements(By.xpath(".//form[@class=\"datatable__row\"]"))
                .stream()
                .filter(anyRow -> anyRow.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                        .getText()
                        .contains("Task number"))
                .forEach(theForm -> {
                    theForm.findElement(By.xpath(".//select[1]"));

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    WebElement deleteButton = theForm.findElement(By.xpath(".//button[4]"));
                    deleteButton.click();
                });

        Thread.sleep(2000);

        return driver.findElements(By.xpath(".//form[@class=\"datatable__row\"]")).stream()
                .noneMatch(rows -> rows.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                .getText()
                .contains("Task number"));
    }

    @Test
    void testCountCrudAppTestTasks() {
        driver.navigate().refresh();

        /** this loop should be active if there are any records already added to task-list */
//        while (!driver.findElement(By.xpath("//select[1]")).isDisplayed());

        assertEquals(0, driver.findElements(By.xpath(".//form[@class=\"datatable__row\"]")).stream()
                .filter(rows -> rows.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                        .getText()
                        .contains("Task number"))
                .count());
    }

    @Test
    public void shouldCreateTrelloCard() throws InterruptedException {
        String taskName = createCrudAppTestTask();
        sendTestTaskToTrello(taskName);
        assertTrue(checkTaskExistsInTrello(taskName));
        assertTrue(deleteCrudAppTestTasks());
    }
}
