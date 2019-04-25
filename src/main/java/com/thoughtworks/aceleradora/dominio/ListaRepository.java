package com.thoughtworks.aceleradora.dominio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaRepository extends CrudRepository<Lista, Long> {
}

