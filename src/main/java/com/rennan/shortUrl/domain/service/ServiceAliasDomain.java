package com.rennan.shortUrl.domain.service;

import com.rennan.shortUrl.data.IPostgreAliasData;
import com.rennan.shortUrl.domain.Alias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class ServiceAliasDomain {

    @Autowired
    private IPostgreAliasData postgreAliasData;

    public Alias findByName(String aliasName){
        return postgreAliasData.findByName(aliasName);
    }

    public void create(Alias alias){

        Alias equivalentAlias = findByName(alias.getName());

        if(equivalentAlias == null){
            return; //TODO retornar uma mensagem ao usuário
        }

        postgreAliasData.save(alias);
    }

    private String generateAlias(){
        Date date = new Date();
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }
}
