package com.rennan.shortUrl.domain.service;

import com.rennan.shortUrl.data.IPostgreAliasData;
import com.rennan.shortUrl.domain.Alias;
import com.rennan.shortUrl.util.Enum.ErrorType;
import com.rennan.shortUrl.util.exception.DomainException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceAliasDomain {

    @Autowired
    private IPostgreAliasData postgreAliasData;

    public void create(Alias alias) throws DomainException{

        if(isThereEqualAlias(alias.getName())){
            throw new DomainException(ErrorType.ERROR_1);
        }

        postgreAliasData.save(alias);
    }

    private boolean isThereEqualAlias(String aliasName){
        return postgreAliasData.findByName(aliasName) != null;
    }

    public Alias findByName(String aliasName) throws DomainException{
        Alias alias = postgreAliasData.findByName(aliasName);

        if(alias == null){
            throw new DomainException(ErrorType.ERROR_2);
        }
        return alias;
    }

    public void saveVisit(Alias alias) {
        long visits = alias.getVisits() == null ? 0 : alias.getVisits();
        alias.setVisits(visits + 1);
        postgreAliasData.save(alias);
    }

    public List<Alias> getTopTenVisits() {
        return postgreAliasData.findTopTenVisits();
    }
}
