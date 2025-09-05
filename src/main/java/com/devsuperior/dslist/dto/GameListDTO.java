/**
 * Objeto de Transferência de Dados (DTO) para representar uma lista de jogos.
 * Esta classe é utilizada para expor informações resumidas de uma lista de jogos através da API,
 * focando nos dados essenciais como ID e nome da lista.
 *
 * @author lacerdagb (mantido como autor original, conforme instrução)
 * @version 1.0.0
 */
package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.GameList;

public class GameListDTO {

	private Long id; // Identificador único da lista de jogos.
	private String name; // Nome da lista de jogos.
	
	/**
	 * Construtor padrão vazio.
	 * Necessário para a serialização e desserialização de objetos DTO.
	 */
	public GameListDTO() {
	}
	
	/**
	 * Construtor que inicializa um GameListDTO a partir de uma entidade GameList.
	 * Copia as propriedades essenciais da entidade para o DTO.
	 *
	 * @param entity A entidade {@link GameList} da qual as propriedades serão copiadas.
	 */
	public GameListDTO(GameList entity) {
		id = entity.getId(); // Copia o ID da entidade para o DTO.
		name = entity.getName(); // Copia o nome da entidade para o DTO.
	}

	/**
	 * Retorna o ID da lista de jogos.
	 * @return O ID da lista de jogos.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Retorna o nome da lista de jogos.
	 * @return O nome da lista de jogos.
	 */
	public String getName() {
		return name;
	}
}


