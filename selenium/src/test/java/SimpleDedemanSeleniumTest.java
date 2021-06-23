import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SimpleDedemanSeleniumTest {


  @Test
  public void loginIntoDedemanMainApplication() throws InterruptedException {
    //set the property for the chrome.driver to know where the driver is located
    //depending on the OS and browser version you are using we set this property
    //read more - https://www.selenium.dev/documentation/en/webdriver/driver_requirements/
    System.setProperty("webdriver.chrome.driver",
        "src/test/resources/webdriver/windows/chromedriver.exe");
    //initialize the driver as ChromeDriver
    WebDriver driver = new ChromeDriver();
    //maximize the browser window
    driver.manage().window().maximize();
    //navigate to URL
    driver.get("https://www.dedeman.ro/");

    WebElement buttonContulMeu = driver.findElement(
        By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div/div[2]/div[2]/div[2]/ul/li[2]/span"));

    //Creating object of an Actions class
    Actions action = new Actions(driver);

    //Performing the mouse hover action on the target element.
    action.moveToElement(buttonContulMeu).perform();

    WebElement buttonAutentificare = driver.findElement(By.xpath(
        "//*[@id=\"app\"]/div/div[2]/div[1]/div/div[2]/div[2]/div[2]/ul/li[2]/div/div[2]/a[1]"));
    buttonAutentificare.click();

    WebElement inputJudetElement = driver
        .findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[3]/div/div/div[1]/div/input"));
    inputJudetElement.click();
    inputJudetElement.sendKeys("Iasi");
    inputJudetElement.sendKeys(Keys.RETURN);

    WebElement inputLocalitateElement = driver
        .findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[3]/div/div/div[2]/div/input"));
    inputLocalitateElement.click();
    inputLocalitateElement.sendKeys("Albesti");
    inputJudetElement.sendKeys(Keys.RETURN);

    //wait implicit
    //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    //wait explicit
    WebDriverWait wait = new WebDriverWait(driver, 100);
    WebElement inputClientEmailAddress = wait.until(ExpectedConditions.presenceOfElementLocated(
        By.xpath("//*[@id=\"app\"]/div/div[2]/div[3]/div/div[1]/form/div[1]/input")));

    //WebElement inputClientEmailAddress = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[3]/div/div[1]/form/div[1]/input"));
    inputClientEmailAddress.click();
    inputClientEmailAddress.sendKeys("fier4jat@yahoo.com");

    Thread.sleep(5000);
    WebElement inputClientPassword = driver
        .findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[3]/div/div[1]/form/div[2]/input"));
    inputClientPassword.click();
    inputClientPassword.sendKeys("Prastiex2021!@");

    WebElement buttonAutentificareClient = driver
        .findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[3]/div/div[1]/form/button/div"));
    buttonAutentificareClient.click();
  }
}
