package br.com.edward.restfull.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.edward.restfull.model.SalaModel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter

@Entity
@Table(name = "sala")
public class Sala {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name = "nome", length = 10)
	private String nome;
	
	@NotNull
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_sala_id")
	private TipoSala tipo;
	
	@NotNull
	@Column(name = "capacidade")
	private Integer capacidade;
	
	public Sala(SalaModel model, TipoSala tipoSala) {
		
		this.nome = model.getNome();
		this.tipo = tipoSala;
		this.capacidade = model.getCapacidade();
	}
}
