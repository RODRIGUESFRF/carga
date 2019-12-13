package com.carga.compras;

public class UtilString {
	
		//limitando o caracter do campo Payware_retorno_descricao
		//esse campo tem 0 limite de 250 caracteres, se houver mais que isso, a funcao limita a este numero
		public String limitaString(String txt, int tamanho){        
			if(txt != null && txt.length() > tamanho){            
	            return txt.substring(0, tamanho);
	        } else {
	            return txt;
	        }        
	    }

		public String garanteZerosEsquerda(String txt, int digitos){
			String aux = "";
			if(txt != null){ 
				while(aux.length()<digitos) {
					aux = aux+"0";
				}
				aux = aux+txt;
	            return aux.substring(aux.length()-digitos, digitos);
	        } else {
	            return txt;
	        }        
	    }

		public String garanteEspacoesDireita(String txt, int caracteres){
			String aux = "";
			if(txt != null){ 
				while(aux.length()<caracteres) {
					aux = aux+" ";
				}
				txt = txt + aux;
	            return txt.substring(0, caracteres);
	        } else {
	            return txt;
	        }        
	    }

}
