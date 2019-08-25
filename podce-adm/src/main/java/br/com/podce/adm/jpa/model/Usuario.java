package br.com.podce.adm.jpa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Victor Alexsander
 *
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = -4104168036322050909L;

	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "sq_id", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "sq_id", sequenceName = "sq_id", allocationSize = 1)
	private Integer id;

	public Usuario() {}

	public Usuario(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Usuario that = (Usuario) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
