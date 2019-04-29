package com.thoughtworks.aceleradora.controllers;

import com.thoughtworks.aceleradora.dominio.MinhaLista;
import com.thoughtworks.aceleradora.dominio.MinhaListaRepository;
import com.thoughtworks.aceleradora.services.MinhaListaService;
import com.thoughtworks.aceleradora.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/minhalista")

public class MinhaListaController {

    private ProdutoService produtoService;
    private MinhaListaService minhaListaService;

    @Autowired
    public MinhaListaController(ProdutoService produtoService, MinhaListaService minhaListaService) {
        this.produtoService = produtoService;
        this.minhaListaService = minhaListaService;
    }


    @GetMapping("/criar")
    public String criarLista(Model model) {

        model.addAttribute("produtos", produtoService.getAll());
        return "/minhaLista/cadastroLista";
    }


    @PostMapping("/criar")
    public String salvarLista(MinhaLista lista) {

        minhaListaService.salvar(lista);

        return "/minhaLista/cadastroLista";
    }

}

