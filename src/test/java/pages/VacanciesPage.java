package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.CustomWait;

@Slf4j
public class VacanciesPage {

    private static WebDriver driver;
    private static CustomWait customWait;

    @FindBy(css = "li#menu-item-5079 a")
    private static WebElement testAutomationEngineerVacancy;

    public VacanciesPage(WebDriver driver) {
        VacanciesPage.driver = driver;
        PageFactory.initElements(driver, this);
        customWait = new CustomWait(driver);
    }

    public static void findAndClickTestAutomationEngineerVacancyMenuItem() {
        try{
            customWait.toBeClickable(testAutomationEngineerVacancy).click();
            log.info("The element \"Test Automation Engineer vacancy\" is found and clicked.");
        }catch (Exception ex){
            log.debug("The element \"Test Automation Engineer vacancy\" is not found: " + ex.getMessage());
        }
    }
}
