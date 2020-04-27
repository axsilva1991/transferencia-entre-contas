package com.br.axsilva_bank.servico.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.br.axsilva_bank.excecoes.TransferenciaDefautlException;

// TODO: Auto-generated Javadoc
/**
 * The Class TransferenciaServicoImplTest.
 */
@RunWith(MockitoJUnitRunner.class)
class TransferenciaServicoImplTest {
	
	/** The transferencia service. */
	@Autowired
	TrasnferenciaServicoImpl transferenciaService;

	/**
	 * Quando a transferencia retornar sucesso.
	 *
	 * @throws TransferenciaDefautlException the transferencia defautl exception
	 */
	@Test
	public void quando_a_transferencia_retornar_sucesso() throws TransferenciaDefautlException {
		transferenciaService = new TrasnferenciaServicoImpl();
		String codigoContaOrigem = "01";
		String codigoContaDestino = "02";
		double valor = 40;
		assertFalse("Quando a transferencia obtiver êxito.",
				!transferenciaService.transferirValorPara(codigoContaOrigem, codigoContaDestino, valor));
	}
	
	/**
	 * Quando o saldo for insuficiente para transferir.
	 */
	@Test
	public void quando_o_saldo_for_insuficiente_para_transferir() {
		transferenciaService = new TrasnferenciaServicoImpl();
		String codigoContaOrigem = "01";
		String codigoContaDestino = "02";
		double valor = 120;
		try {
			transferenciaService.transferirValorPara(codigoContaOrigem, codigoContaDestino, valor);
		} catch (TransferenciaDefautlException e) {
			String erroMsg = "Seu saldo é insuficiente para realizar esta operação.";
			assertEquals(erroMsg, e.getMessage(), "Saldo insuficiente");
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Quando a conta destino for nula.
	 */
	@Test
	public void quando_a_conta_destino_for_nula() {
		transferenciaService = new TrasnferenciaServicoImpl();
		String codigoContaOrigem = "01";
		String codigoContaDestino = null;
		double valor = 40;
		try {
			transferenciaService.transferirValorPara(codigoContaOrigem, codigoContaDestino, valor);
		} catch (Exception e) {
			String erroMsg = "Código da conta de destino invalida.";
			assertEquals(erroMsg, e.getMessage(), "Conta Destino invalida");
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Quando a conta origem for nula.
	 */
	@Test
	public void quando_a_conta_origem_for_nula() {
		transferenciaService = new TrasnferenciaServicoImpl();
		String codigoContaOrigem = null;
		String codigoContaDestino = "01";
		double valor = 40;
		try {
			transferenciaService.transferirValorPara(codigoContaOrigem, codigoContaDestino, valor);
		} catch (Exception e) {
			String erroMsg = "Código da conta de origem invalida.";
			assertEquals(erroMsg, e.getMessage(), "Conta origem invalida");
			e.printStackTrace();
		}
		
	}

}
