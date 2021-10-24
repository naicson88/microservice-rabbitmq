package com.naicson.estoquepreco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.EstoqueDTO;
import com.naicson.estoquepreco.service.RabbitMQService;

import constantes.RabbitMQConstantes;


@RestController
@RequestMapping(value = "estoque")
public class EstoqueController {
	
	@Autowired
	private RabbitMQService service;
	
	@PutMapping
	private ResponseEntity<EstoqueDTO> alteraEstoque(@RequestBody EstoqueDTO estoque){
		System.out.println(estoque.codigoProduto);
		
		service.enviaMensagem(RabbitMQConstantes.FILA_ESTOQUE, estoque);
		return new ResponseEntity<EstoqueDTO>(HttpStatus.OK);
	}
}
