import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleSeleniumTest {


  @Test
  public void openEmagPage() {

    //set the property for the chrome.driver to know where the driver is located
    //depending on the OS and browser version you are using we set this property
    //read more - https://www.selenium.dev/documentation/en/webdriver/driver_requirements/
    System.setProperty("webdriver.chrome.driver",
        "C:\\!dev_projects\\sda\\grupa16\\selenium\\src\\test\\resources\\webdriver\\windows\\chromedriver.exe");
    //initialize the driver as ChromeDriver
    WebDriver driver = new ChromeDriver();
    //navigate to URL
    driver.get("https://www.emag.ro/");
    ////close the driver instance
    driver.close();

  }

}
