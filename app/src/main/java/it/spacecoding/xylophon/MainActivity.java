package it.spacecoding.xylophon;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Hashtable;

public class MainActivity extends AppCompatActivity {
    private Button buttonA, buttonB, buttonC, buttonD, buttonE, buttonF, buttonG;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonA = (Button) findViewById(R.id.buttonA);
        buttonB = (Button) findViewById(R.id.buttonB);
        buttonC = (Button) findViewById(R.id.buttonC);
        buttonD = (Button) findViewById(R.id.buttonD);
        buttonE = (Button) findViewById(R.id.buttonE);
        buttonF = (Button) findViewById(R.id.buttonF);
        buttonG= (Button) findViewById(R.id.buttonG);
        int notes[] = {R.raw.a, R.raw.b, R.raw.c, R.raw.d, R.raw.e, R.raw.f, R.raw.g};
        Hashtable<String, Integer> hashtable = new Hashtable<>();
        hashtable.put(buttonA.getText().toString(), new Integer(notes[0]));
        hashtable.put(buttonB.getText().toString(), new Integer(notes[1]));
        hashtable.put(buttonC.getText().toString(), new Integer(notes[2]));
        hashtable.put(buttonD.getText().toString(), new Integer(notes[3]));
        hashtable.put(buttonE.getText().toString(), new Integer(notes[4]));
        hashtable.put(buttonF.getText().toString(), new Integer(notes[5]));
        hashtable.put(buttonG.getText().toString(), new Integer(notes[6]));


        View.OnClickListener listener = new View.OnClickListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                String noteName = button.getText().toString();
                Log.d("MainActivity","Nome della nota: " + noteName);
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), Integer.valueOf(hashtable.get(noteName)));
                mediaPlayer.start();
            }
        };
        buttonA.setOnClickListener(listener);
        buttonB.setOnClickListener(listener);
        buttonC.setOnClickListener(listener);
        buttonD.setOnClickListener(listener);
        buttonE.setOnClickListener(listener);
        buttonF.setOnClickListener(listener);
        buttonG.setOnClickListener(listener);

    }


}