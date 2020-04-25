package com.br.axsilva_bank.modelo;

import java.io.Serializable;

/**
 * Classe responsável por representar uma conta do banco axisilva.
 * 
 * @author Anderson Xavier
 * @version 1.0
 * 
 */
public class Conta implements Serializable {

	private static final long serialVersionUID = 1L;
	private double saldo;
	private long agencia;
	private long conta;
	private Cliente tutular;

	/**
	 * Construtor responsável por criar uma conta com um saldo incial de 100.00
	 * apartir dos parâmetros Agência, Conta e Titular
	 * 
	 * @param agencia
	 * @param conta
	 * @param tutular
	 */
	public Conta(long agencia, long conta, Cliente tutular) {
		this.saldo = 100;
		this.setAgencia(agencia);
		this.setConta(conta);
		this.setTutular(tutular);
	}
	/**
	 * Os valores da agências precisam ser maiores ou igual a 1, pois foi
	 * determinado na normativa Xpto que o banco axisilva não pode ter contas com
	 * valores negativos.
	 * 
	 * @param agencia
	 */
	private void setAgencia(long agencia) {
		if (agencia < 1) {
			System.err.println("o valor da agencia nao pode ser menor que 1.");
			return;
		}
		this.agencia = agencia;
	}
	/**
	 * Os códigos de conta precisam ser maiores ou igual a 1, pois foi determinado
	 * na normativa Xpto que o banco axisilva não pode ter contas com valores
	 * negativos.
	 * 
	 * @param agencia
	 */
	private void setConta(long conta) {
		if (conta < 1) {
			System.out.println();
			return;
		}
		this.conta = conta;
	}

	private void setTutular(Cliente tutular) {
		this.tutular = tutular;
	}
	@Override
	public String toString() {
		return "Conta [saldo=" + saldo + ", agencia=" + agencia + ", conta=" + conta + ", tutular=" + tutular + "]";
	}

}
