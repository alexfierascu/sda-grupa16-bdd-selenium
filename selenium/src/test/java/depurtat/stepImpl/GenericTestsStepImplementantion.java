package depurtat.stepImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GenericTestsStepImplementantion {

  WebDriver driver;
  String expectedTitle;

  @Given("user access web application with url {string}")
  public void accessWebApplication(String url) {
    System.setProperty("webdriver.chrome.driver",
        "src/test/resources/webdriver/windows/chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get(url);
  }

  @When("the checks the title of the page")
  public void getTitleOfTheWebApplication() {
    expectedTitle = driver.getTitle();
  }

  @Then("the title of the page he navigated to is {string}")
  public void checkTitle(String title) {
    assertEquals(expectedTitle, title);
    driver.quit();
  }
}
