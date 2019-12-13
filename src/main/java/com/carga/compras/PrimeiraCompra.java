package com.carga.compras;

import java.util.Date;

public class PrimeiraCompra {	
	
	
	private String cpf;
	
	private Date data_proposta;
	
	private String proposta_cartao;
	
	private Integer cod_bandeira;
	
	private Integer cod_sit_proposta;
	
	private String situacao_proposta;
	
	private String resultado;
	
	private Integer origem_azul;
	
	private Integer proposta_azul;
	
	
	
	



	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	
	public Date getData_proposta() {
		return data_proposta;
	}

	public void setData_proposta(Date data_proposta) {
		this.data_proposta = data_proposta;
	}

	public String getProposta_cartao() {
		return proposta_cartao;
	}
	
	public void setProposta_cartao(String proposta_cartao) {
		this.proposta_cartao = proposta_cartao;
	}
	
	public Integer getCod_bandeira() {
		return cod_bandeira;
	}

	public void setCod_bandeira(Integer cod_bandeira) {
		this.cod_bandeira = cod_bandeira;
	}

	public Integer getCod_sit_proposta() {
		return cod_sit_proposta;
	}

	public void setCod_sit_proposta(Integer cod_sit_proposta) {
		this.cod_sit_proposta = cod_sit_proposta;
	}

	public String getSituacao_proposta() {
		return situacao_proposta;
	}

	public void setSituacao_proposta(String situacao_proposta) {
		this.situacao_proposta = situacao_proposta;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public Integer getOrigem_azul() {
		return origem_azul;
	}

	public void setOrigem_azul(Integer origem_azul) {
		this.origem_azul = origem_azul;
	}

	public Integer getProposta_azul() {
		return proposta_azul;
	}

	public void setProposta_azul(Integer proposta_azul) {
		this.proposta_azul = proposta_azul;
	}





	@Override
	public String toString() {
		
		final StringBuilder sb = new StringBuilder();
		sb.append('{');
		sb.append(", cpf: " + cpf);
		sb.append(", data_proposta: " + data_proposta);
		sb.append(", proposta_cartao: " + proposta_cartao);
		sb.append(", cod_bandeira: " + cod_bandeira);
		sb.append(", cod_sit_proposta: " + cod_sit_proposta);
		sb.append(", situacao_proposta: " + situacao_proposta);
		sb.append(", resultado: " + resultado);
		sb.append(", origem_azul: " + origem_azul);
		sb.append(", proposta_azul: " + proposta_azul);
		sb.append('}');

		return sb.toString();
	}

}
