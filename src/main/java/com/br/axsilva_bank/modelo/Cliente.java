
package com.br.axsilva_bank.modelo;

import java.io.Serializable;

/**
 * Classe que representa um cliente do banco axsilva
 * @author Anderson Xavier
 * @version 1.0
 */
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nome;
	private long codigoCliente;
	
	/**
	 * Construtor responsável por cadastrar clientes apartir do nome
	 * @param nome
	 */
	public Cliente(String nome) {
		this.nome = nome;
		setCodigoCliente(codigoCliente);
	}
	
	private void setCodigoCliente(long codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	/**
	 * Método responsável por realizar transferencia entre duas contas <br>
	 * @return bolean
	 * <br>retorno true = transferencia realizada com sucesso. <br>
	 * retorno false = erro ao realizar transferencia.
	 */
	public boolean transferencia() {
		return false;
	}
}
