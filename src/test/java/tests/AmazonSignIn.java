package tests;

import functionalLibrary.CommonFunctions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonSignIn  extends CommonFunctions
{
  @Before
    public void beforeTest()
    {
        openBrowser();
        driver.get("https://www.amazon.co.uk/");
    }
    @Test
    public void signIn()
    {
        driver.findElement(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]")).click();
       WebElement signInVerificationText = driver.findElement(By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div/div[1]/form/div/div/div/h1"));
        Assert.assertTrue(signInVerificationText.isDisplayed());
        driver.findElement(By.name("email")).sendKeys("sirihari2205@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
        WebElement passwordPage = driver.findElement(By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div/div/div/form/div/div[1]/div[1]/div[1]/label"));
        Assert.assertTrue(passwordPage.isDisplayed());
        driver.findElement(By.name("password")).sendKeys("sreesha789");
        driver.findElement(By.id("signInSubmit")).click();
    }
    @Test
    public void signInWithInvalidCredentials()
    {
        driver.findElement(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]")).click();
        WebElement signInVerificationText = driver.findElement(By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div/div[1]/form/div/div/div/h1"));
        Assert.assertTrue(signInVerificationText.isDisplayed());
        driver.findElement(By.name("email")).sendKeys("sirihari@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
        WebElement passwordPage = driver.findElement(By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div/div/div/form/div/div[1]/div[1]/div[1]/label"));
        Assert.assertTrue(passwordPage.isDisplayed());
        driver.findElement(By.name("password")).sendKeys("sreesha789");
        driver.findElement(By.id("signInSubmit")).click();
        String expectedErrorMessage = "Your password is incorrect";
        String acctualErrorMessage =   driver.findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span")).getText();
        Assert.assertEquals(expectedErrorMessage, acctualErrorMessage);


    }

    @After
    public void afterTest()
    {

    }
}
