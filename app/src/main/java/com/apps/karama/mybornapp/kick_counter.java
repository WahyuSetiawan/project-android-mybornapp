package com.apps.karama.mybornapp;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class kick_counter extends AppCompatActivity {
    //EditText  tgl, tampil, detik;
    Context context = this;
    UserDBKickHelper userDBKickHelper;
    SQLiteDatabase sqLiteDatabase;

    int clicked = 0;

    Button mulai = null;
    Button counter = null;
    Button stop = null;
    TextView detik = null;
    TextView menit = null;
    TextView tgl = null;
    TextView tampil = null;
    TextView text;
    Handler rama = null;
    int txtdetik = 0;
    int txtmenit = 0;


    private Handler handler = new Handler();
    //int i = 0;
    //int clicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kick_counter);
        tgl = (TextView) findViewById(R.id.txttanggal);
        tampil = (TextView) findViewById(R.id.txtscreen);
        detik = (TextView) findViewById(R.id.txtdetik);


        handler.postDelayed(runnable, 1000);
        final TextView text = (TextView) findViewById(R.id.txtscreen);
        text.setText("0");
        final Button button = (Button) findViewById(R.id.btcount);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked++;
                text.setText("" + clicked + "");
            }

        });
        mulai = (Button) findViewById(R.id.btnstart);
        stop = (Button) findViewById(R.id.btnstop);
        detik = (TextView) findViewById(R.id.txtdetik);
        menit = (TextView) findViewById(R.id.txtmenit);
        tgl = (TextView) findViewById(R.id.txttanggal);
        tampil = (TextView) findViewById(R.id.txtscreen);


        //jam = (TextView) findViewById(R.id.txtjam);
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

    public void addKick(View view) {
        Kick kick = new Kick();
        kick.setDate(tgl.getText().toString());
        kick.setWaktu_gerakan(tampil.getText().toString());
        kick.setCount(detik.getText().toString());
        userDBKickHelper = new UserDBKickHelper(context);
        userDBKickHelper.addInformations(kick);
    }

    public void addShow(View view) {
        Intent show = new Intent(this, DataKickActivity.class);
        startActivity(show);
    }


    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Calendar c1 = Calendar.getInstance();
            SimpleDateFormat sdf1 = new SimpleDateFormat();
            String strdate1 = sdf1.format(c1.getTime());
            TextView txtdate1 = (TextView) findViewById(R.id.txttanggal);
            txtdate1.setText(strdate1);
        }
        //handler.postDelayed(this, 1000);
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.Main, menu);
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
                //txtjam++;
                //jam.setText(String.valueOf(txtjam));
                txtmenit = 0;

            }
            rama.postDelayed(this, 1000);
        }
    };
}



