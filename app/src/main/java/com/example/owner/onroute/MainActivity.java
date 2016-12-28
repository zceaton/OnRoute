package com.example.owner.onroute;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user clicks the Send button */
    public void sendMessage(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText1 = (EditText) findViewById(R.id.start);
        String startLocation = editText1.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, startLocation);
        EditText editText2 = (EditText) findViewById(R.id.destination);
        String destination = editText2.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, destination);
        startActivity(intent);
    }
}
