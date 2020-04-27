package com.br.axsilva_bank.servico;

import com.br.axsilva_bank.excecoes.TransferenciaDefautlException;

// TODO: Auto-generated Javadoc
/**
 * interface responsável por abstrair a implementação do serviço de transferencia entre contas.
 * @author Anderson Xavier
 * @version 1.0.0
 */
public interface TrasnferenciaServico {
	
	/**
	 * Transferir para.
	 *
	 * @param codigoContaOrigem the codigo conta origem
	 * @param codigoContaDestino the codigo conta destino
	 * @param valor the valor
	 * @return true, if successful
	 * @throws TransferenciaDefautlException the transferencia defautl exception
	 */

	boolean transferirPara(String codigoContaOrigem, String codigoContaDestino, double valor)
			throws TransferenciaDefautlException;
}
