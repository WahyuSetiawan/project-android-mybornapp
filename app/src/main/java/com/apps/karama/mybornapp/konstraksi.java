package com.apps.karama.mybornapp;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class konstraksi extends AppCompatActivity {

    Button mulai = null;
    Button stop = null;
    TextView detik = null;
    TextView menit = null;
    TextView jam = null;
    Handler rama = null;
    int txtdetik = 0;
    int txtmenit = 0;
    int txtjam = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konstraksi);
        mulai = (Button) findViewById(R.id.btnstart);
        stop = (Button) findViewById(R.id.btnstop);
        detik = (TextView) findViewById(R.id.txtdetik);
        menit = (TextView) findViewById(R.id.txtmenit);
        jam = (TextView) findViewById(R.id.txtjam);
        rama = new Handler();
        mulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Todo autu generated method sub
                rama.postDelayed(hitung, 1000);
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rama.removeCallbacks(hitung);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        //getMenuInflater().inflate(R.layout.activity_konstraksi);
        return true;


    }

    private Runnable hitung = new Runnable() {
        @Override
        public void run() {
            txtdetik++;
            detik.setText(String.valueOf(txtdetik));
            if (txtdetik >= 60) {
                txtmenit++;
                menit.setText(String.valueOf(txtmenit));
                txtdetik = 0;
            } else if (txtmenit >= 60) {
                txtjam++;
                jam.setText(String.valueOf(txtjam));
                txtmenit = 0;

            }
            rama.postDelayed(this, 1000);
        }
    };
}