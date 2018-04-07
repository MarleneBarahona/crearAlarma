package com.barahona.crearalarma;

import android.content.Intent;
import android.net.Uri;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button setAlarm;
    EditText hora;
    EditText minuto;
    EditText mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setAlarm = (Button) findViewById(R.id.bttnset);

        setAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               TextView mssg = ((TextView)findViewById(R.id.editTextmssg));
               TextView hour = (TextView)findViewById(R.id.editTextHour);
               TextView minutes = (TextView)findViewById(R.id.editTextMinutes);
                Intent sendIntent = new Intent();
                sendIntent.setAction(AlarmClock.ACTION_SET_ALARM);
                if((hour.length() < 3) & (minutes.length() < 3)){
                    sendIntent.putExtra(AlarmClock.EXTRA_MESSAGE, mssg.getText().toString());
                    sendIntent.putExtra(AlarmClock.EXTRA_HOUR, Integer.parseInt(hour.getText().toString()));
                    sendIntent.putExtra(AlarmClock.EXTRA_MINUTES, Integer.parseInt(minutes.getText().toString()));

                    if (sendIntent.resolveActivity(getPackageManager()) != null){
                        startActivity(sendIntent);
                    }

                }
            }
        });
    }
}
