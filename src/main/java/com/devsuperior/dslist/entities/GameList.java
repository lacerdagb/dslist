/**
 * Representa a entidade de uma lista de jogos no sistema.
 * Esta classe mapeia a tabela 'tb_game_list' no banco de dados e contém os atributos
 * que descrevem uma lista de jogos, como seu ID e nome.
 * É a representação de domínio de uma lista de jogos na aplicação.
 *
 * @author lacerdagb (mantido como autor original, conforme instrução)
 * @version 1.0.0
 */
package com.devsuperior.dslist.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Marca esta classe como uma entidade JPA, indicando que ela corresponde a uma tabela no banco de dados.
@Table(name = "tb_game_list") // Especifica o nome da tabela no banco de dados para esta entidade.
public class GameList {

	@Id // Indica que este campo é a chave primária da entidade.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Configura a geração automática de valores para a chave primária, usando a estratégia de identidade do banco de dados.
	private Long id; // Identificador único da lista de jogos.
	private String name; // Nome da lista de jogos.

	/**
	 * Construtor padrão vazio.
	 * Necessário para a JPA e para a criação de instâncias sem argumentos.
	 */
	public GameList() {
	}

	/**
	 * Construtor que inicializa os atributos de uma lista de jogos.
	 *
	 * @param id O identificador único da lista de jogos.
	 * @param name O nome da lista de jogos.
	 */
	public GameList(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * Retorna o ID da lista de jogos.
	 * @return O ID da lista de jogos.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Define o ID da lista de jogos.
	 * @param id O novo ID da lista de jogos.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Retorna o nome da lista de jogos.
	 * @return O nome da lista de jogos.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Define o nome da lista de jogos.
	 * @param name O novo nome da lista de jogos.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gera um código hash para o objeto GameList.
	 * Baseia-se no código hash do campo 'id' para garantir a unicidade.
	 *
	 * @return O código hash do objeto.
	 */
	@Override
	public int hashCode() {
		// Garante que objetos GameList com o mesmo ID tenham o mesmo hashCode, fundamental para coleções.
		return Objects.hash(id);
	}

	/**
	 * Compara este objeto GameList com outro objeto para verificar igualdade.
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
		// Realiza o cast para GameList e compara os IDs.
		GameList other = (GameList) obj;
		return Objects.equals(id, other.id);
	}
}


