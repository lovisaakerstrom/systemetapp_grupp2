package se.juneday.systemetapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {



    private static final String TAG = "SystembolagetApp";
    private Button b;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);

        Button btn = (Button) findViewById(R.id.firstButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.i(TAG, "less than 20");

                Toast.makeText(getApplicationContext(), "För att besöka sidan måste du vara över 20 år", Toast.LENGTH_LONG)
                        .show();

            }
        });

        b = (Button) findViewById(R.id.secondButton);
        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent i = new Intent( FirstActivity.this, MainActivity.class);
                startActivity(i);
                
            }

        });

    }


}
