package cadastro.test.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PageObject {

    protected WebDriver browser;

    public PageObject(WebDriver browser){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        if(browser == null){
           this.browser = new ChromeDriver();
        }else{
            this.browser = browser;
        }
        this.browser.manage().timeouts()
                .implicitlyWait(5, TimeUnit.SECONDS);
//        função serve para limitar as espera dos testes
    }

    public void fechar(){

        this.browser.quit();
    }
}
