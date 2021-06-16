package model;

public class Client {

  private String clientFirstName;
  private String clientLastName;
  private String carBrand;
  private int age;
  private double availableMoney;

  private double getAvailableMoney() {
    return availableMoney;
  }

  public void setAvailableMoney(double availableMoney) {
    this.availableMoney = availableMoney;
  }

  public String getClientFirstName() {
    return clientFirstName;
  }

  public void setClientFirstName(String clientFirstName) {
    this.clientFirstName = clientFirstName;
  }

  public String getClientLastName() {
    return clientLastName;
  }

  public void setClientLastName(String clientLastName) {
    this.clientLastName = clientLastName;
  }

  public String getCarBrand() {
    return carBrand;
  }

  public void setCarBrand(String carBrand) {
    this.carBrand = carBrand;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void payInsurance(double insuranceMoney) {
    availableMoney -= insuranceMoney;
    //availableMoney=availableMoney-insuranceMoney;
  }

  public double checkAvailableFunds() {
    return getAvailableMoney();
  }

  public double returnInsurancePenaltiesMoney(double insuranceMoneyWithoutPenalties,
      double carPenalties) {
    return (insuranceMoneyWithoutPenalties * carPenalties) / 100;
  }

  public double returnBonusMoney(double insuranceMoneyWithoutPenalties, double returnedBonusMoney) {
    return (insuranceMoneyWithoutPenalties * returnedBonusMoney) / 100;
  }

  public void receiveBonusMoney(double bonusMoney) {
    availableMoney+=bonusMoney;
  }
}
