package com.br.axsilva_bank.modelo;

import java.io.Serializable;

import com.br.axsilva_bank.excecoes.TransferenciaDefautlException;
import com.br.axsilva_bank.excecoes.ValorInvalidoException;

/**
 * Classe responsável por representar uma conta do banco axisilva.
 * 
 * @author Anderson Xavier
 * @version 1.0.0
 * 
 */
public class Conta implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private double saldo;
	
	private long agencia;
	
	private long conta;
	
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

	public void setConta(long conta) {
		this.conta = conta;
	}


	private void setTutular(Cliente tutular) {
		this.tutular = tutular;
	}

	/**
	 * Método responsável por depositar o valor.
	 *
	 * @param recebe um valor como entrada.
	 */
	public void deposita(double valor) {
		this.saldo += valor;

	}

	/**
	 * Método responsável por realizar o saque e verificar se 
	 * o saldo é suficiente para realização da transação.
	 *
	 * @param Recebe como parametro um valor.
	 * @throws TransferenciaDefautlException caso o saldo seja 
	 * inferior ao saque este método retorna uma exceção.
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
	 * Método responsável por realizar a transferência entre dias contas.<br>
	 * recebe um valor e uma conta destino 
	 * @param valor
	 * @param destino 
	 * @return true quando a transferencia for realizada.
	 * @throws TransferenciaDefautlException Caso contrário retorna uma exceção com o mótivo do erro.
	 */
	public boolean transferencia(double valor, Conta destino) throws TransferenciaDefautlException {

		this.saca(valor);
		destino.deposita(valor);
		return true;
	}

}
