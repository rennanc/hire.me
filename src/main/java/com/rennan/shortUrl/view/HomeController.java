package com.rennan.shortUrl.view;

import com.rennan.shortUrl.domain.Alias;
import com.rennan.shortUrl.service.ServiceAlias;
import com.rennan.shortUrl.util.Enum.ErrorType;
import com.rennan.shortUrl.util.ShorturlUtils;
import com.rennan.shortUrl.util.exception.DomainException;
import com.rennan.shortUrl.view.dto.RequestAliasDto;
import com.rennan.shortUrl.view.dto.StatisticsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

@Controller
public class HomeController {

    @Autowired
    private ServiceAlias serviceAlias;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("now", LocalDateTime.now());
        model.addAttribute("requestAlias", new RequestAliasDto());
        return "index";
    }

    @RequestMapping
    public @ResponseBody
    RequestAliasDto create(RequestAliasDto requestAlias) {
        try{

            handleCreateAlias(requestAlias);

            requestAlias.setStatistics(new StatisticsDto());
            serviceAlias.create(requestAlias.getEntity());
        }catch (DomainException e){
            requestAlias.setErrorCode(e.getErrorType().getCode());
            requestAlias.setDescription(e.getErrorType().getDescription());
        }finally {
            requestAlias.getStatistics().setEndTime(Instant.now());
        }
        return requestAlias;
    }

    private void handleCreateAlias(RequestAliasDto requestAlias){
        if(StringUtils.isEmpty(requestAlias.getAlias())){
            int value = ShorturlUtils.decode(UUID.randomUUID().toString());
            requestAlias.setAlias(ShorturlUtils.encode(value));
        }
    }

    @RequestMapping("/u/{aliasName}")
    public @ResponseBody RequestAliasDto redirect(@PathVariable String aliasName, HttpServletResponse httpServletResponse) {
            RequestAliasDto requestAliasDto = new RequestAliasDto(Instant.now());
        try {
            Alias alias = serviceAlias.findByName(aliasName);
            httpServletResponse.sendRedirect("http://" +alias.getUrl());
        }catch (DomainException e){
            requestAliasDto.setErrorCode(e.getErrorType().getCode());
            requestAliasDto.setDescription(e.getErrorType().getDescription());
        }catch (IOException e) {
            requestAliasDto.setErrorCode(ErrorType.UNKNOW.getCode());
            requestAliasDto.setDescription(ErrorType.UNKNOW.getDescription());
        }finally {
            requestAliasDto.getStatistics().setEndTime(Instant.now());
        }
        return requestAliasDto;
    }
}
