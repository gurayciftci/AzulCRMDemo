package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
    }



}
