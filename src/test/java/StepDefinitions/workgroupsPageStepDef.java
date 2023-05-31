package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class workgroupsPageStepDef {

    WebDriver driver = null;

    @Given("User is in Workgroups and projects page")
    public void user_is_in_workgroups_and_projects_page() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa.azulcrm.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("hr4@cybertekschool.com");
        driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys("UserUser");
        driver.findElement(By.xpath("//input[@class='login-btn']")).click();
        Thread.sleep(2000);
        WebElement workgroupsLink = driver.findElement(By.partialLinkText("Workgroups"));
        workgroupsLink.click();
    }

    @When("User clicks to a group")
    public void user_clicks_to_a_group() {
        try {
            WebElement salesJoinButton = driver.findElement(By.xpath("//span[@id='bx-sonet-groups-request-3']"));
            salesJoinButton.click();
        } catch (NoSuchElementException e) {
            System.out.println("The group or project has already been joined.");
            request_has_been_sent_text_should_be_displayed();
        }
    }

    @Then("Request has been sent text should be displayed")
    public void request_has_been_sent_text_should_be_displayed() {
        WebElement salesRequestVerify = driver.findElement(By.xpath("//span[@id='bx-sonet-groups-request-sent-3']"));
        Boolean salesRequest = salesRequestVerify.isDisplayed();
        Assert.assertTrue(salesRequest);
    }

}
