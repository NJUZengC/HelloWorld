package com.example.zengc.helloworld;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class VibrateActivity extends AppCompatActivity {

    private Vibrator vibrator;
    long [] pattern = {2000,3000};
    private Button startVibrate = null;
    private Button cancelVibrate = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vibrate);
        vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        startVibrate = (Button)findViewById(R.id.StartVibrate);
        startVibrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText time = (EditText)findViewById(R.id.VibrateTime);
                String s = time.getText().toString().trim();
                if(s.equals(""))
                    return;
                int times = Integer.parseInt(s);
                if(times>0) {
                    times = Math.max(times,60);
                    if(vibrator.hasVibrator())
                        vibrator.cancel();
                    vibrator.vibrate(times*1000);
                }
            }
        });
        cancelVibrate = (Button)findViewById(R.id.CancelVibrate);
        cancelVibrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vibrator.hasVibrator())
                vibrator.cancel();
            }
        });

    }
}
