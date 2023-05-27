package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginPageStepDef {

    WebDriver driver = null;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa.azulcrm.com/");
    }
    @When("the user enters a valid {string} and {string}")
    public void the_user_enters_a_valid_and(String string, String string2) {
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys(string);
        driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys(string2);
    }
    @When("clicks the login button")
    public void clicks_the_login_button() throws InterruptedException {
        driver.findElement(By.xpath("//input[@class='login-btn']")).click();
        Thread.sleep(5000);
    }
    @Then("the user is successfully redirected to the home page")
    public void the_user_is_successfully_redirected_to_the_home_page() throws InterruptedException {
        Boolean x = driver.findElement(By.xpath("//div[@id='pagetitle']")).isDisplayed();
        Assert.assertTrue(x);
        Thread.sleep(3000);
        driver.quit();
    }

    @When("the user enters an invalid {string} or {string}")
    public void the_user_enters_an_invalid_or(String string, String string2) {
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys(string);
        driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys(string2);
    }

    @Then("the user sees the error message {string}")
    public void the_user_sees_the_error_message(String string) {
        String expectedErrorMessage = "Incorrect login or password";
        WebElement actualErrorMessage = driver.findElement(By.xpath("//div[@class='errortext']"));

        Assert.assertEquals(expectedErrorMessage,actualErrorMessage.getText());
    }

}
