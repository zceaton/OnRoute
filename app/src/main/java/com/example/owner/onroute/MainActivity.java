package com.example.owner.onroute;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user clicks the Send button */
    public void sendMessage(View view) throws IOException {
        // Do something in response to button
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText1 = (EditText) findViewById(R.id.start);
        String startLocation = editText1.getText().toString();
        EditText editText2 = (EditText) findViewById(R.id.destination);
        String destination = editText2.getText().toString();

        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        List<Address> address = geocoder.getFromLocationName(destination,1);
        double latitude = address.get(0).getLatitude();
        double longitude = address.get(0).getLongitude();

        Bundle params = new Bundle();
        params.putDouble("LATITUDE", latitude);
        params.putDouble("LONGITUDE", longitude);
        intent.putExtras(params);
        startActivity(intent);
    }
}