import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FirstTest extends BaseTest {

            @BeforeAll
        public static void setDriver() {
            WebDriverManager.chromedriver().setup();
        }

        @BeforeEach
        public void setup() {
            driver = new ChromeDriver();
        }

    @AfterClass
    public void quit() {
        driver.quit();
    }

    @Test
    public void eightComponents() {
        driver.get("https://openweathermap.org/guide");
        getDriver().manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        getDriver().findElement(By.xpath("//div[@id='support-dropdown']")).click();
        getDriver().findElement(By.xpath("//ul[@class='dropdown-menu dropdown-visible']")).isDisplayed();
        getDriver().findElement(By.xpath("//div//ul[@id='support-dropdown-menu']//li//a[contains(text(), 'Ask a question')]")).click();
        List<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        Assert.assertEquals(tabs.size(), 2);
        getDriver().switchTo().window(tabs.get(1));
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("question_form_email")));
        String currentUrl = getDriver().getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://home.openweathermap.org/questions");
    }
}