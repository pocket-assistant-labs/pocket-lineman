package calc.constr.linecalc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Metric and imperial conversions
 */

public class Conversions extends AppCompatActivity{

    LineMath LM = new LineMath();
    Spinner convSpinner;
    Button convCalc;
    TextView convView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversions_disp);

        Button convHomeButton = (Button) findViewById(R.id.convHomeButton);
        convHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(home);
            }
        });

        convCalc = (Button) findViewById(R.id.convCalc);
        convCalc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                calculate();
            }
        });

    }

    public void calculate(){
        convSpinner = (Spinner) findViewById(R.id.convSpinner);
        EditText num = (EditText) findViewById(R.id.inputNumber) ;
        double val;
        if(num.getText().toString().equals("") || num == null){
            val = 0;
        }else{
            val = Double.parseDouble(num.getText().toString());
        }
        int spinnerSel = convSpinner.getSelectedItemPosition();
        convView = (TextView) findViewById(R.id.convTextView);
        double res;
        String rslt;

        switch (spinnerSel) {
            case 0:
                res = LM.meterToFeet(val);
                rslt = ("" + res + "");
                convView.setText(rslt);
                break;

            case 1:
                res = LM.feetToMeters(val);
                rslt = ("" + res + "");
                convView.setText(rslt);
                break;

            case 2:
                res = LM.inchesToMilli(val);
                rslt = ("" + res + "");
                convView.setText(rslt);
                break;

            case 3:
                res = LM.milliToInches(val);
                rslt = ("" + res + "");
                convView.setText(rslt);
                break;

            default:
                convView.setText("Result");
        }



    }


}
