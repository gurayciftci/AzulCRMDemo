package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class mainPageStepDef {

    WebDriver driver = null;
    @Given("User is in the main page")
    public void user_is_in_the_main_page() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa.azulcrm.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("hr1@cybertekschool.com");
        driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys("UserUser");
        driver.findElement(By.xpath("//input[@class='login-btn']")).click();
        Thread.sleep(5000);

    }
    @When("User clicks the MESSAGE button")
    public void user_clicks_the_message_button() {
        WebElement messageButton = driver.findElement(By.xpath("//span[contains(text(),'Message')]"));
        messageButton.click();
    }
    @When("User texts a message {string} to the message box")
    public void user_texts_a_message_to_the_message_box(String string) throws InterruptedException {
        Thread.sleep(5000);
        driver.switchTo().frame(1);
        WebElement messageArea = driver.findElement(By.xpath("//body"));
        messageArea.sendKeys(string);
    }
    @When("User clicks SEND button")
    public void user_clicks_send_button() throws InterruptedException {
        Thread.sleep(1000);
        driver.switchTo().parentFrame();
        Thread.sleep(1000);
        WebElement sendButton = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendButton.click();
        Thread.sleep(3000);
    }

    @Then("Text should be displayed correctly and should be same with message {string}")
    public void text_should_be_displayed_correctly_and_should_be_same_with_message(String string) {
        String expectedResult = string;
        String actualResult = driver.findElement(By.xpath("(//div[@class='feed-post-text-block'])[1]//div[@class='feed-post-text-block-inner-inner']")).getText();
        System.out.println("Actual Result is: "+ actualResult +"\nExpected Result is: " + expectedResult);
        Assert.assertEquals(expectedResult,actualResult);
    }

    @When("User clicks the EVENT button")
    public void user_clicks_the_event_button() {
        WebElement eventButton = driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-calendar']"));
        eventButton.click();
    }
    @When("User texts a event name {string} to the message box")
    public void user_texts_a_event_name_to_the_message_box(String string) throws InterruptedException {
        Thread.sleep(3000);
        WebElement eventNameArea = driver.findElement(By.xpath("//input[@id='feed-cal-event-namecal_3Jcl']"));
        eventNameArea.sendKeys(string);
        Thread.sleep(1000);
    }
    @When("User texts a event details {string} to the message box")
    public void user_texts_a_event_details_to_the_message_box(String string) throws InterruptedException {
        Thread.sleep(3000);
        driver.switchTo().frame(1);
        Thread.sleep(1000);
        WebElement eventDetailsArea = driver.findElement(By.xpath("//body"));
        eventDetailsArea.sendKeys(string);
        driver.switchTo().parentFrame();
        Thread.sleep(1000);
    }
    @When("User select start date and time")
    public void user_select_start_date_and_time() throws InterruptedException {
        WebElement startDate = driver.findElement(By.xpath("//input[@name='DATE_FROM']"));
        startDate.click(); // opens the calendar

        Thread.sleep(1000);

        //choosing month from the calendar
        WebElement startCalendarMonth = driver.findElement(By.className("bx-calendar-top-month"));
        startCalendarMonth.click();
        Thread.sleep(1000);
        WebElement startMonth = driver.findElement(By.xpath("//span[@data-bx-month='6']"));
        startMonth.click();

        //choosing year from the calendar
        WebElement startCalendarYear = driver.findElement(By.className("bx-calendar-top-year"));
        startCalendarYear.click();
        Thread.sleep(1000);
        WebElement startYear = driver.findElement(By.xpath("//span[@data-bx-year='2025']"));
        startYear.click();
    }

    @Then("Event should be displayed correctly and should be same with event name {string} and event details {string}")
    public void event_should_be_displayed_correctly_and_should_be_same_with_event_name_and_event_details(String string, String string2) {
        String expectedEventName = string;
        String expectedEventDetails = string2;

        WebElement eventName = driver.findElement(By.xpath("(//td[@class = 'feed-calendar-view-text-cell-r'])[1]//a[@id]"));
        String actualEventName = eventName.getText();

        WebElement eventDescription = driver.findElement(By.xpath("//div[@class='feed-calendar-view-description']"));
        System.out.println(eventDescription.getText());
        String unparsedEventDescription = eventDescription.getText();
        String actualEventDetails = unparsedEventDescription.replace("Event description:\n", "");
        System.out.println("\nActual Event : " + actualEventDetails);

        Assert.assertEquals(expectedEventName,actualEventName);
        Assert.assertEquals(expectedEventDetails,actualEventDetails);





    }




}
