package com.rennan.shortUrl.data;

import com.rennan.shortUrl.domain.Alias;
import org.springframework.data.repository.CrudRepository;

/**
 * Contrato de serviço de comunicação com o banco de dados
 */
public interface IPostgreAliasData extends CrudRepository<Alias, Long> {

    Alias findByName(String aliasName);
}
