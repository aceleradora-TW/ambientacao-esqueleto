package com.thoughtworks.aceleradora.webservice;

import com.thoughtworks.aceleradora.dominio.MinhaLista;
import com.thoughtworks.aceleradora.dominio.MinhaListaRepository;
import com.thoughtworks.aceleradora.dominio.Produto;
import com.thoughtworks.aceleradora.dominio.ProdutoRepositorio;
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


    private ProdutoRepositorio produtoRepositorio;
    private MinhaListaRepository minhaListaRepository;

    public ControllerWs(
            ProdutoRepositorio repositorio,
            MinhaListaRepository minhaListaRepository
    ){

        this.produtoRepositorio = repositorio;
        this.minhaListaRepository = minhaListaRepository;
    }

    @ResponseBody
    @GetMapping("/produtos")
    List<Produto> allProducts() {
        return (List<Produto>) produtoRepositorio.findAll();
    }

    @ResponseBody
    @GetMapping("/listas")
    List<MinhaLista> allLists() {
        return (List<MinhaLista>) minhaListaRepository.findAll();
    }

    @ResponseBody
    @GetMapping("/addProdutos")
    public List<Produto> addLista(Model model, @RequestParam(value = "produtos", required=false) List<String> produtos) {
        if(produtos!= null && !produtos.isEmpty()){
            produtos.stream().forEach(k -> produtoRepositorio.save(new Produto(k)));
        }
        return (List<Produto>) produtoRepositorio.findAll();
    }
}
