package com.algaworks.algafood.infraestructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;

@Component
public class FormaPagamentoRepositoryImpl implements FormaPagamentoRepository {

	@PersistenceContext
	EntityManager manager;

	@Override
	public List<FormaPagamento> todos() {
		return manager.createQuery("from FormaPagamento", FormaPagamento.class).getResultList();
	}

	@Override
	public FormaPagamento porId(Long id) {
		return manager.find(FormaPagamento.class, id);
	}

	@Override
	@Transactional
	public FormaPagamento salvar(FormaPagamento formaPagamento) {
		return manager.merge(formaPagamento);
	}

	@Override
	@Transactional
	public void remover(FormaPagamento formaPagamento) {
		formaPagamento = porId(formaPagamento.getId());
		manager.remove(formaPagamento);
	}

}
