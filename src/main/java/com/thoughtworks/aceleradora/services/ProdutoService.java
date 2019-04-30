package com.thoughtworks.aceleradora.services;

import com.thoughtworks.aceleradora.dominio.Produto;
import com.thoughtworks.aceleradora.dominio.ProdutoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private ProdutoRepositorio repositorio;

    public ProdutoService(ProdutoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<Produto> getAll() {
        return repositorio.findAll();
    }
}
