package br.com.cadproduto.ws.service;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadproduto.ws.model.Produto;
import br.com.cadproduto.ws.repository.ClienteRepository;

@Service
public class ProdudoService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	// Métodos
	public Produto cadastrar(Produto produto){
		
		return clienteRepository.save(produto);
	}
	
	public Collection<Produto> buscarTodos(){
		return clienteRepository.findAll();
	}
	
	public void excluir(Produto produto){
		clienteRepository.delete(produto);
	}
	
	public Produto buscarId(Integer id) {
		return clienteRepository.findOne(id);
	}
	
	public Produto alterar(Produto produto){
		
		return clienteRepository.save(produto);
	}
	
}
