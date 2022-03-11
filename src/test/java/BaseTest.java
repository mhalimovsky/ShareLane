import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

/*
            37 #basket     | discount, %
            38 #-----------------------------
            39 #20 - 49    | 2
            40 #50 - 99    | 3
            41 #100-499    | 4
            42 #500-999    | 5
            43 #1000-4999  | 6
            44 #5000-9999  | 7
            45 #10000 and more | 8

     */

public class BaseTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        driver.quit();

    }
}

