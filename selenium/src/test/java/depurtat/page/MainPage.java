package depurtat.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

  private WebDriver driver;

  public MainPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  private String titleMainPage = "dEpurtat.ro - Magazinul tău cu încălțăminte de damă";

  //PageFactory locator strategy
  @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div[1]/div/div[1]/a")
  private WebElement buttonSearch;
  @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div[1]/div/a[2]/span[1]")
  private WebElement buttonFavorite;
  @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div[1]/div/a[3]/span[1]")
  private WebElement buttonLogin;
  @FindBy(xpath = "//*[@id=\"header_middle_cart_preview\"]/a/span[2]")
  private WebElement buttonBasketShopping;
  @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div[1]/a[2]/img")
  private WebElement logo;
  @FindBy(xpath = "//*[@id=\"header\"]/div[3]/div/nav/ul/li[1]/a")
  private WebElement buttonNoutati;

  public WebDriver getDriver() {
    return driver;
  }

  public String getTitleMainPage() {
    return titleMainPage;
  }

  public WebElement getButtonSearch() {
    return buttonSearch;
  }

  public WebElement getButtonFavorite() {
    return buttonFavorite;
  }

  public WebElement getButtonLogin() {
    return buttonLogin;
  }

  public WebElement getButtonBasketShopping() {
    return buttonBasketShopping;
  }

  public WebElement getLogo() {
    return logo;
  }

  public WebElement getButtonNoutati() {
    return buttonNoutati;
  }

  public boolean checkElementsOnTheMainPage() {
    if (buttonSearch.isDisplayed() && buttonLogin.isDisplayed() &&
        buttonNoutati.isDisplayed() && buttonFavorite.isDisplayed() && logo.isDisplayed()) {
      return true;
    } else {
      return false;
    }
  }


}
