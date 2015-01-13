package com.example.oskar.autoloancalculator;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class autoLoanCalculator extends ActionBarActivity {

    EditText paymentText;
    EditText totalCostText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_loan_calculator);
        paymentText = (EditText) findViewById(R.id.payment);
        totalCostText = (EditText) findViewById(R.id.totalCostBox);
        paymentText.setEnabled(false);
        totalCostText.setEnabled(false);
    }

    public void CalculatePayment(View view){
        EditText carPriceText = (EditText) findViewById(R.id.carPrice);
        EditText interestText = (EditText) findViewById(R.id.interest);
        EditText termText = (EditText) findViewById(R.id.term);

        if(!carPriceText.getText().toString().matches("") && !interestText.getText().toString().matches("") && !termText.getText().toString().matches("")) {

            double carPrice = Double.parseDouble(carPriceText.getText().toString());
            double interest = Double.parseDouble(interestText.getText().toString());
            double term = Double.parseDouble(termText.getText().toString());

            Loan loan = new Loan(carPrice, interest, term);
            double monthlyPayment = loan.monthlyPayment();
            paymentText.setText("$" + String.valueOf(monthlyPayment));
            totalCostText.setText(String.valueOf((term * monthlyPayment)));
        }else{
            AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
            dlgAlert.setMessage("Insert required information");
            dlgAlert.setTitle("Auto Loan Calculator");
            dlgAlert.setPositiveButton("Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            //dismiss the dialog
                        }
                    });
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_auto_loan_calculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
