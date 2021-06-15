package stepImplementation;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.BankingApp;

public class BankingAppStepImplementation {

  private BankingApp myBank;
  int finalBalance;

  @Given("user access his banking account using his card")
  @Given("Alex access his banking account using his card")
  public void userAccessHisBankingAccountUsingHisCard() {
    myBank = new BankingApp();
  }

  @And("his account balance is {int} ron")
  public void hisAccountBalanceIsRon(int initialBankBalance) {
    myBank.setBankAccountBalance(initialBankBalance);
  }

  @When("he deposit {int} ron")
  public void heDepositRon(int depositMoney) {
    myBank.depositMoneyIntoAccountBalance(depositMoney);
  }

  @Then("his balance will reflect the deposit he previously made")
  public void hisBalanceWillReflectTheDepositHePreviouslyMade() {
    finalBalance = myBank.verifyAccountBalance();
  }

  @And("his new balance will be {int} ron")
  public void hisNewBalanceWillBeRon(int balance) {
    assertEquals(finalBalance, balance);
  }

  @When("he withdraws {int} ron")
  public void heWithdrawsRon(int withdrawMoney) {
    myBank.withdrawMoneyFromAccountBalance(withdrawMoney);
  }

  @Then("his balance will reflect the withdraw he previously made")
  public void hisBalanceWillReflectTheWithdrawHePreviouslyMade() {
    finalBalance = myBank.verifyAccountBalance();
  }

  @When("he transfers {int} ron to {string} account")
  public void heTransfersRonToPersonsAccount(int transferMoney, String personName) {
    if (myBank.isTransferPossible(transferMoney)) {
      myBank.addPersonsToBankAccountUser(personName);
      for (String name : myBank.getUserAccounts()) {
        if (personName.equals(name)) {
          myBank.withdrawMoneyFromAccountBalance(transferMoney);
        } else {
          System.out.println("Person is not in the system");
        }
      }
    } else {
      throw new java.lang.Error("Transfer limit has been exceeded");
    }

  }

  @Then("his balance will reflect the transfer he previously made")
  public void hisBalanceWillReflectTheTransferHePreviouslyMade() {
    finalBalance = myBank.verifyAccountBalance();
  }
}
