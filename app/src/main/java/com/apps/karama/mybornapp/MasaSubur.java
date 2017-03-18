package com.apps.karama.mybornapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MasaSubur extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masa_subur);

    }

    protected static Calendar tambahWaktuCalendar(Date waktuPermulaan,
                                                  int jmlTambahanWaktu, String satuan) {


        //Untuk mengurangi hari gunakan nilai minus (-) pada jmlTambahanWaktu

        Calendar cal = Calendar.getInstance();
        cal.setTime(waktuPermulaan);
        switch (satuan) {
            case "hari":
                cal.add(Calendar.DATE, jmlTambahanWaktu);
                break;
            case "bulan":
                cal.add(Calendar.MONTH, jmlTambahanWaktu);
                break;
            case "tahun":
                cal.add(Calendar.YEAR, jmlTambahanWaktu);
                break;
            case "jam":
                cal.add(Calendar.HOUR, jmlTambahanWaktu);
                break;
            case "menit":
                cal.add(Calendar.MINUTE, jmlTambahanWaktu);
                break;
            case "detik":
                cal.add(Calendar.SECOND, jmlTambahanWaktu);
                break;
            case "milidetik":
                cal.add(Calendar.MILLISECOND, jmlTambahanWaktu);
                break;
        }
        return cal;
    }

    // Menampilkan Date terformat
    protected static String tampilkanTanggalDanWaktu(Date tanggalDanWaktu,
                                                     String pola, Locale lokal) {
        String tanggalStr;
        SimpleDateFormat formatter;
        if (lokal == null) {
            formatter = new SimpleDateFormat(pola);
        } else {
            formatter = new SimpleDateFormat(pola, lokal);
        }
        tanggalStr = formatter.format(tanggalDanWaktu);
        return tanggalStr;


    }
}