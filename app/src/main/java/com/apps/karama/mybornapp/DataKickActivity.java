package com.apps.karama.mybornapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class DataKickActivity extends ActionBarActivity {
    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    UserDBKickHelper userDBKickHelper;
    Cursor cursor;
    ListDataAdapterKick listDataAdapterKick;

    Kick kick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_kick);
        listView = (ListView) findViewById(R.id.list_view);

        userDBKickHelper = new UserDBKickHelper(getApplicationContext());
        ArrayList<Kick> kicks = userDBKickHelper.getInformations();
        Kick[] kickArray = kicks.toArray(new Kick[kicks.size()]);
        listDataAdapterKick = new ListDataAdapterKick(getApplicationContext(), R.layout.row_layoutkick, kickArray);
        listView.setAdapter(listDataAdapterKick);

    }

    public void addShow(View theButton) {
        Intent show = new Intent(this, Settings.class);
        startActivity(show);
    }
}
