package v.alice.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText input1, input2, output1, output2, output3;
    Button okButton, clearButton;
    RadioButton radioButton1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        output1 = findViewById(R.id.output1);
        output2 = findViewById(R.id.output2);
        output3 = findViewById(R.id.output3);
        okButton = findViewById(R.id.okButton);
        clearButton = findViewById(R.id.clearButton);
        radioButton1 = findViewById(R.id.radioButton1);
    }

    public void calculate(View v) {

        DecimalFormat decimal = new DecimalFormat("###.##");

        int numberOfUnits, vatPercent = 20;
        float unitPrice, exclVat, inclVat, vat;

        // The program doesn't calculate anything if user didn't enter unit price ot number of units
        if (!input1.getText().toString().matches("") && !input2.getText().toString().matches("")) {

            //Saving entered numbers into variables
            unitPrice = Float.parseFloat(input1.getText().toString());
            numberOfUnits = Integer.parseInt(input2.getText().toString());

            if (radioButton1.isChecked()) {

                exclVat = unitPrice * numberOfUnits;
                output1.setText(String.valueOf(decimal.format(exclVat)));

                // Rounds a number if it has 0 after decimal
                if (exclVat % 1 == 0) output1.setText(String.valueOf(Math.round(exclVat)));

                output2.setText("");
                output3.setText("");

            } else {

                vat = vatPercent * (unitPrice * numberOfUnits) / 100;
                inclVat = (unitPrice * numberOfUnits) + vat;

                output1.setText("");
                output2.setText(String.valueOf(decimal.format(vat)));
                output3.setText(String.valueOf(decimal.format(inclVat)));

            }
        } else {

            output1.setText("");
            output2.setText("");
            output3.setText("");
            Toast.makeText(this, "Enter the unit price and number of units!", Toast.LENGTH_SHORT).show();

        }

    }

    public void clear (View v) {

        input1.setText("");
        input2.setText("");
        output1.setText("");
        output2.setText("");
        output3.setText("");

    }
}
