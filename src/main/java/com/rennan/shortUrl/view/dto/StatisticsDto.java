package com.rennan.shortUrl.view.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Duration;
import java.time.Instant;

@JsonIgnoreProperties( { "startTime", "endTime" })
public class StatisticsDto {

    private final String MILISECONDS = "ms";

    private Instant startTime;
    private Instant endTime;

    public StatisticsDto(){
        this.startTime = Instant.now();
    }

    public Instant getStartTime() {
        return startTime;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }

    public Instant getEndTime() {
        return endTime;
    }

    public void setEndTime(Instant endTime) {
        this.endTime = endTime;
    }

    @JsonProperty("time_taken")
    public String getTimetaken() {
        if(this.startTime != null && this.endTime != null){
            return Duration.between(this.startTime, this.endTime).toMillis() + MILISECONDS;
        }
        return null;
    }
}
