package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage {
    private WebDriver browser;

    public SecureAreaPage(WebDriver browser){
        this.browser = browser;
    }

    public String getPageMessage(){
        return browser.findElement(By.id("flash-messages")).getText();
    }
}
