package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.CustomWait;

import java.util.List;

@Slf4j
public class TestAutomationEngineerVacancyPage {

    private WebDriver driver;
    private CustomWait customWait;

    @FindBy(css = "[data-href=\"https://ctco.lv/careers/vacancies/test-automation-engineer-3/\"] .text-block h1")
    private WebElement textHeader;

    @FindBy(css = "[data-href=\"https://ctco.lv/careers/vacancies/test-automation-engineer-3/\"] .wysiwyg-2 ul~ul")
    private List<WebElement> professionalSkillsParagraph;

    public TestAutomationEngineerVacancyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        customWait = new CustomWait(driver);
    }

    public long findProfessionalSkillsParagraphAndCountSkills() {

        try{
            customWait.toBeVisible(textHeader);
            log.info("Text header is successfully found.");
            long numberOfProfessionalSkills = professionalSkillsParagraph.size() + 1;
            log.info("Professional skills paragraph is found and the number of kills is " + numberOfProfessionalSkills);
            return numberOfProfessionalSkills;
        }catch (Exception ex){
            log.debug("Professional skills paragraph is not found: " + ex.getMessage());
        }
        return 0;
    }
}
