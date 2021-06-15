package model;

import java.util.ArrayList;
import java.util.List;

public class BankingApp {

  private int bankAccountBalance;
  private List<String> userAccounts = new ArrayList<>();
  private int transferLimit = 10000;

  public List<String> getUserAccounts() {
    return userAccounts;
  }

  public int verifyAccountBalance() {
    return bankAccountBalance;
  }

  public void depositMoneyIntoAccountBalance(int depositMoney) {
    bankAccountBalance = bankAccountBalance + depositMoney;
    // bankAccountBalance += depositMoney
  }

  public void withdrawMoneyFromAccountBalance(int withdrawMoney) {
    if (withdrawMoney < 0) {
      throw new java.lang.Error("Operation imposible");
    }
    if (bankAccountBalance < withdrawMoney) {
      throw new java.lang.Error("Insuficient fonds");
    } else {
      bankAccountBalance = bankAccountBalance - withdrawMoney;
      // bankAccountBalance -= withdrawMoney
    }
  }

  public void setBankAccountBalance(int bankAccountBalance) {
    this.bankAccountBalance = bankAccountBalance;
  }

  public void addPersonsToBankAccountUser(String personName) {
    userAccounts.add(personName);
  }

  public boolean isTransferPossible (int transferMoney) {
    if (transferMoney > transferLimit) {
      return false;
    } else {
      return true;
    }
  }

}
