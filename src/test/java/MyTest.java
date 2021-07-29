import engine.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pom.CareersPage;
import pom.HomePage;
import pom.JobPage;

import java.io.File;
import java.util.List;

public class MyTest extends BaseTest {

    @Test(priority = 0)
    public void TestAreCareersCountEqualsTheCountOfTheOpenVacancies() {
        HomePage homePage = new HomePage();
        int openPositionCountOnHomePage = homePage.getNumberOfOpenPositions();
        CareersPage careersPage = homePage.<CareersPage>selectMenuItem("careers");
        List<WebElement> jobsList = careersPage.getAllJobs();
        int openPositionsCountOnCareerPage = jobsList.size();
        Assert.assertEquals(openPositionsCountOnCareerPage, openPositionCountOnHomePage);
    }

    @Test(priority = 1)
    public void TestThatNoManualQAVacancy() {
        CareersPage careersPage = new CareersPage();
        List<WebElement> jobsList = careersPage.getAllJobs();
        Assert.assertFalse(jobsList.stream().anyMatch(
                p -> p.getText().toLowerCase().contains("manual qa")), "There is a vacancy for 'Manual QA Engineer'");
    }

    @Test(priority = 2)
    public void TestThatThereIsAAutomationQAVacancy() {
        CareersPage careersPage = new CareersPage();
        List<WebElement> jobList = careersPage.getAllJobs();
        Assert.assertTrue(jobList.stream().anyMatch(
                p -> p.getText().toLowerCase().contains("automation")), "There is no vacancy for 'Automation QA Engineer'");
    }

    @Test(priority = 3)
    public void FillTheForm() {
        CareersPage careersPage = new CareersPage();
        JobPage jobPage = careersPage.ClickOnJob("automation");
        jobPage.sendCV("test", "test", "test@test.com", "src\\main\\resources\\test.pdf");
    }


}
