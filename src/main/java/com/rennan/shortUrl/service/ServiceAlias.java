package com.rennan.shortUrl.service;

import com.rennan.shortUrl.domain.Alias;
import com.rennan.shortUrl.domain.service.ServiceAliasDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
public class ServiceAlias {

    @Autowired
    ServiceAliasDomain serviceAliasDomain;


    @Transactional
    public void create(Alias alias){
        serviceAliasDomain.create(alias);
    }

}
