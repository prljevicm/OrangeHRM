import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public ChromeDriver openBrowser()
    {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //ucitavanje selektora do 10 sek
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));  //ucitavanje strane do 10 sek
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
        return driver;
    }
}
