package com.br.axsilva_bank.excecoes;

public class ValorContaInvalido extends Exception{
	private static final long serialVersionUID = 1L;

	public ValorContaInvalido(String msg) {
		super(msg);
	}
}
