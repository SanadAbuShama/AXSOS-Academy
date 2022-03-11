package com.calculator;

import java.util.Scanner;

public class CalculatorTest {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		Calculator calc = new Calculator();

		System.out.println("Please enter first number");
		double operandOne = in.nextInt();
		calc.setOperandOne(operandOne);

		System.out.println("Please enter second number");
		double operandTwo = in.nextInt();
		calc.setOperandTwo(operandTwo);

		System.out.println("Please enter operation: (+/-)");
		String operation = in.next();
		in.close();
		calc.setOperation(operation);

		calc.performOperation();

		double result = calc.getResults();
		System.out.println("The result is: " + result);
	}

}
