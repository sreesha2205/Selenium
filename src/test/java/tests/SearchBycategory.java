package tests;

import functionalLibrary.CommonFunctions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;


public class SearchBycategory extends CommonFunctions {

    @Before
    public void beforeTest()
    {
        openBrowser();
        driver.get("https://www.amazon.co.uk/");

    }

    @Test
    public void SearchByCategory()
    {
        driver.findElement(By.id("searchDropdownBox")).click();
        driver.findElement(By.id("searchDropdownBox")).click();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("selenium webdriver");
        driver.findElement(By.id("nav-search-submit-button")).click();
        String expectedSearchTitle = "selenium webdriver";
        String acctualSearchTitle = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]")).getText();
        Assert.assertEquals(expectedSearchTitle, acctualSearchTitle);
    }

    @After
    public void afterTest()
    {
        driver.close();
    }
}
