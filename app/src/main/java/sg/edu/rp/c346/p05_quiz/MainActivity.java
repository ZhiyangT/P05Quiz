package sg.edu.rp.c346.p05_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button bPlus;
    Button bMinus;
    Button bSubmit;
    TextView tvQuality;
    CheckBox oneWay;
    CheckBox roundTrip;

    String trip="";

    String quality = tvQuality.getText().toString().trim();
    int qual = Integer.valueOf(quality);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bPlus = findViewById(R.id.buttonPlus);
        bMinus = findViewById(R.id.buttonMinus);
        bSubmit = findViewById(R.id.buttonSubmit);
        tvQuality = findViewById(R.id.textViewQuality);
        oneWay = findViewById(R.id.cbWay);
        roundTrip = findViewById(R.id.cbTrip);



        bMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(qual>=1){
                    qual = qual -1;
                }
                else{
                    Toast.makeText(MainActivity.this, "Number of pax should not be negative", Toast.LENGTH_SHORT).show();
                }
            }
        });
        bPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(qual>=1){
                    qual = qual +1;
                }
            }
        });


        if(oneWay.isChecked()){
             trip = "One Way Trip";

        }else if(roundTrip.isChecked()){
             trip = "Round Trip";
        }

        bSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FlightDetails.class);
                intent.putExtra("Trip","none");
                intent.putExtra("Pax",qual);
                startActivity(intent);
            }
        });
    }
}





