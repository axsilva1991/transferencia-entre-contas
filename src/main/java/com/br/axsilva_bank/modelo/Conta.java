package com.br.axsilva_bank.modelo;

import java.io.Serializable;

import com.br.axsilva_bank.excecoes.TransferenciaDefautlException;
import com.br.axsilva_bank.excecoes.ValorInvalidoException;

// TODO: Auto-generated Javadoc
/**
 * Classe responsável por representar uma conta do banco axisilva.
 * 
 * @author Anderson Xavier
 * @version 1.0.0
 * 
 */
public class Conta implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The saldo. */
	private double saldo;
	
	/** The agencia. */
	private long agencia;
	
	/** The conta. */
	private long conta;
	
	/** The tutular. */
	private Cliente tutular;

	/**
	 * Constructor responsável por criar uma conta com um saldo incial de 100.00
	 * apartir dos parâmetros Agência, Conta e Titular
	 *
	 * @param agencia the agencia
	 * @param tutular the tutular
	 * @param conta the conta
	 */
	public Conta(long agencia, Cliente tutular, long conta) {
		this.saldo = 100;
		this.setAgencia(agencia);
		this.setTutular(tutular);
		this.setConta(conta);
	}

	/**
	 * Os valores da agências precisam ser maiores ou igual a 1, pois foi
	 * determinado na normativa Xpto que o banco axisilva não pode ter contas com
	 * valores negativos.
	 *
	 * @param agencia the new agencia
	 */
	private void setAgencia(long agencia) {
		if (agencia < 1)
			throw new ValorInvalidoException("Código da agencia invalido.");
		this.agencia = agencia;
	}

	/**
	 * Sets the conta.
	 *
	 * @param conta the new conta
	 */
	public void setConta(long conta) {
		this.conta = conta;
	}

	/**
	 * Sets the tutular.
	 *
	 * @param tutular the new tutular
	 */
	private void setTutular(Cliente tutular) {
		this.tutular = tutular;
	}

	/**
	 * Deposita.
	 *
	 * @param valor the valor
	 */
	public void deposita(double valor) {
		this.saldo += valor;

	}

	/**
	 * Saca.
	 *
	 * @param valor the valor
	 * @throws TransferenciaDefautlException the transferencia defautl exception
	 */
	private void saca(double valor) throws TransferenciaDefautlException {
		if (this.saldo < valor)
			throw new TransferenciaDefautlException("Seu saldo é insuficiente para realizar esta operação.");
		this.saldo -= valor;
	}

	/**
	 * Gets the conta.
	 *
	 * @return the conta
	 */
	public long getConta() {
		return this.conta;
	}

	/**
	 * Transferencia.
	 *
	 * @param valor the valor
	 * @param destino the destino
	 * @return true, if successful
	 * @throws TransferenciaDefautlException the transferencia defautl exception
	 */
	public boolean transferencia(double valor, Conta destino) throws TransferenciaDefautlException {

		this.saca(valor);
		destino.deposita(valor);
		return true;
	}

}
