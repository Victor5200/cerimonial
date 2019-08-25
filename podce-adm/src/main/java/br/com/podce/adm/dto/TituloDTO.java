package br.com.podce.adm.dto;

import br.com.podce.adm.jpa.model.Titulo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TituloDTO {

    private Long id;
    private String descricao;

    public TituloDTO(Titulo titulo){
        this.id = titulo.getId();
        this.descricao = titulo.getDescricao();
    }
}
