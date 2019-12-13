package com.carga.compras;

public class UtilString {
	
		//limitando o caracter do campo Payware_retorno_descricao
		//esse campo tem 0 limite de 250 caracteres, se houver mais que isso, a funcao limita a este numero
		public String limitaString(String Payware_retorno_descricao){        
	        int tamanho = 249;		
			if(Payware_retorno_descricao != null && Payware_retorno_descricao.length() > tamanho){            
	            return Payware_retorno_descricao.substring(0, tamanho);
	        } else {
	            return Payware_retorno_descricao;
	        }        
	    }


}
