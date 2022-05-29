package waits;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.Config;

@Slf4j
public class CustomWait {

    private WebDriver driver;
    private WebDriverWait wait;


    public CustomWait (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Config.CUSTOM_WAIT);
    }

    public WebElement toBeClickable(WebElement element){
        log.info("Waiting for the element " + element + " to be clickable.");
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void toBeVisible(WebElement element){
        log.info("Waiting for the element " + element + " to be visible.");
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
