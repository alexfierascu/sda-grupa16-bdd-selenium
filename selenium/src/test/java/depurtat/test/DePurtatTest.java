package depurtat.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import depurtat.page.AccountPage;
import depurtat.page.LoginPage;
import depurtat.page.MainPage;
import depurtat.page.NoutatiPage;
import depurtat.util.NavigationUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DePurtatTest {

  private WebDriver driver;
  MainPage mainPage;
  NavigationUtils navigation;
  LoginPage loginPage;
  AccountPage accountPage;
  NoutatiPage noutatiPage;

  String username = "barosanunumber1@gmail.com";
  String password = "Cemaifacetidragilor?";

  @BeforeEach
  public void setup() {
    System.setProperty("webdriver.chrome.driver",
        "src/test/resources/webdriver/windows/chromedriver.exe");
    driver = new ChromeDriver();
    mainPage = new MainPage(driver);
    loginPage = new LoginPage(driver);
    accountPage = new AccountPage(driver);
    noutatiPage = new NoutatiPage(driver);
    navigation = new NavigationUtils(driver);
    driver.manage().window().maximize();
    driver.get("https://www.depurtat.ro/");
  }

  @AfterEach
  public void tearDown() {
    driver.quit();
  }


  @Test
  @Order(1)
  public void checkThatUserIsAbleToAccessWebApplication() {
    assertTrue(mainPage.checkElementsOnTheMainPage());
  }

  @Test
  @Order(2)
  public void verifyThatRegisteredUserCanLoginIntoWebApplication() {
    navigation.navigateToLoginPage();
    loginPage.inputUserNameAndPassword(username, password);
    loginPage.clickOnAccessAccountButton();
    assertTrue(accountPage.verifyThatUserHasLoggedIn());
  }


  @Test
  @Order(3)
  public void verifyThatLoggedInUserCanLogoutFromHisAccount() {
    navigation.navigateToLoginPage();
    loginPage.inputUserNameAndPassword(username, password);
    loginPage.clickOnAccessAccountButton();
    accountPage.logOut();
    assertTrue(mainPage.checkElementsOnTheMainPage());
  }

  @Test
  @Order(4)
  public void verifyThatUserIsAbleToAddMultipleProductsToHisFavouriteList() {
    navigation.navigateToNoutatiPage();

    //imi va returna pe cate produse am apasat butonul de add to favourite list
    int counterFavouriteButtonsClicked = noutatiPage.addMultipleProductsToFavouriteList();

    //imi va returna cate produse am in lista de favorite
    int counterFavourite = noutatiPage.getNumberOfFavouriteProductsFromFavouriteList();

    assertEquals(counterFavourite, counterFavouriteButtonsClicked);
  }

  @Test
  @Order(5)
  public void testul1() {
    assertEquals(2, 2);
  }
}
