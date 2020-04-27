package com.br.axsilva_bank.servico.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.br.axsilva_bank.excecoes.TransferenciaDefautlException;


@RunWith(SpringRunner.class)
public class TransferenciaServicoImplTest {

	@Autowired
	TrasnferenciaServicoImpl transferenciaService;

	@Test
	public void quando_a_transferencia_retornar_sucesso() throws TransferenciaDefautlException {
		transferenciaService = new TrasnferenciaServicoImpl();
		String codigoContaOrigem = "01";
		String codigoContaDestino = "02";
		double valor = 40;
		assertFalse("Quando a transferencia obtiver êxito.",
				!transferenciaService.transferirPara(codigoContaOrigem, codigoContaDestino, valor));
	}

	@Test
	public void quando_o_saldo_for_insuficiente_para_transferir() {
		transferenciaService = new TrasnferenciaServicoImpl();
		String codigoContaOrigem = "01";
		String codigoContaDestino = "02";
		double valor = 120;
		try {
			transferenciaService.transferirPara(codigoContaOrigem, codigoContaDestino, valor);
		} catch (TransferenciaDefautlException e) {
			String erroMsg = "Seu saldo é insuficiente para realizar esta operação.";
			assertEquals(erroMsg, e.getMessage(), "Saldo insuficiente");
			e.printStackTrace();
		}

	}

	@Test
	public void quando_a_conta_destino_for_nula() {
		transferenciaService = new TrasnferenciaServicoImpl();
		String codigoContaOrigem = "01";
		String codigoContaDestino = null;
		double valor = 40;
		try {
			transferenciaService.transferirPara(codigoContaOrigem, codigoContaDestino, valor);
		} catch (Exception e) {
			String erroMsg = "Código da conta de destino invalida.";
			assertEquals(erroMsg, e.getMessage(), "Conta Destino invalida");
			e.printStackTrace();
		}

	}

	@Test
	public void quando_a_conta_origem_for_nula() {
		transferenciaService = new TrasnferenciaServicoImpl();
		String codigoContaOrigem = null;
		String codigoContaDestino = "01";
		double valor = 40;
		try {
			transferenciaService.transferirPara(codigoContaOrigem, codigoContaDestino, valor);
		} catch (Exception e) {
			String erroMsg = "Código da conta de origem invalida.";
			assertEquals(erroMsg, e.getMessage(), "Conta origem invalida");
			e.printStackTrace();
		}

	}

}
