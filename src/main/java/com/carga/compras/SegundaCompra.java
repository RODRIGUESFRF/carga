package com.carga.compras;

import java.util.Date;

public class SegundaCompra {
	

	private Integer registro;
	private Date data_hora;
	private Double autorizacao_valor;
	private Integer autorizacao_parcelas;
	private String origem;
	private String proposta;
	private String apolice;
	private Integer payware_retorno_codigo;
	private String payware_retorno_descricao;
	private String csu_statusAprovacaoRejeicao;

	public Integer getRegistro() {
		return registro;
	}
	public void setRegistro(Integer registro) {
		this.registro = registro;
	}
	public Date getData_hora() {
		return data_hora;
	}
	public void setData_hora(Date data_hora) {
		this.data_hora = data_hora;
	}
	public Double getAutorizacao_valor() {
		return autorizacao_valor;
	}
	public void setAutorizacao_valor(Double autorizacao_valor) {
		this.autorizacao_valor = autorizacao_valor;
	}
	public Integer getAutorizacao_parcelas() {
		return autorizacao_parcelas;
	}
	public void setAutorizacao_parcelas(Integer autorizacao_parcelas) {
		this.autorizacao_parcelas = autorizacao_parcelas;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getProposta() {
		return proposta;
	}
	public void setProposta(String proposta) {
		this.proposta = proposta;
	}
	public String getApolice() {
		return apolice;
	}
	public void setApolice(String apolice) {
		this.apolice = apolice;
	}
	public Integer getPayware_retorno_codigo() {
		return payware_retorno_codigo;
	}
	public void setPayware_retorno_codigo(Integer payware_retorno_codigo) {
		this.payware_retorno_codigo = payware_retorno_codigo;
	}
	public String getPayware_retorno_descricao() {
		return payware_retorno_descricao;
	}
	public void setPayware_retorno_descricao(String payware_retorno_descricao) {		
		this.payware_retorno_descricao = payware_retorno_descricao;
	}
	public String getCsu_statusAprovacaoRejeicao() {
		return csu_statusAprovacaoRejeicao;
	}
	public void setCsu_statusAprovacaoRejeicao(String csu_statusAprovacaoRejeicao) {
		this.csu_statusAprovacaoRejeicao = csu_statusAprovacaoRejeicao;
	}
	
	
	
	
	@Override
	public String toString() {
		
		final StringBuilder sb = new StringBuilder();
		sb.append('{');
		sb.append(", registro: " + registro);
		sb.append(", data_hora: " + data_hora);
		sb.append(", autorizacao_valor: " + autorizacao_valor);
		sb.append(", autorizacao_parcelas: " + autorizacao_parcelas);
		sb.append(", origem: " + origem);
		sb.append(", proposta: " + proposta);
		sb.append(", apolice: " + apolice);
		sb.append(", payware_retorno_codigo: " + payware_retorno_codigo);
		sb.append(", payware_retorno_descricao: " + payware_retorno_descricao);
		sb.append(", csu_statusAprovacaoRejeicao: " + csu_statusAprovacaoRejeicao);
		sb.append('}');

		return sb.toString();
	}

	
	
	
	

}
