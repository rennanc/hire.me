package com.rennan.shortUrl.service;

import com.rennan.shortUrl.domain.Alias;
import com.rennan.shortUrl.domain.service.ServiceAliasDomain;
import com.rennan.shortUrl.util.exception.DomainException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
public class ServiceAlias {

    @Autowired
    ServiceAliasDomain serviceAliasDomain;


    @Transactional
    public void create(Alias alias) throws DomainException {
        serviceAliasDomain.create(alias);
    }

    public Alias findByName(String alias) throws DomainException{
        return serviceAliasDomain.findByName(alias);
    }

    @Transactional
    public void saveVisit(Alias alias) {
        serviceAliasDomain.saveVisit(alias);
    }

    public List<Alias> getTopTenVisits() {
        return serviceAliasDomain.getTopTenVisits();
    }
}
