package stepImplementation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.CalculatorUtil;

public class CalculatorStepImplementation {
  CalculatorUtil calc= new CalculatorUtil();
  int a, b;

  @Given("^I have a first number (.*)$")
  public void m1(int firstNumber) {
    a=firstNumber;
  }

  @When("^I add a second number (.*) to it$")
  public void m2(int secondNumber) {
    b = secondNumber;
  }

  @Then("^sum of the numbers is (.*)$")
  public void m3(int sumOfNumbers) {
    assertEquals(calc.sum(a, b), sumOfNumbers);
  }
}
