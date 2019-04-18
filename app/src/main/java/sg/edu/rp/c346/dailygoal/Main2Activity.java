package sg.edu.rp.c346.dailygoal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    Button close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv1 = findViewById(R.id.textView);
        tv2 = findViewById(R.id.textView2);
        tv3 = findViewById(R.id.textView3);
        tv4 = findViewById(R.id.textView4);
        close = findViewById(R.id.button2);

        Bundle extras = getIntent().getExtras();
        String value1 = extras.getString("1");
        String value2 = extras.getString("2");
        String value3 = extras.getString("3");
        String value4 = extras.getString("reflection");

        tv1.setText("Read up on materials before class : " + value1);
        tv2.setText("Arrive on time so as not to miss important part of the lesson : " + value2);
        tv3.setText("Attempt the problem myself : " + value3);
        tv4.setText("Reflection : " + value4);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
