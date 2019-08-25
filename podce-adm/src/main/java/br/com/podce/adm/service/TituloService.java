package br.com.podce.adm.service;

import br.com.podce.adm.dto.TituloDTO;

import java.util.List;

public interface TituloService {

    List<TituloDTO> buscarTodos();

    List<TituloDTO> buscarPorDescricao(String descricao);

    void deletarTitulo(TituloDTO tituloDTO);

    TituloDTO salvar(TituloDTO tituloDTO);

    TituloDTO buscarPorId(Long id);
}
