package sg.edu.rp.c346.dailygoal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    RadioButton radio_1a;
    RadioButton radio_1b;
    RadioButton radio_2a;
    RadioButton radio_2b;
    RadioButton radio_3a;
    RadioButton radio_3b;

    EditText reflection;
    Button ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radio_1a = findViewById(R.id.radioButton_1a);
        radio_1b = findViewById(R.id.radioButton_1b);
        radio_2a = findViewById(R.id.radioButton_2a);
        radio_2b = findViewById(R.id.radioButton_2b);
        radio_3a = findViewById(R.id.radioButton_3a);
        radio_3b = findViewById(R.id.radioButton_3b);
        reflection = findViewById(R.id.editText);
        ok = findViewById(R.id.button);

        SharedPreferences prefs = getSharedPreferences("MyPref", MODE_PRIVATE);
        String value1 = prefs.getString("1", null);
        String value2 = prefs.getString("2", null);
        String value3 = prefs.getString("3", null);
        String value4 = prefs.getString("reflection", null);

        if (value1 != null) {
            if (value1.equals("Yes")) {
                radio_1a.setChecked(true);
            }
            else {
                radio_1b.setChecked(true);
            }
        }

        if (value2 != null) {
            if (value2.equals("Yes")) {
                radio_2a.setChecked(true);
            }
            else {
                radio_2b.setChecked(true);
            }
        }

        if (value3 != null) {
            if (value3.equals("Yes")) {
                radio_3a.setChecked(true);
            }
            else{
                radio_3b.setChecked(true);
            }
        }

        if (value4 != null) {
            reflection.setText(value4);
        }


        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Value1 = "";
                if (radio_1a.isChecked()) {
                    Value1 = radio_1a.getText().toString();
                }
                else if (radio_1b.isChecked()) {
                    Value1 = radio_1b.getText().toString();
                }

                String Value2 = "";
                if (radio_2a.isChecked()) {
                    Value2 = radio_2a.getText().toString();
                }
                else if (radio_2b.isChecked()) {
                    Value2 = radio_2b.getText().toString();
                }

                String Value3 = "";
                if (radio_3a.isChecked()) {
                    Value3 = radio_3a.getText().toString();
                }
                else if (radio_3b.isChecked()) {
                    Value3 = radio_3b.getText().toString();
                }

                String ref = reflection.getText().toString();

                Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                i.putExtra("1", Value1);
                i.putExtra("2", Value2);
                i.putExtra("3", Value3);
                i.putExtra("reflection", ref);
                // Set the request code to any code you like, you can identify the
                // callback via this code

                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();

                editor.putString("1", Value1);
                editor.putString("2", Value2);
                editor.putString("3", Value3);
                editor.putString("reflection", ref);

                editor.commit(); // commit changes

                startActivity(i);
            }
        });



    }
}
