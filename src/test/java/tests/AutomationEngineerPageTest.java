package tests;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.TestAutomationEngineerVacancyPage;
import pages.VacanciesPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pages.HomePage.findAndClickCareersMenu;
import static pages.HomePage.findAndClickVacanciesMenuItem;
import static pages.TestAutomationEngineerVacancyPage.findProfessionalSkillsParagraphAndCountSkills;
import static pages.VacanciesPage.findAndClickTestAutomationEngineerVacancyMenuItem;

@Slf4j
public class AutomationEngineerPageTest extends BaseTest {

    /**
     * 1. Log in to https://ctco.lv/en page
     * 2. Open Careers menu
     * 3. Click Vacancies from the list.
     * 4. Open vacancy with title "Test Automation Engineer"
     * 5. Verify that paragraph under Professional skills and qualification: contains exactly 5 skills.
     * (skills are separated by <br> tag)
     */
    @Test
    public void testAutomationEngineerSkillsAndQualificationTest(){
        int expectedNumberOfSkills = 5;
        new HomePage(driver);
        findAndClickCareersMenu();
        findAndClickVacanciesMenuItem();

        new VacanciesPage(driver);
        findAndClickTestAutomationEngineerVacancyMenuItem();

        new TestAutomationEngineerVacancyPage(driver);

        long actualNumberOfSkills = findProfessionalSkillsParagraphAndCountSkills();

        assertEquals(expectedNumberOfSkills, actualNumberOfSkills,
                "Number of skills is not equal to 5.");
    }
}
