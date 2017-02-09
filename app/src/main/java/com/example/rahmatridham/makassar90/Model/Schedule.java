package com.example.rahmatridham.makassar90.Model;

/**
 * Created by rahmatridham on 2/9/2017.
 */

public class Schedule {
    String band_id, stage, date, status;

    public Schedule(String band_id, String stage, String date, String status) {
        this.band_id = band_id;
        this.stage = stage;
        this.date = date;
        this.status = status;
    }

    public String getBand_id() {
        return band_id;
    }

    public void setBand_id(String band_id) {
        this.band_id = band_id;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
