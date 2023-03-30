import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    ChromeDriver driver;

    LoginPage loginPage;

    @BeforeMethod
    public void SetUp(){
        driver = openBrowser();
        loginPage = new LoginPage(driver);

    }
    @Test
    public void LoginOnPage(){
        loginPage.Login("Admin", "admin123");
        Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
    }
    @Test
    public void NoLoginOnPage() {
        loginPage.Login("", "");
        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    @Test
    public void LoginWithNoValidData() {
        loginPage.Login("Admin", "admin");
        Assert.assertEquals(loginPage.error(), "Invalid credentials");
    }
    @AfterMethod
    public void After(){
        driver.quit();
    }
}
