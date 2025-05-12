
package com.papelaria.catarse.service;

import com.papelaria.catarse.model.Produto;
import com.papelaria.catarse.repository.ProdutoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtorepository;
    
    public Produto salvar(Produto produto){
        return produtorepository.save(produto);
    }
    public List<Produto> listarTodos(){
        return produtorepository.findAll();
    }
    
    public Produto buscarPorId(int id){
        return produtorepository.findById(id).orElse(null);
    }
    
    public void excluir(int id){
        produtorepository.deleteById(id);
    }
    
}
