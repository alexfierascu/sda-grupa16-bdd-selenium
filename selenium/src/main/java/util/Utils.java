package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utils {

  static WebDriver driver;

  public static boolean checkThatElementIsNotDisplayed(By locatorKey) {
    try {
      driver.findElement(locatorKey);
      return true;
    } catch (org.openqa.selenium.NoSuchElementException e) {
      return false;
    }
  }

}
