package com.calculator;

public class Calculator implements java.io.Serializable {

	private static final long serialVersionUID = 5277914206301559800L;
	private double operandOne;
	private double operandTwo;
	private String operation;
	private double result;

	public Calculator() {

	}

	public double getOperandOne() {
		return operandOne;
	}

	public void setOperandOne(double operandOne) {
		this.operandOne = operandOne;
	}

	public double getOperandTwo() {
		return operandTwo;
	}

	public void setOperandTwo(double operandTwo) {
		this.operandTwo = operandTwo;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public void performOperation() {
		if (operation.equals("+")) {
			result = operandOne + operandTwo;
		} else if (operation.equals("-")) {
			result = operandOne - operandTwo;
		}
	}

	public double getResults() {
		return result;
	}

}
