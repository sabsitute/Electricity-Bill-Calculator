package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnCal, btnClear;
    EditText unitEditText;
    int num;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCal = findViewById(R.id.btnCal);
        btnClear = (Button) findViewById(R.id.btnClear);
        unitEditText = findViewById(R.id.unitEditText);
        resultTextView = findViewById(R.id.resultTextView);

        btnClear.setOnClickListener(this);
        btnCal.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v == btnClear) {
            unitEditText.setText("");
            resultTextView.setText("");
        } else if (v == btnCal) {

            double unitsUsed = Double.parseDouble(unitEditText.getText().toString());
            double bill = 0.0;

            if (unitsUsed <= 200) {
                bill = unitsUsed * 0.218;
            } else if (unitsUsed <= 300) {
                bill = 200 * 0.218 + (unitsUsed - 200) * 0.334;
            } else if (unitsUsed <= 600) {
                bill = 200 * 0.218 + 100 * 0.334 + (unitsUsed - 300) * 0.516;
            } else {
                bill = 200 * 0.218 + 100 * 0.334 + 300 * 0.516 + (unitsUsed - 600) * 0.546;
            }

            // Apply rebate percentage
            int rebatePercentage = 5;
            double rebateAmount = (rebatePercentage / 100.0) * bill;
            double finalBill = bill - rebateAmount;

            resultTextView.setText("Bill: RM " + String.format("%.2f", finalBill));
            //resultTextView.setText(result);
        }

        //tvOutput.setText(km + "km is equivalent to " + String.valueOf(miles) + " miles");
    }



    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate (R.menu.menu, menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.about:
                //Toast.makeText(this, "This is about",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                break;

            case R.id.settings:
                Toast.makeText(this, "This is settings",Toast.LENGTH_LONG).show();
                break;

            case R.id.search:
                Toast.makeText(this, "This is search",Toast.LENGTH_LONG).show();
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    }




