Feature: Simple calculator application

  In this feature file we will create some test scenarios
  for our calculator application. This application and tests
  were developed for demo purpose.

  #a cucumber scenario is a test case!!!
  Scenario Outline: Calculator app that can manipulate two numbers and result will be verified
    Given user inputs number <firstNumber> and <secondNumber>
    When he does the operation <operation>
    Then the result will be <result>
    Examples:
      | firstNumber | secondNumber | operation | result |
      | 9           | 5            | +         | 14     |
      | 8           | 8            | -         | 0      |
      | 8           | 9            | *         | 72     |
      | 0           | 5            | /         | 0      |
      | 0           | 1            | *         | 0      |
      | 0           | 9            | -         | -9     |
      | 5           | 5            | *         | 25     |
      | 5           | 8            | -         | -3     |
      | 2           | 2            | +         | 4      |


  Scenario Outline: Calculator app that can manipulate two numbers and result will be verified for mathematical operations that are not implemented
    Given user inputs number <firstNumber> and <secondNumber>
    When he does the operation <operation>
    Then the result will not be <result>
    Examples:
      | firstNumber | secondNumber | operation | result |
      | 9           | 5            | !         | 14     |
      | 8           | 8            | :         | 8      |
      | 8           | 9            | [         | 72     |
      | 0           | 5            | ]         | 2      |
      | 0           | 1            | !         | 3      |
      | 0           | 9            | @         | -9     |
      | 5           | 5            | #         | 25     |
      | 5           | 8            | $         | -3     |
      | 2           | 2            | %         | 4      |
      | 2           | 2            | ^         | 4      |