package br.com.podce.adm.repository.suporte;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface RepositoryCuston<T, ID> {

	long countCustom(Example<T> example);

	boolean existsCustom(Example<T> example);

	List<T> findAllCustom(Example<T> example);

	List<T> findAllCustom(Example<T> example, Sort sort);

	Page<T> findAllCustom(Example<T> example, Pageable pageable);


}
