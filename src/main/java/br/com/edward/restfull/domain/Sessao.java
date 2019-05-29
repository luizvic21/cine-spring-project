package br.com.edward.restfull.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.edward.restfull.model.SessaoModel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter

@Entity
@Table(name = "sessao")
public class Sessao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "filme_id")
	private Filme filme;
	
	@NotNull
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "sala_id")
	private Sala sala;
	
	@NotNull
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "audio_id")
	private Audio audio;
	
	@OneToMany(mappedBy = "sessao", targetEntity = Lugares.class, cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private List<Lugares> lugares;
	
	public Sessao(SessaoModel model, Filme filme, Sala sala, Audio audio) {
		this.filme = filme;
		this.sala = sala;
		this.audio = audio;
		this.lugares = new ArrayList<>();
	}
	
	public Boolean addLugar(Integer numero) {
		
		Lugares lugar = this.lugares.stream().filter(x -> x.getNumero() == numero).findFirst().orElse(null);
		
		if (Objects.isNull(lugar)) {
			Lugares reservaLugar = new Lugares(, sessao)
		}
		
	}
}
