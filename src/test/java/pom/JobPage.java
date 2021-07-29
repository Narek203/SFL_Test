package pom;

import engine.BaseTest;
import engine.Helper;
import org.openqa.selenium.By;

import java.io.File;

public class JobPage {


    private By apply = By.cssSelector("#\\36 204 > button");
    private By firstName = By.cssSelector("#wpcf7-f3772-o2 > form > div:nth-child(2) > div.s-send-resume > div:nth-child(3) > div:nth-child(1) > div > span > input");
    private By lastName = By.cssSelector("#wpcf7-f3772-o2 > form > div:nth-child(2) > div.s-send-resume > div:nth-child(3) > div:nth-child(2) > div > span > input");
    private By eMail = By.cssSelector("#wpcf7-f3772-o2 > form > div:nth-child(2) > div.s-send-resume > div:nth-child(4) > div > span > input");
    private By submit = By.cssSelector("#wpcf7-f3772-o2 > form > div:nth-child(2) > div.s-send-resume > div:nth-child(6) > input");
    private By chooseFile = By.cssSelector("#wpcf7-f3772-o2 > form > div:nth-child(2) > div.s-send-resume > div:nth-child(5) > p > span > div > input");


    public void setFirstName(String firstName) {
        Helper.ScrollBefore(this.firstName);
        BaseTest.driver.findElement(this.firstName).sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        Helper.ScrollBefore(this.lastName);
        BaseTest.driver.findElement(this.lastName).sendKeys(lastName);
    }

    public void setEMail(String eMail) {
        Helper.ScrollBefore(this.eMail);
        BaseTest.driver.findElement(this.eMail).sendKeys(eMail);
    }

    public void setChooseFile(String CVPath) {
        Helper.ScrollBefore(this.chooseFile);
        File file = new File(CVPath);
        BaseTest.driver.findElement(chooseFile).sendKeys(file.getAbsolutePath());
    }

    public void ClickOnSubmit() {
        Helper.ScrollBefore(this.submit);
        BaseTest.driver.findElement(this.submit).click();
    }

    public void ClickOnApply() {
        BaseTest.driver.findElement(apply).click();
    }

    public void sendCV(String name, String lastName, String eMail, String CVPath) {

        setFirstName(name);
        setLastName(lastName);
        setEMail(eMail);
        setChooseFile(CVPath);
        ClickOnSubmit();
    }

}
