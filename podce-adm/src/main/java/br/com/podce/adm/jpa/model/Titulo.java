package br.com.podce.adm.jpa.model;


import br.com.podce.adm.dto.TituloDTO;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode
public class Titulo {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "sq_titulo_id", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sq_titulo_id", sequenceName = "sq_titulo_id", allocationSize = 1)
    private Long id;

    @Column( name = "DESCRICAO")
    private String descricao;

    public Titulo(TituloDTO tituloDTO){
        this.id = tituloDTO.getId();
        this.descricao = tituloDTO.getDescricao();
    }
}
