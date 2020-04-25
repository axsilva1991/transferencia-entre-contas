package com.br.axsilva_bank.excecoes;

public class SaldoInsuficenteException extends Exception {

	private static final long serialVersionUID = 1L;

	public SaldoInsuficenteException(String msg) {
		super(msg);
	}

}
