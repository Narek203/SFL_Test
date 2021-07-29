package engine;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class Helper {
    static JavascriptExecutor js = (JavascriptExecutor) BaseTest.driver;

    public static void ScrollBefore(By element) {
        js.executeScript("arguments[0].scrollIntoView();", BaseTest.driver.findElement(element));
    }
}
