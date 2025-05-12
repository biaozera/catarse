
package com.papelaria.catarse.repository;

import com.papelaria.catarse.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository  extends JpaRepository<Produto, Integer>{
    
}
