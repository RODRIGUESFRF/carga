package com.carga.compras;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Carga {
	
	private static final String ARQUIVO_CONFIG_README_MSG = "Arquivo de configuração %s não informado ou não existe!. Leia o README.md";
	public static final String AD_CONFIG = "-f";
	public static final String DB_CONFIG = "-d";
	public static final String TIPO_CARGA = "-t";
	private static Logger logger = LoggerFactory.getLogger(Carga.class);
	static private Map<String, String> params = new HashMap<>();
	private static Path BASE_PATH = Paths.get(".");	
	
	public static void main(String[] args) throws Exception {

		try {
			final Carga carga = new Carga();
			carga.inicio();
			carga.run(args);
			carga.encerrar();
			System.exit(0);
		} catch (IllegalArgumentException e) {
			logger.info(e.getMessage());
			logger.trace(e.getMessage(), e);
			System.exit(1);
		} catch (FileNotFoundException e) {
			logger.info(e.getMessage());
			logger.trace(e.getMessage(), e);
			System.exit(2);
		}
	}

	public void run(String[] args) throws Exception {

		
		if (logger.isDebugEnabled()) {
			logger.debug("args: {}", args.length);
			for (int i = 0; i < args.length; i++) {

				logger.debug("args[{}]: {}", i, args[i]);
			}
		}

		if (args.length % 2 != 0 || args.length == 0) {
			throw new IllegalArgumentException("Número de argumentos inválidos!. Leia o README.md");
		}

		for (int i = 0; i < args.length; i = i + 2) {

			String k = args[i];
			switch (args[i]) {

			case DB_CONFIG:
				params.put(k, args[i + 1]);
				break;
			case AD_CONFIG:
				params.put(k, args[i + 1]);
				break;

			}
		}

		if (params.isEmpty()) {
			throw new IllegalArgumentException("Argumentos não foram carregados corretamente!. Leia o README.md");
		}

		logger.debug("Params: {}", params);
		logger.debug("Params Keys: {}", params.keySet());
		logger.debug("File: {}", Paths.get(".").toAbsolutePath());

		// verificando arquivo de inicialização
		verificarArquivoEntrada(AD_CONFIG, String.format(ARQUIVO_CONFIG_README_MSG, ""));

		// verificando arquivo de banco de dados
		verificarArquivoEntrada(DB_CONFIG, String.format(ARQUIVO_CONFIG_README_MSG, "do banco de dados"));

	//	List<PrimeiraCompra> erroList = new LinkedList<>();

		logger.info("Iniciando processamento dos dados entre banco de dados e AD...");	
				
		ArquivoCSV lerArq = new ArquivoCSV();
		
		
		List<PrimeiraCompra> listPrimeiraCompra = lerArq.LeChamadosCSV1Compra();
		List<SegundaCompra> listSegundaCompra = lerArq.LeChamadosCSV2Compra(toString());
		
		Conexao dbconn = new Conexao();		
		dbconn.gravaPrimeiraCompra(listPrimeiraCompra);
		dbconn.gravaSegundaCompra(listSegundaCompra);

	}
	
	

	private void inicio() {
		logger.info("");
		logger.info(""
				+ ""
				+ "============================================================================");
		logger.info("iniciando processamento de carga de registros LOG PORTO 1ª e 2ª COMPRA...");
		logger.info("============================================================================");
		logger.info("");
		logger.info("");
	}
	
	public boolean existeArquivo(String path) {

		return getFile(path).exists();
	}

	protected File getFile(String path) {

		return new File(BASE_PATH.toFile().getAbsolutePath(), path);
	}
	
	
	private void verificarArquivoEntrada(String chave, String mensagem) throws FileNotFoundException {
			
			if (!params.containsKey(chave) || !existeArquivo(params.get(chave))) {
				throw new FileNotFoundException(mensagem);
			}
	}

	

	protected void encerrar() {
		logger.info("");
		logger.info("============================================================================");
		logger.info("Finalizado o  processamento de inserção de dados LOG PORTO 1ª E 2ª COMPRA...");
		logger.info("============================================================================");
		logger.info("");
		logger.info("");
		
	}

	public static Map<String, String> getParams() {
		return params;
	}
	

}
