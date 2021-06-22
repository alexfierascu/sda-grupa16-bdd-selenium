import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpeTest {

  @Test
  public void test() {
    System.setProperty("webdriver.chrome.driver",
        "C:\\!dev_projects\\sda\\grupa16\\selenium\\src\\test\\resources\\webdriver\\windows\\chromedriver.exe");

    WebDriver driver = new ChromeDriver();

    driver.manage().window().maximize();
    driver.get("https://www.canva.com/");

    WebElement buttonLogin = driver.findElement(
        By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/header/div[5]/button[1]/span"));
    buttonLogin.click();



   driver.close();
  }

}
