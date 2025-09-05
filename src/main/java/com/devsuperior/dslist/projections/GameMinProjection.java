/**
 * Interface de projeção para retornar um subconjunto mínimo de informações de um jogo.
 * Esta interface é utilizada em consultas SQL nativas para otimizar a recuperação de dados,
 * retornando apenas os campos necessários para a exibição resumida de jogos.
 * Permite mapear diretamente os resultados de uma consulta para um objeto com estas propriedades.
 *
 * @author lacerdagb (mantido como autor original, conforme instrução)
 * @version 1.0.0
 */
package com.devsuperior.dslist.projections;

public interface GameMinProjection {

	/**
	 * Retorna o ID do jogo.
	 * @return O ID do jogo.
	 */
	Long getId();

	/**
	 * Retorna o título do jogo.
	 * @return O título do jogo.
	 */
	String getTitle();

	/**
	 * Retorna o ano de lançamento do jogo.
	 * O nome do método é `getGameYear` para evitar conflito com a palavra reservada `year`.
	 * @return O ano de lançamento do jogo.
	 */
	Integer getGameYear();

	/**
	 * Retorna a URL da imagem de capa do jogo.
	 * @return A URL da imagem de capa do jogo.
	 */
	String getImgUrl();

	/**
	 * Retorna a descrição curta do jogo.
	 * @return A descrição curta do jogo.
	 */
	String getShortDescription();

	/**
	 * Retorna a posição do jogo dentro de uma lista.
	 * @return A posição do jogo.
	 */
	Integer getPosition();
}


