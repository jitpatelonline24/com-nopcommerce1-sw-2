package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    static String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() throws InterruptedException {

        //Click on Login link
        driver.findElement(By.linkText("Log in")).click();
        //verify the text 'Welcome,Please sign In!
        String expectedText = "Welcome, Please Sign In!";
        WebElement actualTextResult=driver.findElement(By.xpath("//h1"));
        String actualText = actualTextResult.getText();
        Thread.sleep(5000);
        Assert.assertEquals("Not Redirected to Login Page: ", expectedText,actualText);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() throws InterruptedException {
        //click on the 'Login' link
        driver.findElement(By.linkText("Log in")).click();
        //Enter valid username
        driver.findElement(By.id("Email")).sendKeys("test326@gmail.com");
        //Enter valid password
        driver.findElement(By.name("Password")).sendKeys("abcd123");
        //click on Login button
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        Thread.sleep(5000);
        //Verify the Log out text is display
        String expectedText = "Log out";
        WebElement actualText = driver.findElement(By.xpath("//a[text()='Log out']"));
        actualText.getText();
        Assert.assertEquals(expectedText,actualText);

    }

    @Test
    public void verifyTheErrorMessage() throws InterruptedException {
        //Click on the "Login link
        driver.findElement(By.linkText("Log in")).click();
        //Enter invalid username
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("abc123@gmail.com");
        //Enter invalid password
        driver.findElement(By.name("Password")).sendKeys("Password");
        //Click on Login Button
        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
        // Verify the Error Message 'Login was unsuccessful.Please correct the errors and try again. No customer account found.
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        Thread.sleep(5000);
        // Find the error Message element and get the text
        String actualErrorMessage = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']")).getText();
        Assert.assertEquals("Error Message not displayed",expectedErrorMessage,actualErrorMessage);
    }
    @After
    public void tearDown() {
        closedBrowser();
    }

}
