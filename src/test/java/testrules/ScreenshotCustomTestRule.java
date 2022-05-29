package testrules;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import tests.Config;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Timestamp;

@Slf4j
public class ScreenshotCustomTestRule implements TestWatcher {

    public void takeScreenshot(WebDriver driver) {
        String path = "target/surefire-reports";
        String fileName = Config.DATE_FORMAT.format(new Timestamp(System.currentTimeMillis()));
        try {
            if(Files.notExists(Path.of(path))) new File(path).mkdir();
            else {
                String fileNameScreenshot = String.format("%s%s_screenshot-%s.jpeg", path, File.separator, fileName);
                try (FileOutputStream out = new FileOutputStream(fileNameScreenshot)) {
                    out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
                }
                log.debug("Screenshot is successfully taken.");
            }
        } catch (IOException | WebDriverException e) {
            log.debug("Taking screenshot is failed:" + e.getMessage());
        }
    }
}
