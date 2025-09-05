/**
 * Objeto de Transferência de Dados (DTO) para representar informações de substituição
 * de posição de um jogo dentro de uma lista.
 * Esta classe é utilizada para receber os índices de origem e destino
 * quando um jogo é movido em uma lista.
 *
 * @author lacerdagb (mantido como autor original, conforme instrução)
 * @version 1.0.0
 */
package com.devsuperior.dslist.dto;

public class ReplacementDTO {

	private Integer sourceIndex; // O índice atual do jogo na lista (posição de origem).
	private Integer destinationIndex; // O novo índice para o jogo na lista (posição de destino).

	/**
	 * Retorna o índice de origem do jogo.
	 * @return O índice de origem.
	 */
	public Integer getSourceIndex() {
		return sourceIndex;
	}

	/**
	 * Define o índice de origem do jogo.
	 * @param sourceIndex O novo índice de origem.
	 */
	public void setSourceIndex(Integer sourceIndex) {
		this.sourceIndex = sourceIndex;
	}

	/**
	 * Retorna o índice de destino do jogo.
	 * @return O índice de destino.
	 */
	public Integer getDestinationIndex() {
		return destinationIndex;
	}

	/**
	 * Define o índice de destino do jogo.
	 * @param destinationIndex O novo índice de destino.
	 */
	public void setDestinationIndex(Integer destinationIndex) {
		this.destinationIndex = destinationIndex;
	}
}


