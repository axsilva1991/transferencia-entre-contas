
package com.br.axsilva_bank.servico.impl;

import org.springframework.stereotype.Service;

import com.br.axsilva_bank.excecoes.TransferenciaDefautlException;
import com.br.axsilva_bank.excecoes.ValorInvalidoException;
import com.br.axsilva_bank.modelo.Cliente;
import com.br.axsilva_bank.modelo.Conta;
import com.br.axsilva_bank.servico.TrasnferenciaServico;

// TODO: Auto-generated Javadoc
/**
 * The Class TrasnferenciaServicoImpl.
 *
 * @author Anderson Xavier
 * @version 1.0.0
 */
@Service
public class TrasnferenciaServicoImpl implements TrasnferenciaServico {
	/*
	 * Para a versão inicial de MVP deste código as contas serão cadastradas apenas
	 * para a agência de numero 1. Sendo que após o teste em piloto o cadastro de
	 * contas será expandido para toda a rede
	 */

	/** The agencia. */
	private long agencia = 1;
	
	/** The conta origem. */
	Conta contaOrigem;
	
	/** The conta destino. */
	Conta contaDestino;
	
	/**
	 * Transferir valor para.
	 *
	 * @param codigoContaOrigem the codigo conta origem
	 * @param codigoContaDestino the codigo conta destino
	 * @param valor the valor
	 * @return true, if successful
	 * @throws TransferenciaDefautlException the transferencia defautl exception
	 */
	@Override
	public boolean transferirValorPara(String codigoContaOrigem, String codigoContaDestino, double valor)
			throws TransferenciaDefautlException {
		/*
		 * Criação está das contas estão sendo feitas manulamente devido a ausencia de um detalhamento de regra.
		 */
		if(verificarConta(codigoContaOrigem , codigoContaDestino)) {
			contaOrigem = new Conta(agencia, new Cliente(), Long.parseLong(codigoContaOrigem));
			contaDestino = new Conta(agencia, new Cliente(), Long.parseLong(codigoContaDestino));
			return contaOrigem.transferencia(valor, contaDestino);
		}
			return contaOrigem.transferencia(valor, contaDestino);
	}

	/**
	 * Verificar conta.
	 *
	 * @param codigoContaOrigem the codigo conta origem
	 * @param codigoContaDestino the codigo conta destino
	 * @return true, if successful
	 */
	private boolean verificarConta(String codigoContaOrigem, String codigoContaDestino) {
		if (codigoContaOrigem == null || codigoContaOrigem.equals(""))
			throw new ValorInvalidoException("Código da conta de origem invalida.");
		if ((codigoContaDestino == null) || codigoContaDestino.equals(""))
			throw new ValorInvalidoException("Código da conta de destino invalida.");
		return true;
	}

}
