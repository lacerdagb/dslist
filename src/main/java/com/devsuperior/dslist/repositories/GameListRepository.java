/**
 * Repositório para operações de acesso a dados relacionadas a {@link GameList}.
 * Esta interface estende {@link JpaRepository}, fornecendo métodos CRUD básicos
 * e funcionalidades de paginação e ordenação para a entidade GameList.
 * Além disso, define uma consulta nativa para atualizar a posição de um jogo em uma lista.
 *
 * @author lacerdagb (mantido como autor original, conforme instrução)
 * @version 1.0.0
 */
package com.devsuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {

	/**
	 * Atualiza a posição de um jogo específico dentro de uma lista de jogos no banco de dados.
	 * Esta é uma consulta SQL nativa que modifica diretamente a tabela de relacionamento `tb_belonging`.
	 * É marcada com `@Modifying` para indicar que a consulta modifica o estado do banco de dados.
	 *
	 * @param listId O ID da lista de jogos onde a posição do jogo será atualizada.
	 * @param gameId O ID do jogo cuja posição será atualizada.
	 * @param newPosition A nova posição (índice) para o jogo dentro da lista.
	 */
	@Modifying // Indica que esta consulta SQL modificará os dados no banco de dados.
	@Query(nativeQuery = true, // Especifica que a consulta é SQL nativa, não JPQL.
		value = "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
	void updateBelongingPosition(Long listId, Long gameId, Integer newPosition);
}


