package com.naicson.estoquepreco.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RabbitMQService {
	
	@Autowired
	private RabbitTemplate template;
	
	//Envia a mensagem para o RabbitMQ
	public void enviaMensagem(String nomeFila, Object mensagem) {
		this.template.convertAndSend(nomeFila, mensagem);
	}
}
