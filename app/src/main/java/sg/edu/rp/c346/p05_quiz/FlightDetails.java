package sg.edu.rp.c346.p05_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FlightDetails extends AppCompatActivity {

    TextView tvDisplay;
    TextView tvDisplay2;
    int cost =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_details);


        tvDisplay = findViewById(R.id.textView2);
        tvDisplay2 = findViewById(R.id.textView4);


        Intent intentReceived = getIntent();
        int pax = intentReceived.getIntExtra("Pax",0);
        String trip = intentReceived.getStringExtra("Trip");


        if(trip.equals("One Way Trip")){
            cost = 100*pax;
        }
        else{
             cost = 100*pax*2;
        }
        tvDisplay.setText("You have selected "+trip);
        tvDisplay2.setText("Your air ticket costs"+ cost);
    }
}
