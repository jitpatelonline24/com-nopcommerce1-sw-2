package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TopMenuTest extends BaseTest {

    static String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToComputerPageSuccessfully() throws InterruptedException {
        // Click on the 'Computers tab
        driver.findElement(By.xpath("//a[text() = 'Computers ' ]")).click();

        //Verify the text ' Computers'
        String actualText  = driver.findElement(By.xpath("//h1[text() = 'Computers' ]")).getText();
        String expectedText = "Computers";
        Assert.assertEquals(expectedText,actualText);
        Thread.sleep(5000);
    }

    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully() throws InterruptedException {
        // Click on the ' Electronics Tab
        driver.findElement(By.xpath("//a[text() = 'Electronics ' ]")).click();
        //Verify the text ' Electronics'
        String expectedText = "Electronics";
        String actualText = driver.findElement(By.xpath("//h1[text() = 'Electronics' ]")).getText();
        Assert.assertEquals(expectedText,actualText);
        Thread.sleep(2000);

    }

    @Test
    public void userShouldNavigateToApparelPageSuccessfully() throws InterruptedException {
        //click on the 'Apparel tab
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text() = 'Apparel ']")).click();
        //Verify the text 'Apparel'
        String expectedText = "Apparel";
        String actualText=driver.findElement(By.xpath("//div[@class = 'page-title']")).getText();
        Assert.assertEquals(expectedText,actualText);
        Thread.sleep(5000);
    }

    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully() throws InterruptedException {
        //Click on the 'digital Downloads page
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text() = 'Digital downloads ']")).click();
        //Verify the text ' Digital Downloads'
        String expectedText = "Digital downloads";
        String actualText = driver.findElement(By.xpath("//div[@class = 'page-title']")).getText();
        Assert.assertEquals(expectedText,actualText);
        Thread.sleep(5000);
    }

    @Test
    public void userShouldNavigateToBooksPageSuccessfully() throws InterruptedException {
        //Click on the Books Page
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text() = 'Books ']")).click();
        //Verify the text 'books'
        String expectedText = "Books";
        String actualText = driver.findElement(By.xpath("//div[@class = 'page-title']")).getText();
        Assert.assertEquals(expectedText,actualText);
        Thread.sleep(5000);
    }

    @Test
    public void userShouldNavigateToJewelryPageSuccessfully() throws InterruptedException {
        //Click on the Jewelry Page
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text() = 'Jewelry ']")).click();
        //Verify the text ' Jewelry
        String expectedText = "Jewelry";
        String actualText = driver.findElement(By.xpath("//div[@class = 'page-title']")).getText();
        Assert.assertEquals(expectedText,actualText);
        Thread.sleep(5000);
    }

    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully() throws InterruptedException {
        //Click on the 'gift cards tab
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text() = 'Gift Cards ']")).click();
        // Verify the text ' Gift Cards'
        String expectedText = "Gift Cards";
        String actualText = driver.findElement(By.xpath("//div[@class = 'page-title']")).getText();
        Assert.assertEquals(expectedText,actualText);
        Thread.sleep(5000);
    }

    @After
    public void tearDown() {
        closedBrowser();
    }

}
