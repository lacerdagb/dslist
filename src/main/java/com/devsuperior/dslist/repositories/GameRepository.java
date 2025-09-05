/**
 * Repositório para operações de acesso a dados relacionadas a {@link Game}.
 * Esta interface estende {@link JpaRepository}, fornecendo métodos CRUD básicos
 * e funcionalidades de paginação e ordenação para a entidade Game.
 * Além disso, define uma consulta nativa para buscar jogos por lista, retornando uma projeção mínima.
 *
 * @author lacerdagb (mantido como autor original, conforme instrução)
 * @version 1.0.0
 */
package com.devsuperior.dslist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;

public interface GameRepository extends JpaRepository<Game, Long> {

	/**
	 * Busca uma lista de jogos com informações mínimas, filtrando por uma lista de jogos específica.
	 * Esta consulta utiliza SQL nativo para unir as tabelas `tb_game` e `tb_belonging`
	 * e ordenar os resultados pela posição do jogo na lista.
	 * Os resultados são mapeados para a interface {@link GameMinProjection}.
	 *
	 * @param listId O ID da lista de jogos pela qual os jogos serão filtrados.
	 * @return Uma lista de objetos {@link GameMinProjection} contendo os jogos da lista especificada,
	 *         com informações mínimas e ordenados pela posição.
	 */
	@Query(nativeQuery = true, value = """ 
			SELECT tb_game.id, tb_game.title, tb_game.game_year AS gameYear, tb_game.img_url AS imgUrl,
			tb_game.short_description AS shortDescription, tb_belonging.position
			FROM tb_game
			INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
			WHERE tb_belonging.list_id = :listId
			ORDER BY tb_belonging.position
				""")
	List<GameMinProjection> searchByList(Long listId);
}


