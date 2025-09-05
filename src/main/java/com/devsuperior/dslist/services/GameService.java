/**
 * Serviço para operações de negócio relacionadas a jogos.
 * Esta classe encapsula a lógica de negócio para gerenciar jogos,
 * incluindo a busca de jogos por ID, a busca de todos os jogos e a busca
 * de jogos associados a uma lista específica.
 *
 * @author lacerdagb (mantido como autor original, conforme instrução)
 * @version 1.0.0
 */
package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameRepository;

@Service // Indica que esta classe é um componente de serviço do Spring, gerenciando a lógica de negócio.
public class GameService {

	@Autowired // Realiza a injeção de dependência do GameRepository para acesso aos dados dos jogos.
	private GameRepository gameRepository;
	
	/**
	 * Busca um jogo específico pelo seu ID.
	 * A anotação `@Transactional(readOnly = true)` otimiza a transação para operações de leitura.
	 *
	 * @param id O ID único do jogo a ser buscado.
	 * @return Um objeto {@link GameDTO} contendo os detalhes completos do jogo encontrado.
	 */
	@Transactional(readOnly = true) // Garante que a operação de leitura seja otimizada e executada dentro de uma transação.
	public GameDTO findById(@PathVariable Long id) {
		// Busca a entidade Game pelo ID. O .get() é usado pois findById retorna um Optional.
		Game result = gameRepository.findById(id).get();
		// Converte a entidade encontrada para um DTO.
		return new GameDTO(result);
	}
	
	/**
	 * Busca todos os jogos com informações mínimas.
	 * A anotação `@Transactional(readOnly = true)` otimiza a transação para operações de leitura.
	 *
	 * @return Uma lista de objetos {@link GameMinDTO} contendo informações resumidas de todos os jogos.
	 */
	@Transactional(readOnly = true) // Garante que a operação de leitura seja otimizada e executada dentro de uma transação.
	public List<GameMinDTO> findAll() {
		// Busca todas as entidades Game do repositório.
		List<Game> result = gameRepository.findAll();
		// Converte a lista de entidades para uma lista de DTOs mínimos usando Stream API.
		return result.stream().map(GameMinDTO::new).toList();
	}
	
	/**
	 * Busca todos os jogos pertencentes a uma lista de jogos específica.
	 * A anotação `@Transactional(readOnly = true)` otimiza a transação para operações de leitura.
	 *
	 * @param listId O ID da lista de jogos da qual os jogos serão buscados.
	 * @return Uma lista de objetos {@link GameMinDTO} contendo os jogos da lista especificada.
	 */
	@Transactional(readOnly = true) // Garante que a operação de leitura seja otimizada e executada dentro de uma transação.
	public List<GameMinDTO> findByGameList(Long listId) {
		// Busca os jogos da lista especificada usando uma projeção mínima.
		List<GameMinProjection> games = gameRepository.searchByList(listId);
		// Converte a lista de projeções para uma lista de DTOs mínimos usando Stream API.
		return games.stream().map(GameMinDTO::new).toList();
	}
}


