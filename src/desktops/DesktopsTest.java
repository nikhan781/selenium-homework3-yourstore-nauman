package desktops;

import Utilities.Utility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DesktopsTest extends Utility {
    @Before
    public void browserOpening() {
        browserSetup("http://tutorialsninja.com/demo/index.php", "Chrome");
    }

    //Test 1
    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
        Thread.sleep(1000);
        //1.1 Mouse hover on Desktops Tab.and click
        hoverMousePointer(By.xpath("//ul[@class='nav navbar-nav']/li[1]"));
        //1.2 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[contains(text(),'Show All Desktops')]"));
        //1.3 Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Model (Z - A)");
        //1.4 Verify the Product will arrange in Descending order.
        verifyTextFromElements(By.xpath("//option[contains(text(),'Model (Z - A)')]"), "Model (Z - A)");
    }

    //Test 2
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        Thread.sleep(1000);
        //choose currency in £
        clickOnElement(By.xpath("//span[contains(text(),'Currency')]"));
        clickOnElement(By.xpath("//button[contains(text(),'£ Pound Sterling')]"));

        //2.1 Mouse hover on Desktops Tab. and click
        hoverMousePointer(By.xpath("//ul[@class='nav navbar-nav']/li[1]"));
        //2.2 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[contains(text(),'Show All Desktops')]"));
        //2.3 Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Model (A - Z)");
        //2.4 Select product “HP LP3065”
        clickOnElement(By.xpath("//a[contains(text(),'HP LP3065')]"));
        //2.5 Verify the Text "HP LP3065"
        verifyTextFromElements(By.xpath("//h1[contains(text(),'HP LP3065')]"), "HP LP3065");
        //2.6 Select Delivery Date "2022-11-30"
        String year = "2022";
        String month = "November";
        String date = "30";

        clickOnElement(By.xpath("//body/div[@id='product-product']/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/span[1]/button[1]/i[1]"));

        while (true) {
            String monthYear = driver.findElement(By.xpath("//div[@class='datepicker']/div[1]/table/thead/tr[1]/th[2]")).getText();

            //Splitting year and month Nov 2022
            String arr[] = monthYear.split(" ");
            //Actual dates
            String mon = arr[0];
            String yer = arr[1];

            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class='datepicker']/div[1]/table/thead/tr[1]/th[3]"));
            }

        }
        //Select Date
        List<WebElement> allDates = driver.findElements(By.xpath("//div[@class='datepicker']//div//table//td"));
        for (WebElement dt : allDates) {
            if (dt.getText().equalsIgnoreCase(date)) {
                dt.click();
                break;
            }
        }

            //2.7.Enter Qty "1” using Select class.
            //2.8 Click on “Add to Cart” button
            clickOnElement(By.xpath("//button[@id='button-cart']"));
            //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
            verifyTextFromElements(By.xpath("//div[@class='alert alert-success alert-dismissible']"), "Success: You have added HP LP3065 to your shopping cart!\n" +
                    "×");
            //2.10 Click on link “shopping cart” display into success message
            clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
            Thread.sleep(1000);

            //2.11 Verify the text "Shopping Cart"
            verifyTextFromElements(By.xpath("//h1[contains(text(),' (1.00kg)')]"), "Shopping Cart  (1.00kg)");
            //2.12 Verify the Product name "HP LP3065"
            verifyTextFromElements(By.xpath("//div[@class='table-responsive']/table/tbody/tr/td[2]/a"), "HP LP3065");
            //2.13 Verify the Delivery Date "2022-11-30"
            verifyTextFromElements(By.xpath("//small[contains(text(),'Delivery Date: 2022-11-30')]"), "Delivery Date: 2022-11-30");
            //2.14 Verify the Model "Product21"
            verifyTextFromElements(By.xpath("//td[contains(text(),'Product 21')]"), "Product 21");
            //2.15 Verify the Todat "£74.73"
            verifyTextFromElements(By.xpath("//div[@class='table-responsive']/table/tbody/tr/td[6]"), "£74.73");

        }

    @After
    public void closeTheBrowser() {
        closingTheBrowserBaseTest();
    }
}
