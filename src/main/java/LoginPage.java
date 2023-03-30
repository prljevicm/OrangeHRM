import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    //Selektori

    @FindBy(name = "username")
    WebElement username;

    @FindBy(name= "password")
    WebElement password;

    @FindBy(css = ".orangehrm-login-button")
    WebElement loginButton;

    @FindBy(css = ".oxd-alert-content-text")
    WebElement errorMessage;

    //Konstruktor (uvek se unosi)

    public LoginPage(ChromeDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String error(){
        return errorMessage.getText();
    }
//akcija (unesi, klikni...)
    public void Login(String name, String pass)
    {
        username.sendKeys(name);
        password.sendKeys(pass);
        loginButton.submit();
    }
}
