
package com.br.axsilva_bank.servico.impl;

import org.springframework.stereotype.Service;

import com.br.axsilva_bank.excecoes.TransferenciaDefautlException;
import com.br.axsilva_bank.excecoes.ValorInvalidoException;
import com.br.axsilva_bank.modelo.Cliente;
import com.br.axsilva_bank.modelo.Conta;
import com.br.axsilva_bank.servico.TrasnferenciaServico;

/**
 * Classe responsável por realizar a implementação do 
 * serviço de transferencia de valores entre 2 contas.
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

	private long agencia = 1;
	
	Conta contaOrigem;
	
	Conta contaDestino;
	
	/**
	 * Responsável por realizar a implementação do 
	 * serviço de transferencia de valores entre 2 contas.
	 * @param codigoContaOrigem Código da conta Origem
	 * @param codigoContaDestino Código conta destino
	 * @param valor valor financeiro da transação
	 * @return true, quando a transação for efetuada com sucesso.
	 * @throws TransferenciaDefautlException Exceção que pode ser retornada caso a transação tenha problemas ou erros.
	 */
	@Override
	public boolean transferirPara(String codigoContaOrigem, String codigoContaDestino, double valor)
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
	 * Verificar conta, método responsavel por verificar se as contas são validas.
	 *
	 * @param codigoContaOrigem 
	 * @param codigoContaDestino 
	 * @return true quando as contas forem validas.
	 */
	private boolean verificarConta(String codigoContaOrigem, String codigoContaDestino) {
		if (codigoContaOrigem == null || codigoContaOrigem.equals(""))
			throw new ValorInvalidoException("Código da conta de origem invalida.");
		if ((codigoContaDestino == null) || codigoContaDestino.equals(""))
			throw new ValorInvalidoException("Código da conta de destino invalida.");
		return true;
	}

}
