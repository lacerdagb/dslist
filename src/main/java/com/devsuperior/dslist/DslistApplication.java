/**
 * Classe principal da aplicação DSList.
 * Esta classe é o ponto de entrada para a aplicação Spring Boot.
 * Ela inicializa e executa a aplicação, configurando o ambiente necessário
 * para os componentes da API REST.
 *
 * @author lacerdagb (mantido como autor original, conforme instrução)
 * @version 1.0.0
 */
package com.devsuperior.dslist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Anotação que marca esta classe como uma aplicação Spring Boot, habilitando auto-configuração e varredura de componentes.
public class DslistApplication {

	/**
	 * Método principal que inicia a aplicação Spring Boot.
	 * Este é o ponto de partida para a execução do programa.
	 *
	 * @param args Argumentos de linha de comando passados para a aplicação.
	 */
	public static void main(String[] args) {
		// Inicia a aplicação Spring Boot, configurando o contexto da aplicação e iniciando o servidor embarcado.
		SpringApplication.run(DslistApplication.class, args);
	}

}


