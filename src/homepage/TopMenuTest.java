package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TopMenuTest extends Utility {

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @After
    public void tearDown(){
       // closeBrowser();
    }
    public void selectMenu(String menu) {

        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']/li/a[text() ='" + menu + "']"));
    }
    @Test
    public void verifyPageNavigation(){

        selectMenu("Computers ");
        String expectedText= "Computers";
        String actualText= driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(expectedText,actualText);
    }

}
