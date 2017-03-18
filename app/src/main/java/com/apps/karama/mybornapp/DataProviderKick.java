package com.apps.karama.mybornapp;

/**
 * Created by rama on 6/10/2016.
 */
public class DataProviderKick {
    private String tglkick;
    private String jmlkick;
    private String timerkick;


    public String getTglkick() {
        return tglkick;
    }

    public void setTglkick(String tglkick) {
        this.tglkick = tglkick;
    }

    public String getJmlkick() {
        return jmlkick;
    }

    public void setJmlkick(String jmlkick) {
        this.jmlkick = jmlkick;
    }

    public String getTimerkick() {
        return timerkick;
    }

    public void setTimerkick(String timerkick) {
        this.timerkick = timerkick;
    }

    public DataProviderKick(String tglkick, String jmlkick, String timerkick){
        this.tglkick = tglkick;
        this.jmlkick = jmlkick;
        this.timerkick=timerkick;

    }
}
