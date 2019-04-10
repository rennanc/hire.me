package com.rennan.shortUrl.domain.service;

import com.rennan.shortUrl.data.IPostgreAliasData;
import com.rennan.shortUrl.domain.Alias;
import com.rennan.shortUrl.util.Enum.ErrorType;
import com.rennan.shortUrl.util.exception.DomainException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceAliasDomain {

    @Autowired
    private IPostgreAliasData postgreAliasData;

    public void create(Alias alias) throws DomainException{

        Alias equivalentAlias = findByName(alias.getName());

        if(equivalentAlias != null){
            throw new DomainException(ErrorType.ERROR_1);
        }

        postgreAliasData.save(alias);
    }

    public Alias findByName(String aliasName){
        return postgreAliasData.findByName(aliasName);
    }
}
