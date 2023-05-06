package com.desafio.infracoes.models.infracao;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "records")
public class Infracao implements Serializable {

	private static final long serialVerionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime datahora;

	@Column(nullable = false)
	private Integer velocidade;

	private String placa;

	@Enumerated(EnumType.STRING)
	private TipoVeiculo veiculo;

	public enum TipoVeiculo {
		CARRO,
		MOTOCICLETA,
		CAMINHAO,
		ONIBUS
	}
}
