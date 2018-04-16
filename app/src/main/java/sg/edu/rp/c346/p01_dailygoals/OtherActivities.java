package sg.edu.rp.c346.p01_dailygoals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OtherActivities extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_activities);


        // Get the intent so as to get the "things" inside the intent
        Intent i = getIntent();
        // Get the String array named "info" we passed in
        String[] text = i.getStringArrayExtra("text");
        // Get the TextView object
        TextView tv1 = (TextView) findViewById(R.id.textView);
        // Display the name and age on the TextView
        tv1.setText("Read up on materials before class: " + text[0] + "\nArrive on time so as not to miss important part of the lesson: " + text[1] + "\nAttempt the problem myself: " + text[2] + "\nRefelection:" + text[3]);


        Button btn1 = (Button) findViewById(R.id.button2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Intent i = new Intent(OtherActivities.this,MainActivity.class);



                startActivity(i);



            }


        });
    }
}
