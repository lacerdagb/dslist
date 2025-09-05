/**
 * Controlador REST para operações relacionadas a jogos.
 * Esta classe expõe endpoints HTTP para que os clientes possam interagir
 * com os dados dos jogos, como buscar todos os jogos ou um jogo específico por ID.
 *
 * @author lacerdagb (mantido como autor original, conforme instrução)
 * @version 1.0.0
 */
package com.devsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.services.GameService;

@RestController // Indica que esta classe é um controlador REST, capaz de lidar com requisições HTTP.
@RequestMapping(value = "/games") // Mapeia todas as requisições que começam com "/games" para este controlador.
public class GameController {

	@Autowired // Realiza a injeção de dependência do GameService, permitindo que o controlador utilize os serviços de negócio.
	private GameService gameService;	

	/**
	 * Busca um jogo específico pelo seu ID.
	 * Este endpoint responde a requisições GET para `/games/{id}`.
	 *
	 * @param id O ID único do jogo a ser buscado.
	 * @return Um objeto {@link GameDTO} contendo os detalhes completos do jogo encontrado.
	 */
	@GetMapping(value = "/{id}") // Mapeia requisições GET para `/games/{id}`, onde `{id}` é uma variável de caminho.
	public GameDTO findById(@PathVariable Long id) {
		// Chama o serviço para buscar o jogo pelo ID e mapeia o resultado para um DTO.
		GameDTO result = gameService.findById(id);
		return result;
	}

	/**
	 * Busca todos os jogos com informações mínimas.
	 * Este endpoint responde a requisições GET para `/games`.
	 *
	 * @return Uma lista de objetos {@link GameMinDTO} contendo informações resumidas de todos os jogos.
	 */
	@GetMapping // Mapeia requisições GET para `/games`.
	public List<GameMinDTO> findAll() {
		// Chama o serviço para buscar todos os jogos e mapeia a lista para DTOs mínimos.
		List<GameMinDTO> result = gameService.findAll();
		return result;
	}
}


