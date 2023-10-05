package modules.login;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import java.time.Duration;

@DisplayName("Login WEB Tests")
public class LoginTest {
    private WebDriver browser = new ChromeDriver();

    @BeforeEach()
    public void beforeEach(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        this.browser.manage().window().maximize();
        this.browser.get("https://the-internet.herokuapp.com/login");
        this.browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    @DisplayName("Verify if user can sign in successfully")
    public void testLoginSuccessfully() {
        String message = new LoginPage(browser)
                .fillUsername("tomsmith")
                .fillPassword("SuperSecretPassword!")
                .submitLoginSuccessfully()
                .getPageMessage();
        Assertions.assertTrue(message.contains("You logged into a secure area!"));
    }

    @Test
    @DisplayName("Verify if error message is displayed")
    public void testLoginErrorMessage() {
        String message = new LoginPage(browser)
                .fillUsername("admin")
                .fillPassword("admin")
                .submitLogin()
                .getPageMessage();
        Assertions.assertTrue(message.contains("Your username is invalid!"));
    }

    @AfterEach()
    public void afterEach(){
        browser.quit();
    }
}
