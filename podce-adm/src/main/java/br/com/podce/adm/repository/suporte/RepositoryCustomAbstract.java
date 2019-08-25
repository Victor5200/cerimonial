package br.com.podce.adm.repository.suporte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.persistence.EntityManager;
import java.util.List;

public class RepositoryCustomAbstract<T, ID> implements RepositoryCuston<T,ID>{

	@Autowired
	private EntityManager entityManager;
	
	private SimpleJpaRepositoryCuston<T, ID> simpleJpaRepositoryCuston;
	
	private Class<T> classeEntidade;
	
	public RepositoryCustomAbstract(Class<T> classeEntidade) {
		this.classeEntidade = classeEntidade;
	}

	public SimpleJpaRepositoryCuston<T, ID> getSimpleJpaRepositoryCuston() {
		if (simpleJpaRepositoryCuston == null) {
			simpleJpaRepositoryCuston = new SimpleJpaRepositoryCuston<T, ID>(this.classeEntidade, entityManager);
		}
		return simpleJpaRepositoryCuston;
	}

	public long countCustom(Example<T> example) {
		return  getSimpleJpaRepositoryCuston().count(example);
	}

	public boolean existsCustom(Example<T> example) {
		return getSimpleJpaRepositoryCuston().exists(example);
	}

	public List<T> findAllCustom(Example<T> example) {
		return getSimpleJpaRepositoryCuston().findAll(example);
	}

	public List<T> findAllCustom(Example<T> example, Sort sort) {
		return getSimpleJpaRepositoryCuston().findAll(example, sort);
	}

	@Override
	public Page<T> findAllCustom(Example<T> example, Pageable pageable) {
		return getSimpleJpaRepositoryCuston().findAll(example, pageable);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	
	
}
