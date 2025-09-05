/**
 * Representa a entidade de um jogo no sistema.
 * Esta classe mapeia a tabela 'tb_game' no banco de dados e contém todos os atributos
 * que descrevem um jogo, como título, ano de lançamento, gênero, plataformas, etc.
 * É a representação de domínio de um jogo na aplicação.
 *
 * @author lacerdagb (mantido como autor original, conforme instrução)
 * @version 1.0.0
 */
package com.devsuperior.dslist.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Marca esta classe como uma entidade JPA, indicando que ela corresponde a uma tabela no banco de dados.
@Table(name = "tb_game") // Especifica o nome da tabela no banco de dados para esta entidade.
public class Game {

	@Id // Indica que este campo é a chave primária da entidade.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Configura a geração automática de valores para a chave primária, usando a estratégia de identidade do banco de dados.
	private Long id; // Identificador único do jogo.
	private String title; // Título do jogo.
	
	@Column(name = "game_year") // Mapeia o campo 'year' para a coluna 'game_year' no banco de dados, pois 'year' é uma palavra reservada em alguns bancos.
	private Integer year; // Ano de lançamento do jogo.
	private String genre; // Gênero do jogo.
	private String platforms; // Plataformas em que o jogo está disponível.
	private Double score; // Pontuação do jogo.
	private String imgUrl; // URL da imagem de capa do jogo.
	
	@Column(columnDefinition = "TEXT") // Define o tipo da coluna no banco de dados como TEXT, permitindo textos longos.
	private String shortDescription; // Descrição curta do jogo.

	@Column(columnDefinition = "TEXT") // Define o tipo da coluna no banco de dados como TEXT, permitindo textos longos.
	private String longDescription; // Descrição longa e detalhada do jogo.
	
    /**
     * Construtor padrão vazio.
     * Necessário para a JPA e para a criação de instâncias sem argumentos.
     */
    public Game() {
    }
    
    /**
     * Construtor que inicializa todos os atributos de um jogo.
     *
     * @param id O identificador único do jogo.
     * @param title O título do jogo.
     * @param year O ano de lançamento do jogo.
     * @param genre O gênero do jogo.
     * @param platforms As plataformas em que o jogo está disponível.
     * @param score A pontuação do jogo.
     * @param imgUrl A URL da imagem de capa do jogo.
     * @param shortDescription A descrição curta do jogo.
     * @param longDescription A descrição longa e detalhada do jogo.
     */
	public Game(Long id, String title, Integer year, String genre, String platforms, Double score, String imgUrl,
			String shortDescription, String longDescription) {
		this.id = id;
		this.title = title;
		this.year = year;
		this.genre = genre;
		this.platforms = platforms;
		this.score = score;
		this.imgUrl = imgUrl;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;		
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

	/**
	 * Gera um código hash para o objeto Game.
	 * Baseia-se no código hash do campo 'id' para garantir a unicidade.
	 *
	 * @return O código hash do objeto.
	 */
	@Override
	public int hashCode() {
		// Garante que objetos Game com o mesmo ID tenham o mesmo hashCode, fundamental para coleções.
		return Objects.hash(id);
	}

	/**
	 * Compara este objeto Game com outro objeto para verificar igualdade.
	 * A igualdade é determinada pela comparação do campo 'id'.
	 *
	 * @param obj O objeto a ser comparado.
	 * @return true se os objetos são iguais, false caso contrário.
	 */
	@Override
	public boolean equals(Object obj) {
		// Verifica se é a mesma instância do objeto.
		if (this == obj)
			return true;
		// Verifica se o objeto comparado é nulo.
		if (obj == null)
			return false;
		// Verifica se as classes dos objetos são diferentes.
		if (getClass() != obj.getClass())
			return false;
		// Realiza o cast para Game e compara os IDs.
		Game other = (Game) obj;
		return Objects.equals(id, other.id);
	}
}


