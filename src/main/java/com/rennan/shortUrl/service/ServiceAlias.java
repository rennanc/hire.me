package com.rennan.shortUrl.service;

import com.rennan.shortUrl.domain.Alias;
import com.rennan.shortUrl.domain.service.ServiceAliasDomain;
import com.rennan.shortUrl.util.exception.DomainException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
public class ServiceAlias {

    @Autowired
    ServiceAliasDomain serviceAliasDomain;


    @Transactional
    public void create(Alias alias) throws DomainException {
        serviceAliasDomain.create(alias);
    }

    @Transactional
    public Alias findByName(String alias) {
        return serviceAliasDomain.findByName(alias);
    }

}
