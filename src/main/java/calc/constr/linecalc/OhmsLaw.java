package calc.constr.linecalc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class OhmsLaw extends AppCompatActivity {

    LineMath LM = new LineMath();
    Button ohmsCalc;
    Spinner ohmsSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ohms_law);

        Button ohmsHome = (Button) findViewById(R.id.ohmsHome);
        ohmsHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(home);
            }
        });

        Button ohmsClear = (Button) findViewById(R.id.ohmsClear);
        ohmsClear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                EditText clearAmp = (EditText) findViewById(R.id.ampsText);
                EditText clearVolt = (EditText) findViewById(R.id.voltText);
                EditText clearOhms = (EditText) findViewById(R.id.ohmsText);
                clearAmp.setText("");
                clearVolt.setText("");
                clearOhms.setText("");
            }
        });

        ohmsCalc = (Button) findViewById(R.id.ohmsCalc);
        ohmsCalc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                calculate();
            }
        });
    }

    public void calculate(){
        ohmsSpinner = (Spinner) findViewById(R.id.ohmsSpinner);
        EditText ampNum = (EditText) findViewById(R.id.ampsText);
        EditText voltNum = (EditText) findViewById(R.id.voltText);
        EditText ohmsNum = (EditText) findViewById(R.id.ohmsText);
        int spinnerSel = ohmsSpinner.getSelectedItemPosition();

        double res;
        String rslt;
        double ampVal;
        double voltVal;
        double ohmsVal;

        switch (spinnerSel) {
            case 0:
                //solve for amps
                if (ampNum.getText().toString().equals("") && !voltNum.getText().toString().equals("") && !ohmsNum.getText().toString().equals("")) {
                    voltVal = Double.parseDouble(voltNum.getText().toString());
                    ohmsVal = Double.parseDouble(ohmsNum.getText().toString());
                    res = LM.dcAmpsCalc(voltVal, ohmsVal);
                    rslt = ("" + res + "");
                    ampNum.setHint(rslt);
                    break;
                }

                //solve for volts
                if (!ampNum.getText().toString().equals("") && voltNum.getText().toString().equals("") && !ohmsNum.getText().toString().equals("")) {
                    ampVal = Double.parseDouble(ampNum.getText().toString());
                    ohmsVal = Double.parseDouble(ohmsNum.getText().toString());
                    res = LM.dcVoltsCalc(ampVal, ohmsVal);
                    rslt = ("" + res + "");
                    voltNum.setHint(rslt);
                    break;
                }

                //solve for ohms
                if (!ampNum.getText().toString().equals("") && !voltNum.getText().toString().equals("") && ohmsNum.getText().toString().equals("")) {
                    ampVal = Double.parseDouble(ampNum.getText().toString());
                    voltVal = Double.parseDouble(voltNum.getText().toString());
                    res = LM.dcOhmsCalc(ampVal, voltVal);
                    rslt = ("" + res + "");
                    ohmsNum.setHint(rslt);
                } else {
                    ampNum.setHint("Need 2 values");
                    voltNum.setHint("Need 2 values");
                    ohmsNum.setHint("Need 2 values");
                }
            case 1:
                //solve for amps
                if (ampNum.getText().toString().equals("") && !voltNum.getText().toString().equals("") && !ohmsNum.getText().toString().equals("")) {

                }

                //solve for volts
                if (!ampNum.getText().toString().equals("") && voltNum.getText().toString().equals("") && !ohmsNum.getText().toString().equals("")) {

                }

                //solve for ohms
                if (!ampNum.getText().toString().equals("") && !voltNum.getText().toString().equals("") && ohmsNum.getText().toString().equals("")) {

                } else {
                    ampNum.setHint("Need 2 values");
                    voltNum.setHint("Need 2 values");
                    ohmsNum.setHint("Need 2 values");
                }
        }

    }

}
