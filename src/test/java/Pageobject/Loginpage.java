package Pageobject;

import static org.testng.Assert.assertEquals;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Loginpage {
    WebDriver ldriver;

    public Loginpage(WebDriver rdriver) {
    	
    	
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(name = "user-name")
    WebElement txtUsername;

    @FindBy(name = "password")
    WebElement txtPassword;

    @FindBy(name = "login-button")
    WebElement btnLogin;

    @FindBy(id = "item_4_title_link")
    WebElement productlink;

    @FindBy(xpath = "(//button[contains(text(),\"Add\")])[1]")
    WebElement Addtocart;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    WebElement Addtocarticon;

    @FindBy(id = "checkout")
    WebElement check;

    @FindBy(name = "firstName")
    WebElement fname;

    @FindBy(name = "lastName")
    WebElement lname;

    @FindBy(name = "postalCode")
    WebElement zip;

    @FindBy(xpath = "//*[@id=\"continue\"]")
    WebElement contin;

    @FindBy(name = "finish")
    WebElement Finish;

    @FindBy(name = "back-to-products")
    WebElement backtoproduct;

    @FindBy(name = "back-to-products")
    WebElement back;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div/span/select")
    WebElement filt;
    
    @FindBy(xpath = "(//button[contains(text(),'Remove')])[1]")
    WebElement remove;

    
    public void verifyDelete() {
    	Assert.assertTrue(remove.isDisplayed());
    }
    
    
    public void setUserName(String uName) {
        txtUsername.sendKeys(uName);
    }

    public void setPassword(String pass) {
        txtPassword.sendKeys(pass);
    }

    public void clickLogin() {
        btnLogin.click();
    }

    public void clickproductlink() {
        productlink.click();
    }

    public void clickAddproduct() {
        Addtocart.click();
    }

    public void clickAddcarticon() {
        Addtocarticon.click();
    }

    public void ccheckout() {
        check.click();
    }

    public void fname(String Fname) {
        fname.sendKeys(Fname);
    }

    public void lname(String Lname) {
        lname.sendKeys(Lname);
    }

    public void zipcode(String Zip) {
        zip.sendKeys(Zip);
    }

    public void conting() {
        contin.click();
    }

    public void Finish() {
        Finish.click();
    }

    public void backtoproduct() {
        backtoproduct.click();
    }
    
    public void backhome() {
        back.click();
    }

    public void filterAndAssertAllOptions() {
        Select drop = new Select(filt);
        List<String> originalList = new ArrayList<>();
        List<WebElement> options = drop.getOptions();

        for (WebElement option : options) {
            originalList.add(option.getAttribute("value"));
        }

        for (String value : originalList) {
            drop.selectByValue(value);
            assertEquals(value, drop.getFirstSelectedOption().getAttribute("value"));
        }
    }
    public void capturescreenshot(String screenshotName) throws IOException {
        // Generate timestamp for unique screenshot names
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        
        // Capture the screenshot
        TakesScreenshot sc = ((TakesScreenshot) ldriver);
        File src = sc.getScreenshotAs(OutputType.FILE);
        
        // Define the destination path relative to the user directory
        String destinationPath = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + "_" + timestamp + ".png";
        File f2 = new File(destinationPath);
        
        // Copy the screenshot file to the destination
        FileUtils.copyFile(src, f2);
    }
}

