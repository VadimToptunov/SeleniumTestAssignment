package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.CustomWait;

@Slf4j
public class HomePage {
    private static WebDriver driver;
    private static CustomWait customWait;

    @FindBy(id = "menu-item-127")
    private static WebElement careersMenu;
    @FindBy(id = "menu-item-131")
    private static WebElement vacanciesMenuItem;

    public HomePage(WebDriver driver) {
        HomePage.driver = driver;
        PageFactory.initElements(driver, this);
        customWait = new CustomWait(driver);
    }

    public static void findAndClickCareersMenu() {
        try{
            customWait.toBeClickable(careersMenu).click();
            log.info("The element \"Careers menu\" is found and clicked.");
        }catch (Exception ex){
            log.debug("The element \"Careers menu\" cannot be found.");
        }
    }

    public static void findAndClickVacanciesMenuItem() {
        try{
            customWait.toBeClickable(vacanciesMenuItem).click();
            log.info("The element \"Vacancies menu item\" is found and clicked.");
        }catch (Exception ex){
            log.debug("The element \"Vacancies menu item\" cannot be found.");
        }
    }
}
