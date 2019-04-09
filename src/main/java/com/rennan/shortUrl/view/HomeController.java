package com.rennan.shortUrl.view;

import com.rennan.shortUrl.domain.service.ServiceAliasDomain;
import com.rennan.shortUrl.service.ServiceAlias;
import com.rennan.shortUrl.view.dto.RequestAliasDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

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
    public RequestAliasDto create(@RequestBody(required = false) RequestAliasDto requestAliasDto){
        serviceAlias.create(requestAliasDto.getEntity());
        return null;
    }
}
