package com.rennan.shortUrl.view.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rennan.shortUrl.domain.Alias;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestAliasDto {

    private String alias;
    private String url;
    @JsonProperty("err_code")
    private String errorCode;
    private String description;
    private StatisticsDto statistics;

    public RequestAliasDto() {
    }

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

    public StatisticsDto getStatistics() {
        return statistics;
    }

    public void setStatistics(StatisticsDto statistics) {
        this.statistics = statistics;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonIgnore
    public Alias getEntity(){
        Alias alias = new Alias();
        alias.setName(this.alias);
        alias.setUrl(this.url);
        return alias;
    }
}
