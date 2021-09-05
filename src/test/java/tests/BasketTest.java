package tests;

import functionalLibrary.CommonFunctions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;


public class BasketTest extends CommonFunctions {

  @Before
    public void beforeTest()
    {
        openBrowser();
        driver.get("https://www.amazon.co.uk/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    @Test
    public void addingItemInTheBasket() {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("teddy bear");
        driver.findElement(By.id("nav-search-submit-button")).click();
        String expectedResultTitle = "teddy bear";
        String acctualResultTitle = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]")).getText();
        Assert.assertEquals(expectedResultTitle, acctualResultTitle);
        driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[2]/div/span/div/div/div/div/div[2]/div[1]/h2/a/span")).click();
        driver.findElement(By.id("add-to-cart-button")).click();
        driver.findElement(By.id("nav-cart-count")).click();
        WebElement addedItemtoBasketText = driver.findElement(By.xpath("//*[@id=\"huc-v2-order-row-confirm-text\"]/h1"));
        Assert.assertTrue(addedItemtoBasketText.isDisplayed());


    }
@Test
    public void addingMultipleItemsToBasket()
    {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("teddy bear");
        driver.findElement(By.id("nav-search-submit-button")).click();
        String expectedResultTitle1 = "teddy bear";
        String acctualResultTitle1 = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]")).getText();
        Assert.assertEquals(expectedResultTitle1, acctualResultTitle1);
        driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[2]/div/span/div/div/div/div/div[2]/div[1]/h2/a/span")).click();
        driver.findElement(By.id("add-to-cart-button")).click();
        driver.findElement(By.id("nav-cart-count")).click();
        WebElement addedItemtoBasketText = driver.findElement(By.xpath("//*[@id=\"huc-v2-order-row-confirm-text\"]/h1"));
        Assert.assertTrue(addedItemtoBasketText.isDisplayed());
        driver.findElement(By.xpath("//*[@id=\"attach-close_sideSheet-link\"]")).click();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobile");
        driver.findElement(By.id("nav-search-submit-button")).click();
        String expectedResultTitle2 = "mobile";
        String acctualResultTitle2 = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]")).getText();
        Assert.assertEquals(expectedResultTitle2, acctualResultTitle2);
        driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[5]/div/span/div/div/div[2]/div[2]/div/div/div[1]/h2/a/span")).click();
        driver.findElement(By.xpath("//*[@id=\"quantity\"]")).click();
        driver.findElement(By.id("quantity")).click();
        driver.findElement(By.name("submit.add-to-cart")).click();
        WebElement addExtraProtectionPage = driver.findElement(By.xpath("//*[@id=\"attach-warranty-display\"]/h1"));
        Assert.assertTrue(addExtraProtectionPage.isDisplayed());
        driver.findElement(By.xpath("//*[@id=\"attachSiNoCoverage\"]/span/input")).click();
        WebElement addedBasketPage = driver.findElement(By.className("a-alert-heading"));
        Assert.assertTrue(addedBasketPage.isDisplayed());


    }

@Test
    public void updateItemInBasket()
    {
         driver.findElement(By.id("twotabsearchtextbox")).sendKeys("teddy bear");
        driver.findElement(By.id("nav-search-submit-button")).click();
        String expectedResultTitle1 = "teddy bear";
        String acctualResultTitle1 = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]")).getText();
        Assert.assertEquals(expectedResultTitle1, acctualResultTitle1);
        driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[2]/div/span/div/div/div/div/div[2]/div[1]/h2/a/span")).click();
        driver.findElement(By.id("add-to-cart-button")).click();
        driver.findElement(By.id("nav-cart-count")).click();
        WebElement addedItemtoBasketText = driver.findElement(By.xpath("//*[@id=\"huc-v2-order-row-confirm-text\"]/h1"));
        Assert.assertTrue(addedItemtoBasketText.isDisplayed());
        driver.findElement(By.xpath("//*[@id=\"attach-close_sideSheet-link\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"nav-cart-count-container\"]/span[2]")).click();
        WebElement opensBasketPage;
        opensBasketPage = (WebElement) driver.findElements(By.xpath("//*[@id=\"sc-active-cart\"]/div/div/div/h1"));
        Assert.assertTrue(opensBasketPage.isDisplayed());
        driver.findElement(By.className("a-button-text a-declarative")).click();
        driver.findElement(By.id("quantity_3")).click();

    }
@Test
    public void deleteItemsInBasket()
    {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("toys");
        driver.findElement(By.id("nav-search-submit-button")).click();
        driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[15]/div/span/div/div/div[2]/div[1]/h2/a/span")).click();
        driver.findElement(By.id("add-to-cart-button")).click();
        driver.findElement(By.id("nav-cart-count")).click();
       // driver.findElement(By.xpath("//*[@id=\"attach-close_sideSheet-link\"]")).click();//
        driver.findElement(By.xpath("//*[@id=\"nav-cart-count-container\"]/span[2]")).click();
        WebElement opensBasketPage = (WebElement) driver.findElements(By.xpath("//*[@id=\"sc-active-cart\"]/div/div/div/h1"));
        Assert.assertTrue(opensBasketPage.isDisplayed());
        driver.findElement(By.xpath("//*[@id=\"sc-item-C4447fc11-5f3f-4b44-9537-ee7262096d54\"]/div[4]/div/div[2]/div[1]/span[2]/span/input")).click();
        String ExpectingMessage = "Your Amazon Basket is empty.";
        String acctualMessage = driver.findElement(By.xpath("//*[@id=\"sc-active-cart\"]/div/div/div/h1")).getText();
        Assert.assertEquals(ExpectingMessage, acctualMessage);

    }
    @After
    public void afterTest()
    {
        driver.quit();
    }
}
