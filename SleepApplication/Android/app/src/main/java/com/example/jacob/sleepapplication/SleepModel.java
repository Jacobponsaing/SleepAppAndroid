package com.example.jacob.sleepapplication;

import java.util.Date;

public class SleepModel {

    private String student_id;
    private Date sleep_time;
    private Date awoke_time;
    private Integer sleep_quality;
    private Integer caffeine_intake;
    private Integer alcohol_intake;
    private Integer screen_time;
    private Integer physical_activity;
    private Integer work_in_bedroom;
    private Integer worries_in_bedroom;
    private Integer smoking;
    private Integer tired_before_bed;

    public SleepModel(String student_id, Date sleep_time, Date awoke_time, Integer... params) {
        this.student_id = student_id;
        this.sleep_time = sleep_time;
        this.awoke_time = awoke_time;
        this.sleep_quality = params[0];
        this.alcohol_intake = params[1];
        this.screen_time = params[2];
        this.physical_activity = params[3];
        this.work_in_bedroom = params[4];
        this.worries_in_bedroom = params[5];
        this.smoking= params[6];
        this.tired_before_bed= params[7];
    }

}
