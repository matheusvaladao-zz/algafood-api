package com.algaworks.algafood.infraestructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.Permissao;
import com.algaworks.algafood.domain.repository.PermissaoRepository;

@Component
public class PermissaoRepositoryImpl implements PermissaoRepository {

	@PersistenceContext
	EntityManager manager;

	@Override
	public List<Permissao> todos() {
		return manager.createQuery("from Permissao", Permissao.class).getResultList();
	}

	@Override
	public Permissao porId(Long id) {
		return manager.find(Permissao.class, id);
	}

	@Override
	@Transactional
	public Permissao salvar(Permissao permissao) {
		return manager.merge(permissao);
	}

	@Override
	@Transactional
	public void remover(Permissao permissao) {
		permissao = porId(permissao.getId());
		manager.remove(permissao);
	}

}
