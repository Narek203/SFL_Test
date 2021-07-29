package pom;

import engine.BaseTest;
import org.openqa.selenium.*;

import java.util.List;

public class CareersPage extends TopMenu {
    private By job = By.className("s-careers-title");

    public List<WebElement> getAllJobs() {
        return BaseTest.driver.findElements(job);
    }

    public JobPage ClickOnJob(String jobTitle) {
        for (WebElement item : getAllJobs()) {
            if (item.getText().toLowerCase().contains(jobTitle.toLowerCase())) {
                item.click();
                return new JobPage();
            }
        }
        throw new IllegalArgumentException("There is no '" + jobTitle + " ' menu item.");
    }


}
