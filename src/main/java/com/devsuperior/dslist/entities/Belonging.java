/**
 * Representa a relação de pertencimento de um jogo a uma lista de jogos.
 * Esta entidade é utilizada para modelar a associação muitos-para-muitos entre
 * {@link Game} e {@link GameList}, incluindo a posição do jogo dentro da lista.
 * Utiliza uma chave primária composta definida em {@link BelongingPK}.
 *
 * @author lacerdagb (mantido como autor original, conforme instrução)
 * @version 1.0.0
 */
package com.devsuperior.dslist.entities;

import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity // Marca esta classe como uma entidade JPA, mapeando-a para uma tabela no banco de dados.
@Table(name = "tb_belonging") // Especifica o nome da tabela no banco de dados para esta entidade.
public class Belonging {

	@EmbeddedId // Indica que o ID desta entidade é uma chave primária composta, embutida de outra classe.
	private BelongingPK id = new BelongingPK(); // Chave primária composta que associa um jogo a uma lista.

	private Integer position; // A posição do jogo dentro da lista, permitindo ordenação.

	/**
	 * Define o jogo associado a este pertencimento.
	 * Este método delega a definição do jogo para a chave primária composta.
	 *
	 * @param game O objeto {@link Game} a ser associado.
	 */
	public void setGame(Game game) {
		id.setGame(game);
	}

	/**
	 * Retorna o jogo associado a este pertencimento.
	 * Este método delega a obtenção do jogo para a chave primária composta.
	 *
	 * @return O objeto {@link Game} associado.
	 */
	public Game getGame() {
		return id.getGame();
	}

	/**
	 * Define a lista de jogos associada a este pertencimento.
	 * Este método delega a definição da lista para a chave primária composta.
	 *
	 * @param list O objeto {@link GameList} a ser associado.
	 */
	public void setList(GameList list) {
		id.setList(list);
	}

	/**
	 * Retorna a lista de jogos associada a este pertencimento.
	 * Este método delega a obtenção da lista para a chave primária composta.
	 *
	 * @return O objeto {@link GameList} associado.
	 */
	public GameList getList() {
		return id.getList();
	}

	/**
	 * Retorna a posição do jogo dentro da lista.
	 * @return A posição do jogo.
	 */
	public Integer getPosition() {
		return position;
	}

	/**
	 * Define a posição do jogo dentro da lista.
	 * @param position A nova posição do jogo.
	 */
	public void setPosition(Integer position) {
		this.position = position;
	}

	/**
	 * Gera um código hash para o objeto Belonging.
	 * Baseia-se no código hash do campo 'id' para garantir a unicidade.
	 *
	 * @return O código hash do objeto.
	 */
	@Override
	public int hashCode() {
		// Garante que objetos Belonging com o mesmo ID tenham o mesmo hashCode, fundamental para coleções.
		return Objects.hash(id);
	}

	/**
	 * Compara este objeto Belonging com outro objeto para verificar igualdade.
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
		// Realiza o cast para Belonging e compara os IDs.
		Belonging other = (Belonging) obj;
		return Objects.equals(id, other.id);
	}
}


