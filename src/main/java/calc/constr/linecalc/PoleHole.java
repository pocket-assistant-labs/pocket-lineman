package calc.constr.linecalc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Class to control the calculation of pole hole depth
 * **/

public class PoleHole extends AppCompatActivity {

    LineMath LM = new LineMath();
    Button poleCalc;
    TextView poleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pole_hole);

        Button poleHoleHome = (Button) findViewById(R.id.poleHoleHome);
        poleHoleHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(home);
            }
        });

        poleCalc = (Button) findViewById(R.id.poleHoleCalc);
        poleCalc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                calculate();
            }
        });
    }

    public void calculate(){
        EditText num = (EditText) findViewById(R.id.holeEditText) ;
        double val;
        if(num.getText().toString().equals("") || num == null) {
            val = 0;
        }else {
            val = Double.parseDouble(num.getText().toString());
        }
        poleView = (TextView) findViewById(R.id.holeResult);
        double res = LM.poleHole(val);
        String rslt = ("" + res + "");
        poleView.setText(rslt);

    }

}
