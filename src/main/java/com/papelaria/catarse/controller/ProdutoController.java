
package com.papelaria.catarse.controller;

import com.papelaria.catarse.model.Produto;
import com.papelaria.catarse.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    
    @GetMapping ("/")
    public String inicio(){
    return "index";
    }
    
    @GetMapping ("/cadastro")
    public String exibirFormulario(@CookieValue(name = "pref-estilo", defaultValue="claro") String tema, Model model){
     model.addAttribute("css",tema);   
        model.addAttribute("produto", new Produto());
    return "cadastro";
    }
    
    @PostMapping("/gravar")
    public String processarFormulario(@CookieValue(name = "pref-estilo", defaultValue="claro") String tema, Model model,@ModelAttribute Produto produto){
    produtoService.salvar(produto);
    return "redirect:/produto/lista";
    }
    
    @GetMapping("/lista")
    public String lista(@CookieValue(name = "pref-estilo", defaultValue="claro") String tema, Model model){
        model.addAttribute("css",tema);
        model.addAttribute("produtos", produtoService.listarTodos());
        return "lista";
    }
    
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable int id) {
    produtoService.excluir(id);
    return "redirect:/produto/lista";
    }
    
    @GetMapping("/alterar/{id}")
    public String alterar(@PathVariable int id, @CookieValue(name = "pref-estilo", defaultValue="claro") String tema, Model model,@ModelAttribute Produto produto){
    model.addAttribute("css",tema);
    model.addAttribute("produto", produtoService.buscarPorId(id));
    return "cadastro";
    }
    
}
