/**
 * Serviço para operações de negócio relacionadas a listas de jogos.
 * Esta classe encapsula a lógica de negócio para gerenciar listas de jogos,
 * incluindo a busca de listas, a busca de jogos dentro de uma lista e a movimentação
 * de jogos entre posições em uma lista.
 *
 * @author lacerdagb (mantido como autor original, conforme instrução)
 * @version 1.0.0
 */
package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameListRepository;
import com.devsuperior.dslist.repositories.GameRepository;

@Service // Indica que esta classe é um componente de serviço do Spring, gerenciando a lógica de negócio.
public class GameListService {

	@Autowired // Realiza a injeção de dependência do GameListRepository para acesso aos dados das listas de jogos.
	private GameListRepository gameListRepository;
	
	@Autowired // Realiza a injeção de dependência do GameRepository para acesso aos dados dos jogos.
	private GameRepository gameRepository;
	
	/**
	 * Busca todas as listas de jogos disponíveis.
	 * A anotação `@Transactional(readOnly = true)` otimiza a transação para operações de leitura.
	 *
	 * @return Uma lista de objetos {@link GameListDTO} contendo todas as listas de jogos.
	 */
	@Transactional(readOnly = true) // Garante que a operação de leitura seja otimizada e executada dentro de uma transação.
	public List<GameListDTO> findAll() {
		// Busca todas as entidades GameList do repositório.
		List<GameList> result = gameListRepository.findAll();
		// Converte a lista de entidades para uma lista de DTOs usando Stream API.
		return result.stream().map(GameListDTO::new).toList();
	}
	
	/**
	 * Move um jogo dentro de uma lista de jogos, alterando sua posição.
	 * Esta operação é transacional para garantir a consistência dos dados.
	 *
	 * @param listId O ID da lista de jogos onde o jogo será movido.
	 * @param sourceIndex O índice de origem do jogo na lista.
	 * @param destinationIndex O índice de destino para o jogo na lista.
	 */
	@Transactional // Garante que todas as operações dentro deste método sejam executadas em uma única transação.
	public void move(Long listId, int sourceIndex, int destinationIndex) {

		// Busca a lista de jogos com informações mínimas, incluindo a posição atual.
		List<GameMinProjection> list = gameRepository.searchByList(listId);

		// Remove o jogo da posição de origem e o armazena temporariamente.
		GameMinProjection obj = list.remove(sourceIndex);
		// Adiciona o jogo na nova posição de destino.
		list.add(destinationIndex, obj);

		// Determina o menor e o maior índice afetado pela movimentação para otimizar as atualizações.
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

		// Itera sobre os jogos na faixa afetada e atualiza suas posições no banco de dados.
		for (int i = min; i <= max; i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
	}

	/**
	 * Busca uma lista de jogos específica pelo seu ID.
	 * A anotação `@Transactional(readOnly = true)` otimiza a transação para operações de leitura.
	 *
	 * @param id O ID único da lista de jogos a ser buscada.
	 * @return Um objeto {@link GameListDTO} contendo os detalhes da lista de jogos encontrada.
	 */
	@Transactional(readOnly = true) // Garante que a operação de leitura seja otimizada e executada dentro de uma transação.
	public GameListDTO findById(Long id) {
		// Busca a entidade GameList pelo ID. O .get() é usado pois findById retorna um Optional.
		GameList entity = gameListRepository.findById(id).get();
		// Converte a entidade encontrada para um DTO.
		return new GameListDTO(entity);
	}
}


