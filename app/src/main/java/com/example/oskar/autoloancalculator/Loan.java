package com.example.oskar.autoloancalculator;

import java.text.DecimalFormat;

/**
 * Created by Oskar on 1/5/2015.
 */
public class Loan {

    public double loan;
    public double interest;
    public double term;

    public Loan(double loanAmount, double interestRate, double termLenght){
        loan = loanAmount;
        interest = (interestRate / 100) / 12;
        term = termLenght;
    }

    public double monthlyPayment(){
        double monthlyPayment = 0;
        double temp = interest * loan;
        double temp2 = 1 - Math.pow((1 + interest),( term *= -1));
        monthlyPayment =  (temp / temp2);
        DecimalFormat df = new DecimalFormat("###.##");
        return Double.parseDouble(df.format(monthlyPayment));
    }

}
