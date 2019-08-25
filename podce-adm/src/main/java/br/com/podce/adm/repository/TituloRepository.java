package br.com.podce.adm.repository;

import br.com.podce.adm.jpa.model.Titulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TituloRepository extends JpaRepository<Titulo, Long>  {

    List<Titulo> findByDescricao(String descricao);

}

