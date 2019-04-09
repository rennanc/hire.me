package com.rennan.shortUrl.view.dto;

import com.rennan.shortUrl.domain.Alias;

public class RequestAliasDto {

    private String alias;
    private String url;
    private StatisticsDto statisticsDto;

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public StatisticsDto getStatisticsDto() {
        return statisticsDto;
    }

    public void setStatisticsDto(StatisticsDto statisticsDto) {
        this.statisticsDto = statisticsDto;
    }

    public Alias getEntity(){
        Alias alias = new Alias();
        alias.setName(this.alias);
        alias.setUrl(this.url);
        return alias;
    }
}
