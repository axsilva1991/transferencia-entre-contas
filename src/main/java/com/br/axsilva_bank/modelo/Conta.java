package com.br.axsilva_bank.modelo;

import java.io.Serializable;

import com.br.axsilva_bank.excecoes.ContaDestinoNaoSelecionada;
import com.br.axsilva_bank.excecoes.SaldoInsuficenteException;
import com.br.axsilva_bank.excecoes.ValorContaInvalido;

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
	 * Constructor responsável por criar uma conta com um saldo incial de 100.00
	 * apartir dos parâmetros Agência, Conta e Titular
	 * 
	 * @param agencia
	 * @param conta
	 * @param tutular
	 * @throws ValorContaInvalido 
	 */
	public Conta(long agencia, long conta, Cliente tutular) throws ValorContaInvalido {
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
	 * @throws ValorContaInvalido 
	 */
	private void setConta(long conta) throws ValorContaInvalido {
		if (conta < 1)
			throw new ValorContaInvalido("Código da conta invalido");
		this.conta = conta;
	}

	private void setTutular(Cliente tutular) {
		this.tutular = tutular;
	}

	public void deposita(double valor) {
		this.saldo += valor;

	}

	private void saca(double valor) throws SaldoInsuficenteException {
		if (this.saldo < valor)
			throw new SaldoInsuficenteException("Saldo: " + this.saldo + ", Valor: " + valor);
		this.saldo -= valor;
	}

	public boolean transferencia(double valor, Conta destino) throws SaldoInsuficenteException {
		if (destino.equals(null))
			throw new ContaDestinoNaoSelecionada("Por favor selecione uma conta destino.");
		this.saca(valor);
		destino.deposita(valor);
		return true;
	}
}
