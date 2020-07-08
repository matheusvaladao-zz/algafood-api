package com.algaworks.algafood.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.model.Pedido;

@Service
public class FluxoPedidoService {

	@Autowired
	EmissaoPedidoService emissaoPedidoService;
	
	@Transactional
	public void confirmar(String codigoPedido) {
		Pedido pedido = emissaoPedidoService.buscarOuFalhar(codigoPedido);
		pedido.confirmar();
	}
	
	@Transactional
	public void entregar(String codigoPedido) {
	    Pedido pedido = emissaoPedidoService.buscarOuFalhar(codigoPedido);
	    pedido.entregar();
	}
	
	@Transactional
	public void cancelar(String codigoPedido) {
	    Pedido pedido = emissaoPedidoService.buscarOuFalhar(codigoPedido);   
	    pedido.cancelar();
	}
	
}
