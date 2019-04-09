package com.rennan.shortUrl.view.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public class StatisticsDto {

    @JsonAlias("time_taken")
    private String timetaken;

    public String getTimetaken() {
        return timetaken;
    }

    public void setTimetaken(String timetaken) {
        this.timetaken = timetaken;
    }
}
