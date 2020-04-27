package com.br.axsilva_bank.excecoes;

public class TransferenciaDefautlException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Exceção usada para mensagens de erro genéricas.
	 *
	 * @param Recebe uma string como mensagem de exceção.
	 */
	public TransferenciaDefautlException(String msg) {
		super(msg);
	}
}
