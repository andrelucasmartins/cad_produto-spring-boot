package br.com.cadproduto.ws.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadproduto.ws.model.Produto;
import br.com.cadproduto.ws.service.ProdudoService;

@RestController
public class ProdutoController {
	@Autowired
	private ProdudoService serviceProdudo;
	
	// Endpoints	
	@PostMapping(value="/produtos", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Produto> cadastrarProduto(@RequestBody Produto produto){
		Produto produtoCadastrado = serviceProdudo.cadastrar(produto);
		return new ResponseEntity<>(produtoCadastrado, HttpStatus.CREATED);
	}
	
	@GetMapping(value="/produtos",  produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Produto>> buscarTodosProduto(){
		Collection<Produto> produtosBuscados = serviceProdudo.buscarTodos();
		return new ResponseEntity<>(produtosBuscados, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/produtos/{id}")
	public ResponseEntity<Produto> excluirProduto(@PathVariable long id){
		Produto produtoEncontrado = serviceProdudo.buscarId(id);
		if(produtoEncontrado==null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		serviceProdudo.excluir(produtoEncontrado);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping(value="/produtos", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Produto> alterarProduto(@RequestBody Produto produto){
		Produto produtoAlterado = serviceProdudo.alterar(produto);
		return new ResponseEntity<>(produtoAlterado, HttpStatus.CREATED);
	}

}
