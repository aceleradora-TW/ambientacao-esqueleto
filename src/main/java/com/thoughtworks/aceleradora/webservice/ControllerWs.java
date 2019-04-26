package com.thoughtworks.aceleradora.webservice;

import com.thoughtworks.aceleradora.dominio.Lista;
import com.thoughtworks.aceleradora.dominio.ListaRepository;
import com.thoughtworks.aceleradora.dominio.Produto;
import com.thoughtworks.aceleradora.dominio.ProdutoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api")
public class ControllerWs {


    private ProdutoRepository produtoRepository;
    private ListaRepository listaRepository;

    public ControllerWs(
            ProdutoRepository repositorio,
            ListaRepository listaRepository
    ){

        this.produtoRepository = repositorio;
        this.listaRepository = listaRepository;
    }

    @ResponseBody
    @GetMapping("/produtos")
    List<Produto> allProducts() {
        return (List<Produto>) produtoRepository.findAll();
    }

    @ResponseBody
    @GetMapping("/listas")
    List<Lista> allLists() {
        return (List<Lista>) listaRepository.findAll();
    }


    @ResponseBody
    @GetMapping("/addProdutos")
    public List<Produto> addLista(Model model, @RequestParam(value = "produtos", required=false) List<String> produtos) {
        if(produtos!= null && !produtos.isEmpty()){
            produtos.stream().forEach(k -> produtoRepository.save(new Produto(k)));
        }
        return (List<Produto>) produtoRepository.findAll();
    }
}
