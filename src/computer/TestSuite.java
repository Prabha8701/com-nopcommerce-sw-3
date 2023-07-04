package computer;

import homepage.TopMenuTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TestSuite extends TopMenuTest {
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @After
    public void tearDown() {
        // closeBrowser();
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        //1.1 Click on Computer Menu.
        selectMenu("Computers ");

        //1.2 Click on Desktop
        clickOnElement(By.xpath("//a[@title='Show products in category Desktops']"));

        //1.3 1.3 Select Sort By position "Name: Z to A
        WebElement sortByElement = driver.findElement(By.xpath("//select[@id='products-orderby']"));
        Select select = new Select(sortByElement);
        select.selectByVisibleText("Name: Z to A");

        //1.4 Verify the Product will arrange in Descending order.


    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

        //2.1 Click on Computer Menu.
        clickOnElement(By.xpath("//a[@href='/computers']"));

        //2.2 Click on Desktop
        clickOnElement(By.xpath("//img[@alt='Picture for category Desktops']"));

        //2.3 Select Sort By position "Name: A to Z"
       selectByVisibleTextFromDropDown(By.name("products-orderby"), "Name: A to Z");
        Thread.sleep(1000);

        //2.4 Click on "Add To Cart"
        clickOnElement(By.xpath("(//button[@type='button'][normalize-space()='Add to cart'])[1]"));

        //2.5 Verify the Text "Build your own computer"
        String expectedText = "Build your own computer";
        String actualText = driver.findElement(By.xpath("//h1[contains(text(),'Build your own computer')]")).getText();
        Assert.assertEquals(expectedText, actualText);

        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByVisibleTextFromDropDown(By.id("product_attribute_1"), "2.2 GHz Intel Pentium Dual-Core E2200");

        //2.7.Select "8GB [+$60.00]" using Select class.
        selectByVisibleTextFromDropDown(By.id("product_attribute_2"), "8GB [+$60.00]");

        //2.8 Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.id("product_attribute_3_7"));

        //2.9 Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.id("product_attribute_4_9"));
        Thread.sleep(1000);

        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"

        clickOnElement(By.xpath("//input[@id='product_attribute_5_12']"));


        //2.11 Verify the price "$1,470.00"
        /*
        String expectedText1 = "$1,470.00";
        String actualText1 = driver.findElement(By.xpath("//span[@id='price-value-1']")).getText();
        Assert.assertEquals(expectedText1, actualText1);*/

        //2.12 Click on "ADD TO CARD" Button.
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));

        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green bar
        String expectedText2 = "The product has been added to your shopping cart";
        String actulText2 = driver.findElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]")).getText();
        Assert.assertEquals(expectedText2, actulText2);

        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));

        //2.14 Verify the message "Shopping cart"
        WebElement shoppingCart = driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]"));

        WebElement goToCart = driver.findElement(By.xpath("//button[contains(text(),'Go to cart')]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(shoppingCart).build().perform();
        goToCart.click();

        //2.15 Verify the message "Shopping cart"
        String expectedText3="Shopping cart";
        String actualText3= driver.findElement(By.xpath("//h1[contains(text(),'Shopping cart')]")).getText();
        Assert.assertEquals(expectedText3,actualText3);

        //2.16 Change the Qty to "2" and Click on "Update shopping cart"

        //WebElement qty=driver.findElement(By.xpath(""))

        driver.findElement(By.xpath("//input[@aria-label='Qty.']")).clear();
        driver.findElement(By.xpath("//input[@aria-label='Qty.']")).sendKeys("2");
        clickOnElement(By.xpath("//button[@id='updatecart']"));

        //2.17 Verify the Total"$2,950.00
        String expectedText4="$2,950.00";
        String actualText4=driver.findElement(By.xpath("//span[@class='value-summary']")).getText();
        Assert.assertEquals(expectedText4,actualText4);

        //2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //2.19 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //2.20 Verify the Text “Welcome, Please Sign In!”
        String expectedtText5="Welcome, Please Sign In!";
        String actualText5=driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]")).getText();
        Assert.assertEquals(expectedtText5,actualText5);

        //2.21Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));

        //2.22 2.22 Fill the all mandatory field
        sendTextToElement(By.id("BillingNewAddress_FirstName"),"Prime");
        sendTextToElement(By.id("BillingNewAddress_LastName"),"Patel");
        sendTextToElement(By.id("BillingNewAddress_Email"),"Primep100@gmail.com");
        sendTextToElement(By.id("BillingNewAddress_Company"),"Prime123");
        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_CountryId"),"United Kingdom");
        sendTextToElement(By.id("BillingNewAddress_City"),"London");
        sendTextToElement(By.id("BillingNewAddress_Address1"),"10 Downing street");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"),"SE15 7YN");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"),"123456789");

        //2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));

        //2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.id("shippingoption_1"));

        //2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("(//button[@class='button-1 shipping-method-next-step-button'])[1]"));

        //2.26
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));


        //2.27	Select “Master card” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Master card");

        // 2.28	Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Mr John Smith");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "5521573041475125");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "05");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2025");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "123");

        // 2.29	Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));

        // 2.30 Verify “Payment Method” is “Credit Card”
        String expectedText6 = "Credit Card";
        String actualText6 = getTextFromElement(By.xpath("//span[contains(text(),'Credit Card')]"));
        Assert.assertEquals("", expectedText6, actualText6);

        // 2.32	Verify “Shipping Method” is “Next Day Air”
        String expectedText7 = "Next Day Air";
        String actualText7 = getTextFromElement(By.xpath("//span[normalize-space()='Next Day Air']"));
        Assert.assertEquals("", expectedText7, actualText7);


        // 2.33	Verify Total is “$2,950.00”
        String expectedValue8 = "$2,940.00";
        Thread.sleep(5000);
        String actualValue8 = getTextFromElement(By.xpath("//span[@class='value-summary']"));
        Assert.assertEquals("", expectedValue8, actualValue8);

        //2.34	Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));


        // 2.35	Verify the Text “Thank You”
        String expectedText9 = "Thank you";
        String actualText9 = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        Assert.assertEquals("", expectedText9, actualText9);

        // 2.36	Verify the message “Your order has been successfully processed!”
        String expectedText10 = "Your order has been successfully processed!";
        String actualText10 = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals("", expectedText10, actualText10);


        // 2.37	Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

        // 2.37 Verify the text “Welcome to our store”
        String expectedText11 = "Welcome to our store";
        String actualText11 = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals("", expectedText11, actualText11);


    }
}
