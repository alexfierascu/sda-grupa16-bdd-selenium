package model;

import java.util.ArrayList;
import java.util.List;

public class InsuranceCompany {

  private String insuranceCompanyName;
  private double capital;
  private double availableFunds;
  private List<Client> insuredClients; //am declarat o lista
  private List<Double> companyEntriesAsProfit=new ArrayList<>();
  private double companyProfit;

  public double returnCompanyProfit() {
    for (Double entryValueInMoney : companyEntriesAsProfit) {
      companyProfit += entryValueInMoney;
    }
    return companyProfit;
  }

  public void addProfitToCompanyEntriesAsProfit(double amountOfMoney) {
    companyEntriesAsProfit.add(amountOfMoney);
  }

  public String getInsuranceCompanyName() {
    return insuranceCompanyName;
  }

  public void setInsuranceCompanyName(String insuranceCompanyName) {
    this.insuranceCompanyName = insuranceCompanyName;
  }

  public double getCapital() {
    return capital;
  }

  public void setCapital(double capital) {
    this.capital = capital;
  }

  public double getAvailableFunds() {
    return availableFunds;
  }

  public double returnFundsWithoutCapital() {
    return availableFunds - capital;
  }

  public void setAvailableFunds(double availableFunds) {
    this.availableFunds = availableFunds;
  }

  public InsuranceCompany() {
    insuredClients = new ArrayList<>(); // am initializat-o
    capital = 200;
    availableFunds = capital;
  }

  public void insureClient(Client client) {
    insuredClients.add(client);
    System.out.println(
        "The client " + client.getClientFirstName() + " is now insured at " + insuranceCompanyName
            + "!");
  }

  public void collectInsuranceMoney(double insuranceMoney) {
    availableFunds += insuranceMoney;
    //availableMoney=availableMoney+insuranceMoney;
  }

  public void payInsuranceBonusMoney(double bonusMoney) {
    availableFunds -= bonusMoney;
  }

  public void addToCompanyProfit(int insuranceMoneyReceivedFromClient) {

  }
}
