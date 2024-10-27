package Testcase;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Pageobject.Loginpage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import Utilities.Readconfig;

@Listeners(TestNGListener.class)
public class Testdata extends Base {
    Readconfig config = new Readconfig();

    @Test(priority = 1)
    public void data() throws InterruptedException {
        Loginpage lp1 = new Loginpage(driver);
        lp1.clickproductlink();
        Thread.sleep(3000);
        lp1.clickAddproduct();
        Thread.sleep(3000);
        WebElement remove = driver.findElement(By.id("remove"));
        Assert.assertTrue(remove.isDisplayed());
    }

    @Test(priority = 2)
    public void payment() throws InterruptedException, IOException {
        Loginpage lp1 = new Loginpage(driver);
        lp1.clickAddcarticon();
        Thread.sleep(3000);
        lp1.ccheckout();
        Thread.sleep(3000);
        lp1.fname(config.Fname());
        Thread.sleep(3000);
        lp1.lname(config.Lname());
        Thread.sleep(3000);
        lp1.zipcode(config.Zipcode());
        Thread.sleep(3000);
        lp1.conting();
        Thread.sleep(3000);
        lp1.Finish();
        Thread.sleep(5000);
        lp1.capturescreenshot("payment_method");
        Thread.sleep(3000);
        lp1.backtoproduct();
        Thread.sleep(3000);
    }

    @Test(priority = 3)
    public void dropdown() throws InterruptedException {
        Loginpage lp1 = new Loginpage(driver);
        Thread.sleep(3000);
        lp1.filterAndAssertAllOptions();
        Thread.sleep(3000);
    }
}
