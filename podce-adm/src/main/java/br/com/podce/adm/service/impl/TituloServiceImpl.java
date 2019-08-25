package br.com.podce.adm.service.impl;

import br.com.podce.adm.dto.TituloDTO;
import br.com.podce.adm.jpa.model.Titulo;
import br.com.podce.adm.repository.TituloRepository;
import br.com.podce.adm.service.TituloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TituloServiceImpl implements TituloService {

    @Autowired
    private TituloRepository tituloRepository;

    @Override
    public List<TituloDTO> buscarTodos() {
        List<Titulo> listaRetorno = tituloRepository.findAll();
        return listaRetorno.stream().map(entity -> new TituloDTO(entity)).collect(Collectors.toList());
    }

    @Override
    public List<TituloDTO> buscarPorDescricao(String descricao) {
        List<Titulo> listaRetorno = this.tituloRepository.findByDescricao(descricao);
        return listaRetorno.stream().map(entity -> new TituloDTO(entity)).collect(Collectors.toList());
    }

    @Override
    public void deletarTitulo(TituloDTO tituloDTO){
        tituloRepository.delete(new Titulo(tituloDTO));
    }

    @Override
    public TituloDTO salvar(TituloDTO tituloDTO) {
        return new TituloDTO(this.tituloRepository.save(new Titulo(tituloDTO)));
    }

    @Override
    public TituloDTO buscarPorId(Long id) {
        Optional<Titulo> titulo = this.tituloRepository.findById(id);
        return new TituloDTO(titulo.get());
    }
}
