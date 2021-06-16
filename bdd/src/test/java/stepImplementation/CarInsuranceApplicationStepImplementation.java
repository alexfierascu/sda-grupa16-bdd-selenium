package stepImplementation;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Client;
import model.InsuranceCompany;

public class CarInsuranceApplicationStepImplementation {

  InsuranceCompany genericInsuranceCompany = new InsuranceCompany();
  Client genericClient = new Client();
  double insuranceMoneyWithoutPenalties;

  @Given("{string} goes to car insurance company {string}")
  public void insureClientAtCarInsuranceCompany(String clientName, String insuranceCompanyName) {
    genericClient.setClientFirstName(clientName);
    genericInsuranceCompany.setInsuranceCompanyName(insuranceCompanyName);
    genericInsuranceCompany.insureClient(genericClient);
  }

  @And("has in his wallet {double} ron")
  public void availableFunds(double funds) {
    genericClient.setAvailableMoney(funds);
  }

  @When("he finds out that the standard car assurance plan costs {int} RON")
  @When("he pays {int} ron")
  public void payInsuranceMoney(int insuranceMoney) {
    insuranceMoneyWithoutPenalties = insuranceMoney;
    genericClient.payInsurance(insuranceMoney);
    genericInsuranceCompany.collectInsuranceMoney(insuranceMoney);
  }

  @But("he had a car accident this year and has to pay {double}% more")
  public void payAdditionalInsuranceTaxes(double carPenaltiesTaxesInPercentage) {
    double penaltiesMoney = genericClient
        .returnInsurancePenaltiesMoney(insuranceMoneyWithoutPenalties,
            carPenaltiesTaxesInPercentage);
    genericClient.payInsurance(penaltiesMoney);
    genericInsuranceCompany.collectInsuranceMoney(penaltiesMoney);
  }

  @But("he has a discount and pays {double}% less")
  public void receiveBonusMoneyForGoodBehaviour(double returnedBonusMoney) {
    double bonusMoney = genericClient
        .returnBonusMoney(insuranceMoneyWithoutPenalties, returnedBonusMoney);
    genericClient.receiveBonusMoney(bonusMoney);
    genericInsuranceCompany.payInsuranceBonusMoney(bonusMoney);

  }

  @And("the insurance company fund has increased with {int} ron")
  public void checkInsuranceCompanyFunds(int insuranceMoneyReceivedFromClient) {
    double actualInsuranceCompanyAvailableFunds = genericInsuranceCompany
        .returnFundsWithoutCapital();
    genericInsuranceCompany.addProfitToCompanyEntriesAsProfit(insuranceMoneyReceivedFromClient);
    assertEquals(actualInsuranceCompanyAvailableFunds, insuranceMoneyReceivedFromClient, 0.0000001);
  }

  @Then("in his wallet remains the rest of his payment")
  public void inHisWalletRemainsTheRestOfHisPayment() {
  }

  @And("the available funds that {string} now has are {double} ron")
  public void verifyThatAvailableFundsAreReturnedCorrectly(String clientName,
      double expectedAvailableFunds) {
    double actualAvailableFunds = genericClient.checkAvailableFunds();
    assertEquals(actualAvailableFunds, expectedAvailableFunds, 0.0000000000000000001);
  }

  @And("the insurance company final fund is {double} ron")
  public void theInsuranceCompanyFinalFundIsRon(double companyProfit) {
    assertEquals(companyProfit,genericInsuranceCompany.returnCompanyProfit(),0.0000001);
  }



}
