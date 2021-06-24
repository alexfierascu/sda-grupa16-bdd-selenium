package depurtat.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

  private WebDriver driver;

  public AccountPage(WebDriver driver) {
    this.driver=driver;
    PageFactory.initElements(driver,this);
  }

  private String titleUserLoggedIn = "dEpurtat - Vizualizare cont";

  public boolean verifyThatUserHasLoggedIn() {
    if(driver.getTitle().equals(titleUserLoggedIn)) {
      return true;
    } else  {
      return false;
    }
  }

}
