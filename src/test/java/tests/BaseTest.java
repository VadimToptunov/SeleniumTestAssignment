package tests;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import testrules.ScreenshotCustomTestRule;

@Slf4j
public class BaseTest {

    public WebDriver driver;
    @RegisterExtension
    ScreenshotCustomTestRule testRule = new ScreenshotCustomTestRule();

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.get(Config.BASE_URL);
        log.info("Opening " + Config.BASE_URL);
    }

    @AfterEach
    public void tearDown(){
        try{
            driver.close();
            log.info("Closing browser.");
            driver.quit();
            log.info("Quitting browser.");
        } catch (Exception ex) {
            log.debug("Failed to perform the test. " + ex.getMessage());
            testRule.takeScreenshot(driver);
        }finally {
            driver.quit();
        }
    }
}
