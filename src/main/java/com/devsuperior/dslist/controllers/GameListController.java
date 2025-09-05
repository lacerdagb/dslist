/**
 * Controlador REST para operações relacionadas a listas de jogos.
 * Esta classe gerencia as requisições HTTP para manipulação e consulta de listas de jogos,
 * incluindo a busca de listas, jogos dentro de uma lista e a movimentação de jogos entre posições.
 *
 * @author lacerdagb (mantido como autor original, conforme instrução)
 * @version 1.0.0
 */
package com.devsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.dto.ReplacementDTO;
import com.devsuperior.dslist.services.GameListService;
import com.devsuperior.dslist.services.GameService;

@RestController // Indica que esta classe é um controlador REST, capaz de lidar com requisições HTTP.
@RequestMapping(value = "/lists") // Mapeia todas as requisições que começam com "/lists" para este controlador.
public class GameListController {

	@Autowired // Realiza a injeção de dependência do GameListService.
	private GameListService gameListService;
	
	@Autowired // Realiza a injeção de dependência do GameService.
	private GameService gameService;

	/**
	 * Busca uma lista de jogos específica pelo seu ID.
	 * Este endpoint responde a requisições GET para `/lists/{id}`.
	 *
	 * @param id O ID único da lista de jogos a ser buscada.
	 * @return Um objeto {@link GameListDTO} contendo os detalhes da lista de jogos encontrada.
	 */
	@GetMapping(value = "/{id}") // Mapeia requisições GET para `/lists/{id}`.
	public GameListDTO findById(@PathVariable Long id) {
		// Chama o serviço para buscar a lista de jogos pelo ID e mapeia o resultado para um DTO.
		GameListDTO result = gameListService.findById(id);
		return result;
	}
	
	/**
	 * Busca todas as listas de jogos disponíveis.
	 * Este endpoint responde a requisições GET para `/lists`.
	 *
	 * @return Uma lista de objetos {@link GameListDTO} contendo todas as listas de jogos.
	 */
	@GetMapping // Mapeia requisições GET para `/lists`.
	public List<GameListDTO> findAll() {
		// Chama o serviço para buscar todas as listas de jogos.
		List<GameListDTO> result = gameListService.findAll();
		return result;
	}

	/**
	 * Busca todos os jogos pertencentes a uma lista específica.
	 * Este endpoint responde a requisições GET para `/lists/{listId}/games`.
	 *
	 * @param listId O ID da lista de jogos da qual os jogos serão buscados.
	 * @return Uma lista de objetos {@link GameMinDTO} contendo os jogos da lista especificada.
	 */
	@GetMapping(value = "/{listId}/games") // Mapeia requisições GET para `/lists/{listId}/games`.
	public List<GameMinDTO> findGames(@PathVariable Long listId) {
		// Chama o serviço para buscar os jogos de uma lista específica.
		List<GameMinDTO> result = gameService.findByGameList(listId);
		return result;
	}
	
	/**
	 * Move um jogo dentro de uma lista de jogos, alterando sua posição.
	 * Este endpoint responde a requisições POST para `/lists/{listId}/replacement`.
	 * O corpo da requisição deve conter o índice de origem e o índice de destino do jogo.
	 *
	 * @param listId O ID da lista de jogos onde o jogo será movido.
	 * @param body Um objeto {@link ReplacementDTO} contendo o índice de origem (sourceIndex)
	 *             e o índice de destino (destinationIndex) para a movimentação do jogo.
	 */
	@PostMapping(value = "/{listId}/replacement") // Mapeia requisições POST para `/lists/{listId}/replacement`.
	public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
		// Chama o serviço para realizar a movimentação do jogo na lista.
		gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
	}
}


