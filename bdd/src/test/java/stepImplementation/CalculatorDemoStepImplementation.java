package stepImplementation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.CalculatorUtil;

public class CalculatorDemoStepImplementation {

  int primulNumar, alDoileaNumar, operationResult;
  CalculatorUtil calculator = new CalculatorUtil();

  @Given("user inputs number {int} and {int}")
  public void userInputsNumberAnd(int a, int b) {
    primulNumar = a;
    alDoileaNumar = b;
  }

  @Then("the result will be {int}")
  public void theResultWillBe(int result) {
    assertEquals(operationResult, result);
  }


  @When("^he does the operation (.*)$")
  public void heDoesTheOperationOperation(String operation) {
    switch (operation) {
      case "+":
        operationResult = calculator.sum(primulNumar, alDoileaNumar);
        break;
      case "-":
        operationResult = calculator.difference(primulNumar, alDoileaNumar);
        break;
      case "*":
        operationResult = calculator.multiply(primulNumar, alDoileaNumar);
        break;
      case "/":
        operationResult = calculator.divide(primulNumar, alDoileaNumar);
        break;
      default:
        System.out.println("Operation not recognised or not implemented yet");
    }

  }

  @Then("the result will not be {int}")
  public void theResultWillNotBeResult(int result) {
    assertNotEquals(operationResult, result);
  }
}
