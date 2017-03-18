package com.apps.karama.mybornapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }
    public void onkickClick (View theButton)
    {
        Intent kick = new Intent(this,kick_counter.class);
        startActivity(kick);
    }
    public void onhplClick (View theButton)
    {

        Intent hpl = new Intent(this,Hpl.class);
        startActivity(hpl);




    }
    public void onalarmClick (View theButton)
    {

        Intent alarm = new Intent(this,alaram.class);
        startActivity(alarm);




    }
    public void onkonstraksiClick (View theButton)
    {

        Intent kontraksi = new Intent(this,konstraksi.class);
        startActivity(kontraksi);




    }
    public void onmsbClick (View theButton)
    {

        Intent msb = new Intent(this,MasaSubur.class);
        startActivity(msb);




    }
    public void settingClick (View theButton)
    {

        Intent setting = new Intent(this,Settings.class);
        startActivity(setting);

    }
    public void addkick(View view){

        Intent intent = new Intent(this, kick_counter.class);
        startActivity(intent);
    }

    public void viewkick(View view){
        Intent intent = new Intent(this,DataKickActivity.class);
        startActivity(intent);
    }
}
