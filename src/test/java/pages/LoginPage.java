package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver browser;
    public LoginPage(WebDriver browser){
        this.browser = browser;
    }

    public LoginPage fillUsername(String username) {
        browser.findElement(By.id("username")).sendKeys(username);
        return this;
    }

    public LoginPage fillPassword(String password) {
        browser.findElement(By.id("password")).sendKeys(password);
        return this;
    }

    public String getPageMessage(){
        return browser.findElement(By.id("flash-messages")).getText();
    }
    public LoginPage submitLogin(){
        browser.findElement(By.cssSelector(".fa-sign-in")).click();
        return this;
    }

    public SecureAreaPage submitLoginSuccessfully(){
        browser.findElement(By.cssSelector(".fa-sign-in")).click();
        return new SecureAreaPage(browser);
    }
}
