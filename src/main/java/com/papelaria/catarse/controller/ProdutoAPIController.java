
package com.papelaria.catarse.controller;

import com.papelaria.catarse.model.Produto;
import com.papelaria.catarse.service.ProdutoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produto")
@CrossOrigin(origins="*")

public class ProdutoAPIController {
    @Autowired
    private ProdutoService produtoService;
    
    @GetMapping
    public List<Produto> listarTodos(){
        return produtoService.listarTodos();
    }
    
    @GetMapping("/{id}")
    public Produto buscarProduto(@PathVariable int id){
        return produtoService.buscarPorId(id);
    }
    
    @PostMapping
    public Produto criarProduto(@RequestBody Produto produto){
        return produtoService.salvar(produto);
    }
    
    @PutMapping("/{id}")
    public Produto atualizarFilme(@PathVariable int id, @RequestBody Produto produtoAtualizado){
        Produto produto = produtoService.buscarPorId(id);
        produto.setNome(produtoAtualizado.getNome());
        produto.setDescricao(produtoAtualizado.getDescricao());
        produto.setEstoque(produtoAtualizado.getEstoque());
        produto.setPreco(produtoAtualizado.getPreco());

        
        produtoService.salvar(produto);
        return produtoService.salvar(produtoAtualizado);
    }
    
    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable int id){
        produtoService.excluir(id);
    }
}
