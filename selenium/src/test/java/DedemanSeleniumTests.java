import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DedemanSeleniumTests {

  //declaram driverul la nivel de clasa pentru a putea fi vizibil pentru toate metodele (testele) noastre
  WebDriver driver;
  // Utils utilitare = new Utils();

  @BeforeEach
  public void setup() {
    System.setProperty("webdriver.chrome.driver",
        "src/test/resources/webdriver/windows/chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.dedeman.ro/");
  }

//  @AfterEach
//  public void tearDown() {
//    driver.quit();
//  }


  @Test
  public void verifyThatUserIsAbleToOpenBrowserAndAccessWebApplication() {
    String actualTitle = "Dedeman Magazin Online - Dedicat planurilor tale";
    String expectedTitle = driver.getTitle();
    System.out.println(expectedTitle);
    assertEquals(actualTitle, expectedTitle);
  }


  //todo - de verificat si reparat
  @Test
  public void verifyThatRegisteredUserCanLoginIntoWebApplication() {
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

    WebElement inputClientPassword = driver
        .findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[3]/div/div[1]/form/div[2]/input"));
    inputClientPassword.click();
    inputClientPassword.sendKeys("Prastiex2021!@");

    WebElement buttonAutentificareClient = driver
        .findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[3]/div/div[1]/form/button/div"));
    buttonAutentificareClient.click();

    WebElement buttonContulMeuDupaLogin = driver.findElement(
        By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div[2]/div[2]/div[2]/ul/li[2]/span"));

    //Creating object of an Actions class
    Actions action2 = new Actions(driver);

    //Performing the mouse hover action on the target element.
    action2.moveToElement(buttonContulMeuDupaLogin).perform();

//    WebElement myAccountNameElement = driver.findElement(By.xpath(
//        "/html/body/div[2]/div/div[2]/div[1]/div/div[2]/div[2]/div[2]/ul/li[2]/div/div[1]/p[2]"));
//    String expectedText = myAccountNameElement.getText();
//    System.out.println(expectedText);
//    String actualText = "Ceva Nume";
//    assertEquals(actualText, expectedText);
  }


  @Test
  public void checkThatUserIsAbleToNavigateToCareersPage() {
    String oldTab = driver.getWindowHandle();
    WebElement buttonCareerPage = driver.findElement(
        By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div/div[2]/div[1]/div[2]/div/div/ul/li[5]/a"));
    buttonCareerPage.click();
    ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
    newTab.remove(oldTab);
    driver.switchTo().window(newTab.get(0));
    String actualTitle = "Dedeman - Angajari, Cariere, Locuri de munca";
    assertEquals(driver.getTitle(), actualTitle);
  }


  @Test
  public void verifyThatUserCanAddAProductToHisBasket() {
    driver.get("https://www.dedeman.ro/ro/baie/c/1528");

    WebDriverWait wait = new WebDriverWait(driver, 100);
    WebElement inputClientEmailAddress = wait.until(ExpectedConditions.presenceOfElementLocated(
        By.xpath("//*[@id=\"app\"]/div[4]/div[3]/div[1]/div/a[1]/span")));

    WebElement buttonBathroomArticlesHowFatIAm = driver
        .findElement(By.xpath("//*[@id=\"app\"]/div[4]/div[3]/div[1]/div/a[1]/span"));
    buttonBathroomArticlesHowFatIAm.click();

    WebElement buttonAcceptCookies = driver
        .findElement(By.xpath("//*[@id=\"app\"]/footer/div[1]/div/div/div[2]/div/a[1]"));
    buttonAcceptCookies.click();

    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    WebElement buttonAddFirstProductToBasket = driver.findElement(By.xpath(
        "//*[@id=\"app\"]/div[3]/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[5]/button/span/div"));
    Actions actions = new Actions(driver);
    actions.moveToElement(buttonAddFirstProductToBasket);
    actions.perform();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    buttonAddFirstProductToBasket.click();

    WebElement inputJudetElement = driver
        .findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[3]/div/div/div[1]/div/input"));
    inputJudetElement.click();
    inputJudetElement.sendKeys("Iasi");
    inputJudetElement.sendKeys(Keys.RETURN);

    WebElement inputLocalitateElement = driver
        .findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[3]/div/div/div[2]/div/input"));
    inputLocalitateElement.click();
    inputLocalitateElement.sendKeys("Albesti");
    inputJudetElement.sendKeys(Keys.RETURN);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    WebElement buttonCloseShoppingModal = driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[3]/div/div[1]/div/i"));
    buttonCloseShoppingModal.click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    //navigate to basket
    WebElement buttonShoppingBasket = driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div/div[2]/div[2]/div[2]/ul/li[3]/a"));
    buttonShoppingBasket.click();

    //verify that at least 1 product exists in the shopping basket
    WebElement labelShoppingBasketNumberOfItems = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div[2]/div[1]/div/div[1]/div/p[1]"));
    String textLabelShoppingBasketItems = labelShoppingBasketNumberOfItems.getText();

    boolean isAtLeastOneProductInBasket = textLabelShoppingBasketItems.contains("1");

    assertTrue(isAtLeastOneProductInBasket);
  }

}
