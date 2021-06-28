package depurtat.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

  private WebDriver driver;

  public AccountPage(WebDriver driver) {
    this.driver=driver;
    PageFactory.initElements(driver,this);
  }

  private String titleUserLoggedIn = "dEpurtat - Vizualizare cont";
  @FindBy(xpath = "//*[@id=\"page_content\"]/div[4]/div[1]/div/ul/li[6]/a")
  WebElement buttonLogout;

  public boolean verifyThatUserHasLoggedIn() {
    if(driver.getTitle().equals(titleUserLoggedIn)) {
      return true;
    } else  {
      return false;
    }
  }

  public void logOut() {
    buttonLogout.click();
  }





}
