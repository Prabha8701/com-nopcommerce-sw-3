package homepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;
    public static String baseUrl="https://demo.nopcommerce.com/";

    public void openBrowser(String baseUrl){

        //launch the chrome browser
        driver = new ChromeDriver();

        // open the url in to chrome (particular) browser
        driver.get(baseUrl);

        //maximise the browser
        driver.manage().window().maximize();

        //we give implicit wait to driver (time out)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void closeBrowser(){
        driver.quit();
    }
}
