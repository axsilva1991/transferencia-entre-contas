package com.br.axsilva_bank.modelo.excecoes;

public class ValorContaInvalido extends Exception{
	private static final long serialVersionUID = 1L;

	public ValorContaInvalido(String msg) {
		super(msg);
	}
}