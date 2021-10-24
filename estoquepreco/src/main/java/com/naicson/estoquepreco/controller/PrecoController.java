package com.naicson.estoquepreco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.PrecoDTO;
import com.naicson.estoquepreco.service.RabbitMQService;
import constantes.RabbitMQConstantes;


@RestController
@RequestMapping(value = "preco")
public class PrecoController {
	
	@Autowired
	private RabbitMQService service;
	
	@PutMapping
	private ResponseEntity<PrecoDTO> alteraPreco(@RequestBody PrecoDTO preco){
		System.out.println(preco.codigoProduto);
		
		service.enviaMensagem(RabbitMQConstantes.FILA_PRECO, preco);
		return new ResponseEntity<PrecoDTO>(HttpStatus.OK);
	}
}
