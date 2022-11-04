import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

abstract class BaseTest {

   protected WebDriver driver = new ChromeDriver();

    static {
        System.setProperty("webdriver.chrome.driver", "/Users/eapiskunova/Dev/chromedriver");
    }

   @BeforeMethod
    private void beforeMethod (){
       driver = BaseUtils.createDriver();
   }

   @AfterMethod
    private void afterMethod (){
       driver.quit();
   }

   protected WebDriver getDriver (){
       return  driver;
   }
}
