package laptopsandnotebooks;

import Utilities.Utility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LaptopsAndNotebooksTest extends Utility {
    @Before
    public void browserOpening() {
        browserSetup("http://tutorialsninja.com/demo/index.php", "Chrome");
    }

    //Test 1
    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        hoverMousePointer(By.xpath("//ul[@class='nav navbar-nav']/li[2]"));
        //1.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"));

        //1.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");

        //1.4 Verify the Product price will arrange in High to Low order.

    }

    //Test 2
    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        Thread.sleep(500);
        //2.1 - 2.3 Invoking test 1 method
        verifyProductsPriceDisplayHighToLowSuccessfully();
        //2.4 Select Product “MacBook”
        clickOnElement(By.xpath("//div[@id='content']/div[4]/div[4]/div/div[2]/div[1]/h4/a"));

        //2.5 Verify the text “MacBook”
        verifyTextFromElements(By.xpath("//h1[contains(text(),'MacBook')]"), "MacBook");
        //2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        verifyTextFromElements(By.xpath("//div[@class='alert alert-success alert-dismissible']"), "Success: You have added MacBook to your shopping cart!\n" +
                "×");

        //2.8 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        //2.9 Verify the text "Shopping Cart"
        verifyTextFromElements(By.xpath("//h1[contains(text(),' (0.00kg)')]"), "Shopping Cart  (0.00kg)");
        //2.10 Verify the Product name "MacBook"
        verifyTextFromElements(By.xpath("//div[@class='table-responsive']/table/tbody/tr/td[2]/a"), "MacBook");
        //2.11 Change Quantity "2"
        clearTheText(By.xpath("//div[@class='table-responsive']/table/tbody/tr/td[4]/div/input"));
        sendTextToElement(By.xpath("//div[@class='table-responsive']/table/tbody/tr/td[4]/div/input"), "2");
        //2.12 Click on “Update” Tab
        clickOnElement(By.xpath("//div[@class='table-responsive']/table/tbody/tr/td[4]/div/span/button[1]"));
        //2.13 Verify the message “Success: You have modified your shopping cart!”
        verifyTextFromElements(By.xpath("//div[@class='alert alert-success alert-dismissible']"), "Success: You have modified your shopping cart!\n" +
                "×");
        //2.14 Verify the Total $1,204.00
        verifyTextFromElements(By.xpath("//div[@class='table-responsive']/table/tbody/tr/td[6]"), "$1,204.00");

        //2.15 Click on “Checkout” button
        clickOnElement(By.xpath("//a[contains(text(),'Checkout')]"));
        //2.16 Verify the text “Checkout”
        verifyTextFromElements(By.xpath("//h1[contains(text(),'Checkout')]"), "Checkout");

        Thread.sleep(1000);
        //2.17 Verify the Text “New Customer”
        verifyTextFromElements(By.xpath("//h2[contains(text(),'New Customer')]"), "New Customer");

        //2.18 Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//div[@class='panel-group']/div[1]/div[2]/div/div/div[1]/div[2]/label/input"));

        //2.19 Click on “Continue” tab
        clickOnElement(By.xpath("//input[@id='button-account']"));

        //2.20 Fill the mandatory fields
        sendTextToElement(By.xpath("//input[@id='input-payment-firstname']"), "Bat");
        sendTextToElement(By.xpath("//input[@id='input-payment-lastname']"), "man");
        sendTextToElement(By.xpath("//input[@id='input-payment-email']"), "batman@gmail.com");
        sendTextToElement(By.xpath("//input[@id='input-payment-telephone']"), "020854685");
        sendTextToElement(By.xpath("//input[@id='input-payment-address-1']"), "1 Dark road");
        sendTextToElement(By.xpath("//input[@id='input-payment-city']"), "Nowhere");
        sendTextToElement(By.xpath("//input[@id='input-payment-postcode']"), "DA11RK");
        clickOnElement(By.xpath("//option[contains(text(),'United Kingdom')]"));
        clickOnElement(By.xpath("//option[contains(text(),'Greater London')]"));

        //2.21 Click on “Continue” Button
        clickOnElement(By.xpath("//input[@id='button-guest']"));

        //2.22 Add Comments About your order into text area
        sendTextToElement(By.xpath("//div[@class='panel-group']/div[3]/div[2]/div[1]/p[2]/textarea[1]"), "Please send it in a box");

        //2.23 Check the Terms & Conditions check box
        clickOnElement(By.name("agree"));

        //2.24 Click on “Continue” button
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));

        //2.25 Verify the message “Warning: Payment method required!”
        verifyTextFromElements(By.xpath("//div[@class='panel-group']/div[3]/div[2]/div/div[1]"), "Warning: No Payment options are available. Please contact us for assistance!");
    }

    @After
    public void closeTheBrowser() {
        closingTheBrowserBaseTest();
    }

}
