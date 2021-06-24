package test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleEmagSeleniumTest {


  @Test
  public void openEmagPage() {

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
    driver.get("https://www.emag.ro/");

    WebElement buttonEmagGenius = driver.findElement(By.xpath("//*[@id=\"auxiliary\"]/div/div/ul[2]/li[1]"));
    buttonEmagGenius.click();

    WebElement buttonEmagGeniusIncearcaGratuit = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[4]/form/div[1]/label/span[2]/a"));
    buttonEmagGeniusIncearcaGratuit.click();

    WebElement buttonEmagContinuaLogin = driver.findElement(By.id("user_login_continue"));

    WebElement inputEmailField = driver.findElement(By.id("user_login_email"));
    inputEmailField.click();
    inputEmailField.sendKeys("fier4jat@yahoo.com");
    buttonEmagContinuaLogin.click();

    WebElement inputPasswordField = driver.findElement(By.id("user_login_password"));
    inputPasswordField.click();
    inputPasswordField.sendKeys("hamleys,28.");
    buttonEmagContinuaLogin.click();

    //close the driver instance
    driver.close();

  }

}
