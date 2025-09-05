/**
 * Objeto de Transferência de Dados (DTO) para representar um jogo com informações mínimas.
 * Esta classe é utilizada para expor um subconjunto de informações de um jogo através da API,
 * otimizando a transferência de dados quando apenas detalhes essenciais são necessários,
 * como em listagens de jogos.
 *
 * @author lacerdagb (mantido como autor original, conforme instrução)
 * @version 1.0.0
 */
package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;

public class GameMinDTO {

	private Long id; // Identificador único do jogo.
	private String title; // Título do jogo.
	private Integer year; // Ano de lançamento do jogo.
	private String imgUrl; // URL da imagem de capa do jogo.
	private String shortDescription; // Descrição curta do jogo.
	
	/**
	 * Construtor padrão vazio.
	 * Necessário para a serialização e desserialização de objetos DTO.
	 */
	public GameMinDTO() {
	}
	
	/**
	 * Construtor que inicializa um GameMinDTO a partir de uma entidade Game.
	 * Copia as propriedades mínimas da entidade para o DTO.
	 *
	 * @param entity A entidade {@link Game} da qual as propriedades serão copiadas.
	 */
	public GameMinDTO(Game entity) {
		id = entity.getId();
		title = entity.getTitle();
		year = entity.getYear();
		imgUrl = entity.getImgUrl();
		shortDescription = entity.getShortDescription();
	}

	/**
	 * Construtor que inicializa um GameMinDTO a partir de uma projeção GameMinProjection.
	 * Utilizado para mapear resultados de consultas SQL nativas que retornam um subconjunto de colunas.
	 *
	 * @param projection A projeção {@link GameMinProjection} da qual as propriedades serão copiadas.
	 */
	public GameMinDTO(GameMinProjection projection) {
		id = projection.getId();
		title = projection.getTitle();
		year = projection.getGameYear(); // Mapeia o ano do jogo da projeção.
		imgUrl = projection.getImgUrl();
		shortDescription = projection.getShortDescription();
	}

	/**
	 * Retorna o ID do jogo.
	 * @return O ID do jogo.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Retorna o título do jogo.
	 * @return O título do jogo.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Retorna o ano de lançamento do jogo.
	 * @return O ano de lançamento do jogo.
	 */
	public Integer getYear() {
		return year;
	}

	/**
	 * Retorna a URL da imagem de capa do jogo.
	 * @return A URL da imagem de capa do jogo.
	 */
	public String getImgUrl() {
		return imgUrl;
	}

	/**
	 * Retorna a descrição curta do jogo.
	 * @return A descrição curta do jogo.
	 */	public String getShortDescription() {
		return shortDescription;
	}
}


