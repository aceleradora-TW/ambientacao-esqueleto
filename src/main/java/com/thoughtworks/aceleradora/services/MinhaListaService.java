package com.thoughtworks.aceleradora.services;

import com.thoughtworks.aceleradora.dominio.MinhaLista;
import com.thoughtworks.aceleradora.dominio.MinhaListaRepository;
import org.springframework.stereotype.Service;

@Service
public class MinhaListaService {

    private MinhaListaRepository repositorio;

    public MinhaListaService(MinhaListaRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void salvar(MinhaLista lista) {

        repositorio.save(lista);

    }

}
