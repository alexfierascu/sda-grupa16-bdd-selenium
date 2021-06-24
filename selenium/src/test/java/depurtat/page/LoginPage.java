package depurtat.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

  private WebDriver driver;

  public LoginPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  private String titleLoginPage = "Acces cont - dEpurtat";


  @FindBy(id = "profile_email")
  private WebElement inputEmailAddress;
  @FindBy(id = "profile_password")
  private WebElement inputPasswordField;
  @FindBy(xpath = "//*[@id=\"page_login_form\"]/div[4]/button")
  private WebElement buttonAccesCont;
  @FindBy(xpath = "//*[@id=\"page_login_form\"]/div[3]/div/div/label")
  private WebElement checkboxRememberUser;

  public void inputUserNameAndPassword(String username, String password) {
    inputEmailAddress.click();
    inputEmailAddress.sendKeys(username);
    inputPasswordField.click();
    inputPasswordField.sendKeys(password);
    checkboxRememberUser.click();
  }

  public void clickOnAccessAccountButton() {
    buttonAccesCont.click();
  }


}
