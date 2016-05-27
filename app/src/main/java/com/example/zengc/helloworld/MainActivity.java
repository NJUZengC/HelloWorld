package com.example.zengc.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button searchButton;
    private Button noteButton;
    private Button vibrateButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchButton = (Button)findViewById(R.id.searchword);
        searchButton.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this,SearchActivity.class);
                        startActivity(intent);

                    }
                }
        );

        noteButton = (Button) findViewById(R.id.Note);
        noteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,NoteActivity.class);
                startActivity(intent);

            }
        });

        vibrateButton = (Button)findViewById(R.id.Vibrate);
        vibrateButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,VibrateActivity.class);
                startActivity(intent);
            }
        });
    }


}
