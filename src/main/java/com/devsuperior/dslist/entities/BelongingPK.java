/**
 * Classe que representa a chave primária composta para a entidade {@link Belonging}.
 * Esta classe é utilizada para mapear a relação muitos-para-muitos entre {@link Game} e {@link GameList},
 * permitindo que um jogo pertença a múltiplas listas e uma lista contenha múltiplos jogos.
 * É uma classe embutível (Embeddable) que será parte da chave primária da entidade Belonging.
 *
 * @author lacerdagb (mantido como autor original, conforme instrução)
 * @version 1.0.0
 */
package com.devsuperior.dslist.entities;

import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable // Indica que esta classe pode ser embutida como parte de uma chave primária ou como um atributo de valor.
public class BelongingPK {

	@ManyToOne // Define uma relação muitos-para-um com a entidade Game.
    @JoinColumn(name = "game_id") // Especifica a coluna de junção na tabela do banco de dados.
    private Game game; // O jogo que faz parte desta chave composta.

    @ManyToOne // Define uma relação muitos-para-um com a entidade GameList.
    @JoinColumn(name = "list_id") // Especifica a coluna de junção na tabela do banco de dados.
    private GameList list; // A lista de jogos que faz parte desta chave composta.

    /**
     * Construtor padrão vazio.
     * Necessário para a JPA e para a criação de instâncias sem argumentos.
     */
    public BelongingPK() {
    }

    /**
     * Construtor que inicializa a chave primária composta com um jogo e uma lista.
     *
     * @param game O objeto {@link Game} a ser associado a esta chave.
     * @param list O objeto {@link GameList} a ser associado a esta chave.
     */
    public BelongingPK(Game game, GameList list) {
        this.game = game;
        this.list = list;
    }

	/**
	 * Retorna o objeto Game associado a esta chave primária composta.
	 * @return O objeto {@link Game}.
	 */
	public Game getGame() {
		return game;
	}

	/**
	 * Define o objeto Game para esta chave primária composta.
	 * @param game O objeto {@link Game} a ser definido.
	 */
	public void setGame(Game game) {
		this.game = game;
	}

	/**
	 * Retorna o objeto GameList associado a esta chave primária composta.
	 * @return O objeto {@link GameList}.
	 */
	public GameList getList() {
		return list;
	}

	/**
	 * Define o objeto GameList para esta chave primária composta.
	 * @param list O objeto {@link GameList} a ser definido.
	 */
	public void setList(GameList list) {
		this.list = list;
	}

	/**
	 * Gera um código hash para o objeto BelongingPK.
	 * Baseia-se nos códigos hash dos campos 'game' e 'list' para garantir a unicidade.
	 *
	 * @return O código hash do objeto.
	 */
	@Override
	public int hashCode() {
		// Garante que objetos BelongingPK com o mesmo jogo e lista tenham o mesmo hashCode.
		return Objects.hash(game, list);
	}

	/**
	 * Compara este objeto BelongingPK com outro objeto para verificar igualdade.
	 * A igualdade é determinada pela comparação dos campos 'game' e 'list'.
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
		// Realiza o cast para BelongingPK e compara os campos 'game' e 'list'.
		BelongingPK other = (BelongingPK) obj;
		return Objects.equals(game, other.game) && Objects.equals(list, other.list);
	}
}


