package sg.edu.rp.c346.p01_dailygoals;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn1 = (Button)findViewById(R.id.button);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RadioGroup rg1 = (RadioGroup)findViewById(R.id.radioGroup1);
                int selectedButton1 = rg1.getCheckedRadioButtonId();
                RadioButton rb1 = (RadioButton)findViewById(selectedButton1);



                RadioGroup rg2 = (RadioGroup)findViewById(R.id.radioGroup2);
                int selectedButton2 = rg2.getCheckedRadioButtonId();

                RadioButton rb2 = (RadioButton)findViewById(selectedButton2);

                RadioGroup rg3 = (RadioGroup)findViewById(R.id.radioGroup3);
                int selectedButton3 = rg3.getCheckedRadioButtonId();
                RadioButton rb3 = (RadioButton)findViewById(selectedButton3);

                EditText et = (EditText)findViewById(R.id.editText);




                String[] text = {rb1.getText().toString().trim(),
                        rb2.getText().toString().trim(),rb3.getText().toString().trim(), et.getText().toString().trim()};





                Intent i = new Intent(MainActivity.this,OtherActivities.class);

                i.putExtra("text",text);

                startActivity(i);





            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        String strRelf = prefs.getString("ref","");
        int option1 = prefs.getInt("op1",1);
        int option2 = prefs.getInt("op2",1);
        int option3 = prefs.getInt("op3",1);

        EditText et = (EditText)findViewById(R.id.editText);

        et.setText(strRelf);

        RadioGroup rg1 = (RadioGroup)findViewById(R.id.radioGroup1);


        RadioGroup rg2 = (RadioGroup)findViewById(R.id.radioGroup2);

        RadioGroup rg3 = (RadioGroup)findViewById(R.id.radioGroup3);

        rg1.check(option1);
        rg2.check(option2);
        rg3.check(option3);



    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        SharedPreferences.Editor prefEdit= prefs.edit();

        EditText et = (EditText)findViewById(R.id.editText);

        prefEdit.putString("ref",et.getText().toString().trim());

        RadioGroup rg1 = (RadioGroup)findViewById(R.id.radioGroup1);
        int selectedButton1 = rg1.getCheckedRadioButtonId();

        RadioGroup rg2 = (RadioGroup)findViewById(R.id.radioGroup2);
        int selectedButton2 = rg2.getCheckedRadioButtonId();

        RadioGroup rg3 = (RadioGroup)findViewById(R.id.radioGroup3);
        int selectedButton3 = rg3.getCheckedRadioButtonId();


        prefEdit.putInt("op1",selectedButton1);
        prefEdit.putInt("op2",selectedButton2);
        prefEdit.putInt("op3",selectedButton3);

        prefEdit.commit();



    }
}



