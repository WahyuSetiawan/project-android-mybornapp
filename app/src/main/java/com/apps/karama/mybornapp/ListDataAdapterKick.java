package com.apps.karama.mybornapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by rama on 6/10/2016.
 */

public class ListDataAdapterKick extends ArrayAdapter<Kick> {

    Context context;
    int layoutResourceId;
    Kick[] data;

    public ListDataAdapterKick(Context context, int layoutResourceId, Kick[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        LayoutHandler layoutHandler;

        Log.d(data[position].getCount(),data[position].getDate());

        if (row == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layoutkick, parent, false);

            layoutHandler = new LayoutHandler();
            layoutHandler.TANGGAL = (TextView) row.findViewById(R.id.text_user_tanggal);
            layoutHandler.JUMLAHKICK = (TextView) row.findViewById(R.id.text_count_gerkan);
            layoutHandler.TIMER = (TextView) row.findViewById(R.id.text_waktu_gerakan);

            row.setTag(layoutHandler);
        } else {
            layoutHandler = (LayoutHandler) row.getTag();
        }
        layoutHandler.TANGGAL.setText(data[position].getDate());
        layoutHandler.JUMLAHKICK.setText(data[position].getCount());
        layoutHandler.TIMER.setText(data[position].getWaktu_gerakan());

        return row;
    }


    static class LayoutHandler {
        TextView TANGGAL, JUMLAHKICK, TIMER;
    }
}

/*public class ListDataAdapterKick extends ArrayAdapter <Kick>{
   ArrayList<Kick> kicks = new ArrayList<>();
    Context context;
    int layoutResourceId;

    public ListDataAdapterKick(Context context, int layoutResourceId, Weather[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    static class LayoutHandler {
        TextView TANGGAL, JUMLAHKICK, TIMER;
    }

    @Override
    public int getCount() {
        return kicks.size();
    }

    @Override
    public Kick getItem(int position) {
        return kicks.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        LayoutHandler layoutHandler;
        if (row == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layoutkick, parent, false);

            layoutHandler = new LayoutHandler();
            layoutHandler.TANGGAL = (TextView) row.findViewById(R.id.text_user_tanggal);
            layoutHandler.JUMLAHKICK = (TextView) row.findViewById(R.id.text_count_gerkan);
            layoutHandler.TIMER = (TextView) row.findViewById(R.id.text_waktu_gerakan);
            row.setTag(layoutHandler);
        } else {
            layoutHandler = (LayoutHandler) row.getTag();
        }

        layoutHandler.JUMLAHKICK.setText(kicks.get(position).getCount());
        layoutHandler.TIMER.setText(kicks.get(position).getWaktu_gerakan());

        return row;
    }
}
*/