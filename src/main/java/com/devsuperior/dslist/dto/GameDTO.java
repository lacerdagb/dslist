/**
 * Objeto de Transferência de Dados (DTO) para representar um jogo com todos os seus detalhes.
 * Esta classe é utilizada para expor informações completas de um jogo através da API,
 * garantindo que apenas os dados relevantes sejam transferidos entre as camadas da aplicação
 * e para o cliente.
 *
 * @author lacerdagb (mantido como autor original, conforme instrução)
 * @version 1.0.0
 */
package com.devsuperior.dslist.dto;

import org.springframework.beans.BeanUtils;

import com.devsuperior.dslist.entities.Game;

public class GameDTO {

	private Long id; // Identificador único do jogo.
	private String title; // Título do jogo.
	private Integer year; // Ano de lançamento do jogo.
	private String genre; // Gênero do jogo.
	private String platforms; // Plataformas em que o jogo está disponível.
	private Double score; // Pontuação do jogo.
	private String imgUrl; // URL da imagem de capa do jogo.
	private String shortDescription; // Descrição curta do jogo.
	private String longDescription; // Descrição longa e detalhada do jogo.
	
	/**
	 * Construtor padrão vazio.
	 * Necessário para a serialização e desserialização de objetos DTO.
	 */
	public GameDTO() {
	}
	
	/**
	 * Construtor que inicializa um GameDTO a partir de uma entidade Game.
	 * Utiliza BeanUtils para copiar as propriedades da entidade para o DTO,
	 * facilitando a conversão de objetos de domínio para objetos de transferência de dados.
	 *
	 * @param entity A entidade {@link Game} da qual as propriedades serão copiadas.
	 */
	public GameDTO(Game entity) {
		// Copia as propriedades da entidade Game para este DTO.
		BeanUtils.copyProperties(entity, this);
	}

	/**
	 * Retorna o ID do jogo.
	 * @return O ID do jogo.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Define o ID do jogo.
	 * @param id O novo ID do jogo.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Retorna o título do jogo.
	 * @return O título do jogo.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Define o título do jogo.
	 * @param title O novo título do jogo.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Retorna o ano de lançamento do jogo.
	 * @return O ano de lançamento do jogo.
	 */
	public Integer getYear() {
		return year;
	}

	/**
	 * Define o ano de lançamento do jogo.
	 * @param year O novo ano de lançamento do jogo.
	 */
	public void setYear(Integer year) {
		this.year = year;
	}

	/**
	 * Retorna o gênero do jogo.
	 * @return O gênero do jogo.
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * Define o gênero do jogo.
	 * @param genre O novo gênero do jogo.
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * Retorna as plataformas do jogo.
	 * @return As plataformas do jogo.
	 */
	public String getPlatforms() {
		return platforms;
	}

	/**
	 * Define as plataformas do jogo.
	 * @param platforms As novas plataformas do jogo.
	 */
	public void setPlatforms(String platforms) {
		this.platforms = platforms;
	}

	/**
	 * Retorna a pontuação do jogo.
	 * @return A pontuação do jogo.
	 */
	public Double getScore() {
		return score;
	}

	/**
	 * Define a pontuação do jogo.
	 * @param score A nova pontuação do jogo.
	 */
	public void setScore(Double score) {
		this.score = score;
	}

	/**
	 * Retorna a URL da imagem de capa do jogo.
	 * @return A URL da imagem de capa do jogo.
	 */
	public String getImgUrl() {
		return imgUrl;
	}

	/**
	 * Define a URL da imagem de capa do jogo.
	 * @param imgUrl A nova URL da imagem de capa do jogo.
	 */
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	/**
	 * Retorna a descrição curta do jogo.
	 * @return A descrição curta do jogo.
	 */
	public String getShortDescription() {
		return shortDescription;
	}

	/**
	 * Define a descrição curta do jogo.
	 * @param shortDescription A nova descrição curta do jogo.
	 */
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	/**
	 * Retorna a descrição longa do jogo.
	 * @return A descrição longa do jogo.
	 */
	public String getLongDescription() {
		return longDescription;
	}

	/**
	 * Define a descrição longa do jogo.
	 * @param longDescription A nova descrição longa do jogo.
	 */
	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}
}


