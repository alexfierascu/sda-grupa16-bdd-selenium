package depurtat.util;

import depurtat.page.MainPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavigationUtils extends MainPage {

  private WebDriver driver;

  public NavigationUtils(WebDriver driver) {
    super(driver);
    this.driver = driver;
  }

  public void navigateToLoginPage() {
    getButtonLogin().click();
  }

  public void navigateToNoutatiPage() {
    getButtonNoutati().click();
  }

  public void navigateToFavouritePage() {
    getButtonFavorite().click();
  }

  public void scrollToElement(WebElement element) {
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
  }

}
