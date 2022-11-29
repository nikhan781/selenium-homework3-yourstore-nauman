package homepackage;

import Utilities.Utility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TopMenuTest extends Utility {
    @Before
    public void browserOpening() {
        browserSetup("http://tutorialsninja.com/demo/index.php", "Chrome");
    }

    //1.1 and 1.2 Creating a method with one parameter
    public void selectMenu(String menu) {
        if (menu.equalsIgnoreCase("Show All Desktops")) {
            clickOnElement(By.xpath("//a[contains(text(),'Show All Desktops')]"));
            verifyTextFromElements(By.xpath("//h2[contains(text(),'Desktops')]"), "Desktops");
        } else if (menu.equalsIgnoreCase("Show All Laptops & Notebooks")) {
            clickOnElement(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"));
            verifyTextFromElements(By.xpath("//h2[contains(text(),'Laptops & Notebooks')]"), "Laptops & Notebooks");
        } else if (menu.equalsIgnoreCase("Show All Components")) {
            clickOnElement(By.xpath("//a[contains(text(),'Show All Components')]"));
            verifyTextFromElements(By.xpath("//h2[contains(text(),'Components')]"), "Components");
        }

    }

    //Test 1
    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() throws InterruptedException {
        Thread.sleep(1000);
        //1.1 Mouse hover on “Desktops” Tab and click
        hoverMousePointer(By.xpath("//div[@class='collapse navbar-collapse navbar-ex1-collapse']/ul/li[1]"));
        //1.2 - 1.3 call selectMenu method and pass the menu = “Show All Desktops” and Verify the text ‘Desktops’
        selectMenu("Show All Desktops");
    }

    //Test 2
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() throws InterruptedException {
        Thread.sleep(1000);
        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        hoverMousePointer(By.xpath("//div[@class='collapse navbar-collapse navbar-ex1-collapse']/ul/li[2]"));

        //2.2 - 2.3 call selectMenu method and pass the menu = “Show All Laptops & Notebooks” and Verify the text ‘Laptops & Notebooks’
        selectMenu("Show All Laptops & Notebooks");

    }

    //Test 3
    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() throws InterruptedException {
        Thread.sleep(1000);
        //3.1 Mouse hover on “Components” Tab and click
        hoverMousePointer(By.xpath("//div[@class='collapse navbar-collapse navbar-ex1-collapse']/ul/li[3]"));

        //3.2 -3.3 call selectMenu method and pass the menu = “Show All Components” and Verify the text ‘Components’
        selectMenu("Show All Components");
        //verifyTextFromElements(By.xpath("//h2[contains(text(),'Components')]"), "Components");

    }


    @After
    public void closeTheBrowser() {
        closingTheBrowserBaseTest();
    }
}
