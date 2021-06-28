package depurtat.stepImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import depurtat.page.AccountPage;
import depurtat.page.LoginPage;
import depurtat.page.MainPage;
import depurtat.page.NoutatiPage;
import depurtat.util.NavigationUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DePurtatStepImplementation {

  WebDriver driver;
  String mainURL = "https://www.depurtat.ro/";
  MainPage mainPage;
  NavigationUtils navigationUtils;
  LoginPage loginPage;
  AccountPage accountPage;
  NoutatiPage noutatiPage;
  int counterFavouriteButtonsClicked;

  @Given("the user accesses web application")
  public void theUserAccessesWebApplication() {
    System.setProperty("webdriver.chrome.driver",
        "src/test/resources/webdriver/windows/chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get(mainURL);
  }

  @When("he checks for the main elements on the page")
  public void heChecksForTheMainElementsOnThePage() {
    //empty - todo
  }

  @Then("they are displayed")
  public void theyAreDisplayed() {
    mainPage = new MainPage(driver);
    assertTrue(mainPage.checkElementsOnTheMainPage());
  }

  @Then("he can validate that he is logged in")
  public void heCanValidateThatHeIsLoggedIn() {
    accountPage = new AccountPage(driver);
    assertTrue(accountPage.verifyThatUserHasLoggedIn());
  }

  @And("after the check he closes the browser")
  public void afterTheCheckHeClosesTheBrowser() {
    driver.quit();
  }

  @When("he logs in into his account with username {string} and password {string}")
  public void heLogsInIntoHisAccountWithUsernameAndPassword(String username, String password) {
    navigationUtils = new NavigationUtils(driver);
    loginPage = new LoginPage(driver);
    navigationUtils.navigateToLoginPage();
    loginPage.inputUserNameAndPassword(username, password);
    loginPage.clickOnAccessAccountButton();
  }

  @And("navigates to Noutati page")
  public void navigatesToNoutatiPage() {
    navigationUtils = new NavigationUtils(driver);
    navigationUtils.navigateToNoutatiPage();
  }

  @When("he add multiple favourite products into his favourite list")
  public void heAddMultileFavouriteProductsIntoHisFavouriteList() {
    noutatiPage = new NoutatiPage(driver);
    counterFavouriteButtonsClicked = noutatiPage.addMultipleProductsToFavouriteList();
  }

  @Then("the favourite has his previously added favourite products")
  public void theFavouriteHasHisPreviouslyAddedFavouriteProducts() {
    int counterFavourite = noutatiPage.getNumberOfFavouriteProductsFromFavouriteList();

    assertEquals(counterFavourite, counterFavouriteButtonsClicked);
  }

  @When("he logs out from his account")
  public void heLogsOutFromHisAccount() {
    accountPage = new AccountPage(driver);
    accountPage.logOut();
  }

  @Then("he can validate that he is logged out")
  public void heCanValidateThatHeIsLoggedOut() {
    mainPage = new MainPage(driver);
    assertTrue(mainPage.checkElementsOnTheMainPage());
  }
}
