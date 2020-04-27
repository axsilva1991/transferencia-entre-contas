package com.br.axsilva_bank.excecoes;

public class ValorInvalidoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Exceção padrão para valores inválidos.
	 *
	 * @param Recebe uma string como mensagem de exceção.
	 */
	public ValorInvalidoException(String msg) {
		super(msg);
	}
}
