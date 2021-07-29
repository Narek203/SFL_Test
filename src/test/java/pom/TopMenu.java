package pom;

import engine.BaseTest;
import org.openqa.selenium.By;

public class TopMenu {
    private By careers = By.id("menu-item-3337");
    private By blog = By.id("menu-item-4835");
    private By engineering = By.id("menu-item-5634");
    private By about = By.id("menu-item-3404");
    private By work = By.id("menu-item-3521");
    private By openPositionCount = By.className("job-count");
    private By logo = By.id("logo");


    public <T> T selectMenuItem(String itemName) {
        switch (itemName.toLowerCase()) {
            case "work":
                BaseTest.driver.findElement(work).click();
                return null;
            case "about":
                BaseTest.driver.findElement(about).click();
                return null;
            case "engineering":
                BaseTest.driver.findElement(engineering).click();
                return null;
            case "blog":
                BaseTest.driver.findElement(blog).click();
                return null;
            case "logo":
                BaseTest.driver.findElement(logo).click();
                return null;
            case "careers":
                BaseTest.driver.findElement(careers).click();
                return (T) (new CareersPage());
            default:
                throw new IllegalArgumentException("There is no '" + itemName + " ' menu item.");
        }
    }

    public int getNumberOfOpenPositions() {
        return Integer.parseInt(BaseTest.driver.findElement(openPositionCount).getText());
    }

}
