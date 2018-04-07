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
                Intent sendIntent = new Intent();
                sendIntent.setAction(AlarmClock.ACTION_SET_ALARM);

                    sendIntent.putExtra(AlarmClock.EXTRA_MESSAGE, ((TextView)findViewById(R.id.bttnset)).getText().toString());
                    sendIntent.putExtra(AlarmClock.EXTRA_HOUR, Integer.parseInt(((TextView)findViewById(R.id.editTextHour)).getText().toString()));
                    sendIntent.putExtra(AlarmClock.EXTRA_MINUTES, Integer.parseInt(((TextView)findViewById(R.id.editTextMinutes)).getText().toString()));

                    if (sendIntent.resolveActivity(getPackageManager()) != null){
                        startActivity(sendIntent);
                        mensaje.setText("");
                        minuto.setText("");
                        hora.setText("");
                    }
            }
        });
    }
}
