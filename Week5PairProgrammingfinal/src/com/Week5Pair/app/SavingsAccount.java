package com.Week5Pair.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SavingsAccount extends BankAccount {

	static double interest = 0.01;

	SavingsAccount(double openingBalance, double interest) {
		super(openingBalance, interest);
	}

	SavingsAccount(long accountNumber, double openingBalance, double interest, Date accountOpenedOn) {
		super(accountNumber, interest, openingBalance, accountOpenedOn);
	}

	public boolean withdraw(double amount) {
		if (amount <= super.getBalance() && amount > 0) {
			this.balance = balance - amount;

			return true;
		}
		return false;
	}

	public boolean deposit(double amount) {
		if (amount > 0) {
			this.balance = balance + amount;

			return true;
		}
		return false;
	}

	public static SavingsAccount readFromString(String accountData) throws ParseException, NumberFormatException {

		String[] testName = accountData.split(",");
		SimpleDateFormat daate = new SimpleDateFormat("dd/MM/yyyy");
		long accountNumber = Long.parseLong(testName[0]);
		double balance = Double.parseDouble(testName[1]);
		double interestRate = Double.parseDouble(testName[2]);
		Date accountOpenedOn = daate.parse(testName[3]);
		return new SavingsAccount(accountNumber, balance, interestRate, accountOpenedOn);
	}

	public String toString() {
		return "test String " + getBalance() + " " + getInterestRate() + " " + futureValue(3);
	}
}
