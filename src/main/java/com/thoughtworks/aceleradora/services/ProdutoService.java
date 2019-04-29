package com.thoughtworks.aceleradora.services;

import com.thoughtworks.aceleradora.dominio.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private ProdutoRepository repositorio;

    public ProdutoService(ProdutoRepository repositorio) {
        this.repositorio = repositorio;
    }

    public Iterable getAll() {

        return repositorio.findAll();
    }
}
