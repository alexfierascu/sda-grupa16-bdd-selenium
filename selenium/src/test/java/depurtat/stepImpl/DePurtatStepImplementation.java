package depurtat.stepImpl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import depurtat.page.MainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DePurtatStepImplementation {

  WebDriver driver;
  String mainURL = "https://www.depurtat.ro/";
  MainPage mainPage;

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
    driver.quit();
  }
}
