package depurtat.page;

import depurtat.util.NavigationUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NoutatiPage {

  private WebDriver driver;
  NavigationUtils navigation;

  public NoutatiPage(WebDriver driverPagina) {
    this.driver = driverPagina;
    navigation = new NavigationUtils(driver);
    PageFactory.initElements(driverPagina, this);
  }

  private String title = "Produse noi - dEpurtat";
  private String pageHeaderMessage = "Produse noi";
  @FindBy(xpath = "//*[@id=\"page_content\"]/h1")
  private WebElement pageHeaderWebelement;

  @FindBy(xpath = "//*[@id=\"page_content\"]/div[5]/div/div[1]/div/div[1]/a[2]/span")
  private WebElement buttonAddToFavourite1;
  @FindBy(xpath = "//*[@id=\"page_content\"]/div[5]/div/div[2]/div/div[1]/a[2]/span")
  private WebElement buttonAddToFavourite2;
  @FindBy(xpath = "//*[@id=\"page_content\"]/div[5]/div/div[3]/div/div[1]/a[2]/span")
  private WebElement buttonAddToFavourite3;
  @FindBy(xpath = "//*[@id=\"page_content\"]/div[5]/div/div[5]/div/div[1]/a[2]/span")
  private WebElement buttonAddToFavourite5;
  @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div[1]/div/a[2]/span[1]")
  private WebElement buttonAllFavouriteProducts;
  @FindBy(xpath = "//*[@id=\"page_top_box_product_filters_content\"]/div[1]/div/button")
  private WebElement dropdownCategorii;
  @FindBy(xpath = "/html/body/main/div/div/div/div[4]/div/div[1]/div/div/div/div[2]/div/ul/li[1]/div/a")
  private WebElement checkboxFirstCategory;
  @FindBy(xpath = "//*[@id=\"page_top_box_cat_cat_content\"]/div[2]/div/ul/li[1]/div/a/text()")
  private WebElement labelCheckboxFirstCategory;

  private List<WebElement> listOfFavouriteProducts = new ArrayList<>();

  private void addSingleProductToFavouriteList(WebElement element) {
    navigation.scrollToElement(element);
    element.click();
    listOfFavouriteProducts.add(element);
    driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
  }

  public int addMultipleProductsToFavouriteList() {
    addSingleProductToFavouriteList(buttonAddToFavourite1);
    addSingleProductToFavouriteList(buttonAddToFavourite2);
    addSingleProductToFavouriteList(buttonAddToFavourite3);
    addSingleProductToFavouriteList(buttonAddToFavourite5);
    return listOfFavouriteProducts.size();
  }

  public int getNumberOfFavouriteProductsFromFavouriteList() {
    navigation.scrollToElement(buttonAllFavouriteProducts);
    return Integer.parseInt(buttonAllFavouriteProducts.getAttribute("data-counter"));
  }


}
