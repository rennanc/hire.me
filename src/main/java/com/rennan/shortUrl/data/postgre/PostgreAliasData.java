package com.rennan.shortUrl.data.postgre;

import com.rennan.shortUrl.data.IPostgreAliasData;
import com.rennan.shortUrl.domain.Alias;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public abstract class PostgreAliasData implements IPostgreAliasData {


    @PersistenceContext
    private EntityManager manager;

    @Override
    public Alias findByName(String aliasName){

        StringBuilder jpql = new StringBuilder(" SELECT alias from Alias alias ")
                .append(" WHERE UPPER(alias.name) = UPPER(:name) ");


        TypedQuery<Alias> query = manager.createQuery(jpql.toString(), Alias.class);
        query.setParameter("name", aliasName);

        try{
            return query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public List<Alias> findTopTenVisits(){

        StringBuilder jpql = new StringBuilder(" SELECT alias from Alias alias ")
                .append(" ORDER BY alias.visits DESC ");


        TypedQuery<Alias> query = manager.createQuery(jpql.toString(), Alias.class);
        query.setMaxResults(10);

        return query.getResultList();
    }

}
