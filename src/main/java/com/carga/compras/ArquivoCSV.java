package com.carga.compras;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArquivoCSV {

	private static Logger logger = LoggerFactory.getLogger(ArquivoCSV.class);
	private static Path BASE_PATH = Paths.get(".");	

	
	public List<PrimeiraCompra> LeChamadosCSV1Compra() throws IOException {
		logger.info("LeChamadosCSV1Compra");
		List<PrimeiraCompra> ListPrimeiraCompra = new ArrayList<>();
		BufferedReader leitorCSV = null;
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		try {

			//leitorCSV = new BufferedReader(new FileReader(new File(BASE_PATH.toFile().getAbsolutePath(), "src/test/resources/relatorio_azul_primeiracompra_20191119-065959.csv")));
			leitorCSV = new BufferedReader(new FileReader(new File(BASE_PATH.toFile().getAbsolutePath(), "src/test/resources/relatorio_azul_primeiracompra_20191119-065959.csv")));
			String linha = "";
			leitorCSV.readLine(); // Remove a primeira linha (linha do título)
			String[] linhaArray;

			while ((linha = leitorCSV.readLine()) != null  ) {
				linhaArray = linha.split(";");
				if (linhaArray.length == 13) {
					PrimeiraCompra primeiraCompra = new PrimeiraCompra();
					primeiraCompra.setCpf(linhaArray[0]);
					primeiraCompra.setData_proposta(sdf.parse(linhaArray[1]));
					primeiraCompra.setProposta_cartao(linhaArray[2]);
					primeiraCompra.setCod_bandeira(Integer.parseInt(linhaArray[4]));
					primeiraCompra.setCod_sit_proposta(Integer.parseInt(linhaArray[7]));
					primeiraCompra.setSituacao_proposta(linhaArray[8]);
					primeiraCompra.setResultado(linhaArray[9]);
					primeiraCompra.setOrigem_azul(Integer.parseInt(linhaArray[11]));
					primeiraCompra.setProposta_azul(Integer.parseInt(linhaArray[12]));
					ListPrimeiraCompra.add(primeiraCompra);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ListPrimeiraCompra;
	
		
	}
	
	
		
	public List<SegundaCompra> LeChamadosCSV2Compra(String Payware_retorno_descricao) throws IOException {
		logger.info("LeChamadosCSV2Compra");
		List<SegundaCompra> ListSegundaCompra = new ArrayList<>();
		BufferedReader leitorCSV = null;
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		UtilString utilString = new UtilString();

		try {
			//leitorCSV = new BufferedReader(new FileReader("src/test/resources/relatorio_azul_segundacompra_20191119-070002.csv"));
			leitorCSV = new BufferedReader(new FileReader(new File(BASE_PATH.toFile().getAbsolutePath(), "src/test/resources/relatorio_azul_segundacompra_20191119-070002.csv")));
			String linha = "";
			leitorCSV.readLine(); // Remove a primeira linha (linha do título)
			String[] linhaArray;

			while ((linha = leitorCSV.readLine()) != null) {
				linhaArray = linha.split(";");
				
				if (linhaArray.length == 19) {
					SegundaCompra segundaCompra = new SegundaCompra();				
					segundaCompra.setRegistro(Integer.parseInt(linhaArray[0]));
					segundaCompra.setData_hora(sdf.parse(linhaArray[2]));
					segundaCompra.setAutorizacao_valor(Double.valueOf(linhaArray[8]));
					segundaCompra.setAutorizacao_parcelas(Integer.parseInt(linhaArray[9]));
					segundaCompra.setOrigem(linhaArray[10]);
					segundaCompra.setProposta(utilString.limitaString(linhaArray[11],8));
					segundaCompra.setApolice(linhaArray[12]);
					segundaCompra.setPayware_retorno_codigo(Integer.parseInt(linhaArray[13]));
				    segundaCompra.setPayware_retorno_descricao(utilString.limitaString(linhaArray[14],250));
					segundaCompra.setCsu_statusAprovacaoRejeicao(linhaArray[15]);
					ListSegundaCompra.add(segundaCompra);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ListSegundaCompra;
	}
	
//	//limitando o caracter do campo Payware_retorno_descricao
//	public String limitaString(String Payware_retorno_descricao){        
//        int tamanho = 249;		
//		if(Payware_retorno_descricao != null && Payware_retorno_descricao.length() > tamanho){            
//            return Payware_retorno_descricao.substring(0, tamanho);
//        } else {
//            return Payware_retorno_descricao;
//        }        
//    }

	
	

}
