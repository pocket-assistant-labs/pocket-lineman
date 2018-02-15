package calc.constr.linecalc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);


        MobileAds.initialize(this, "ca-app-pub-5569966794762512~4481395050");

        mAdView = (AdView) findViewById(R.id.menuAdView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Button convButton = (Button) findViewById(R.id.convButton);
        convButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent conv = new Intent(getApplicationContext(), Conversions.class);
                startActivity(conv);
            }
        });

        Button poleHoleButton = (Button) findViewById(R.id.PoleHoleButton);
        poleHoleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent poleHole = new Intent(getApplicationContext(), PoleHole.class);
                startActivity(poleHole);
            }
        });

        Button ohmsLawButton = (Button) findViewById(R.id.ohmsLawButton);
        ohmsLawButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ohmsLaw = new Intent(getApplicationContext(), OhmsLaw.class);
                startActivity(ohmsLaw);
            }
        });

        Button feedback = (Button) findViewById(R.id.button2);
        feedback.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"pocketassistantlabs@gmail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, "Feedback for Pocket Lineman");
                i.putExtra(Intent.EXTRA_TEXT   , "<--Please include feedback here-->");
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(MainActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_menu, menu);
        return true;
    }
        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.action_info:
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("message/rfc822");
                    i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"pocketassistantlabs@gmail.com"});
                    i.putExtra(Intent.EXTRA_SUBJECT, "Feedback for Pocket Lineman");
                    i.putExtra(Intent.EXTRA_TEXT   , "<--Please include feedback here-->");
                    try {
                        startActivity(Intent.createChooser(i, "Send mail..."));
                    } catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(MainActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                    }
                    return true;


                default:
                    // If we got here, the user's action was not recognized.
                    // Invoke the superclass to handle it.
                    return super.onOptionsItemSelected(item);

            }
        }
}
