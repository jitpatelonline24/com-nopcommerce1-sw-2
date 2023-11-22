package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Random;

public class RegisterTest extends BaseTest {

    static String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {
        //Click on the 'Register link
        driver.findElement(By.xpath("//a[@class= 'ico-register']")).click();
        //Verify the text ' Register'
        String expectedText = "Register";
        String actualText = driver.findElement(By.xpath("//h1[text()='Register']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() throws InterruptedException {
        // click on the 'register link
        driver.findElement(By.xpath("//a[@class= 'ico-register']")).click();
        //Select Gender radio button
        driver.findElement(By.xpath("//label[@for= 'gender-male']")).click();
        //Enter First name
        driver.findElement(By.id("FirstName")).sendKeys("Abcd");
        //Enter Last Name
        driver.findElement(By.id("LastName")).sendKeys("jkl");
        // Select Day Month and year
        driver.findElement(By.xpath("//select[@name = 'DateOfBirthDay']")).sendKeys("25");
        driver.findElement(By.xpath("//select[@name = 'DateOfBirthMonth']")).sendKeys("June");
        driver.findElement(By.xpath("//select[@name = 'DateOfBirthYear']")).sendKeys("1990");
        //enter Email Address
        Random randomGen = new Random();
        int randomInt = randomGen.nextInt();
        String randomEmail = "test" + randomGen.nextInt(1000) + "@gmail.com";
        driver.findElement(By.id("Email")).sendKeys(randomEmail);
        //Enter Password
        Thread.sleep(5000);
        driver.findElement(By.id("Password")).sendKeys("abcd123");
        //Enter Confirm password
        driver.findElement(By.id("ConfirmPassword")).sendKeys("abcd123");
        //Click on Register button
        driver.findElement(By.xpath("//button[@name = 'register-button']")).click();
        //verify the text ' Your registration completed'
        String actualText = driver.findElement(By.xpath("//div[@class = 'result']")).getText();
        String expectedText = "Your registration completed";
        Thread.sleep(5000);

        Assert.assertEquals(expectedText,actualText);
    }

    @After
    public void tearDown() {
        closedBrowser();
    }
}
