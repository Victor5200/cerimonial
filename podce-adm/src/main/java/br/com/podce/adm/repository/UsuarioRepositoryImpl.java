package br.com.podce.adm.repository;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class UsuarioRepositoryImpl  implements UsuarioRepositoryCustom {

    @Autowired
    EntityManager entityManager;
   

}
