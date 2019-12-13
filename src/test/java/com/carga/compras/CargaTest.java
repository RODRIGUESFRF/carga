package com.carga.compras;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Test;


public class CargaTest {

	//private static final int REGISTRO = 1;

	//private static final String CONFIG_PROPERTIES = "src/test/resources/config.properties";
	private static final String DB_PROPERTIES = "src/test/resources/db.properties";
	private static final String ARQUIVO = "src/test/resources/relatorio_azul_primeiracompra_20191119-065959.csv"; 
//	private static final String ARQUIVO2 = "src/test/resources/relatorio_azul_segundacompra_20191119-070002.csv"; 

	//private int[] cargaspc = new int[] { REGISTRO };

	//private Carga carga = new Carga();

	public void loadConfig() throws IOException, SQLException {

	//	carga.init(CONFIG_PROPERTIES);
		// prepareDb();
	}

	@Test
	public void testMain() throws Exception {
		Carga carga = new Carga();
		String[] args = new String[] { "-d", DB_PROPERTIES, "-f", ARQUIVO};
		Carga.main(args);
		carga.run(args);
		carga.encerrar();
	}

//	private PrimeiraCompra popularRegistroInfo() {
//
//		Long id = 1l;
//		String cpf = String.format("99999999999");
//		String data_proposta = "11/11/1111 11:11:11";
//		Integer proposta_cartao = 505050;
//		Integer cod_bandeira = 1;
//		Integer cod_sit_proposta = 4;
//		String situacao_proposta = "Finalizada";
//		String resultado = "Aprovado";
//		Integer origem_azul = 98;
//		Integer proposta_azul = 100;
//		
//		PrimeiraCompra info = popularRegistro(id, cpf, data_proposta, proposta_cartao, cod_bandeira, cod_sit_proposta,
//				situacao_proposta, resultado, origem_azul, proposta_azul);
//		return info;
//	}
//	
//	
//
//	private PrimeiraCompra popularRegistro(Long id, String cpf, String data_proposta, Integer proposta_cartao,
//			Integer cod_bandeira, Integer cod_sit_proposta, String situacao_proposta, String resultado,
//			Integer origem_azul, Integer proposta_azul) {
//
//		PrimeiraCompra info = new PrimeiraCompra();
//		info.setId(id);
//		info.setCpf(cpf);
//		info.setData_proposta(data_proposta);
//		info.setProposta_cartao(proposta_cartao);
//		info.setCod_bandeira(cod_bandeira);
//		info.setCod_sit_proposta(cod_sit_proposta);
//		info.setSituacao_proposta(situacao_proposta);
//		info.setResultado(resultado);
//		info.setOrigem_azul(origem_azul);
//		info.setProposta_azul(proposta_azul);
//		return info;
//	}

//	private void prepareDb() {

//		try {

			// StringBuilder sb = new StringBuilder();
			// sb.append("drop table if exists login;");
			// sb.append("create table login (user_code VARCHAR(50) NOT NULL, password
			// VARCHAR(20) NOT NULL, user_name VARCHAR(60) NOT NULL, nom_email VARCHAR(60)
			// NOT NULL, menu_code VARCHAR(20) NOT NULL, id_perfil smallint(6) DEFAULT
			// NULL);");

//			carga.dbInit(carga.getFile(DB_PROPERTIES));
//			Connection conn = carga.connect();
			// conn.createStatement().execute(sb.toString());

			// gerando corretores aleratórios
//			Random r = new Random();
//			int max = r.nextInt(10);
//
//			PreparedStatement pstmt = conn.prepareStatement(
//					"insert into cp_carga (id,cpf,data_proposta,proposta_cartao,cod_bandeira,cod_sit_proposta,situacao_proposta,resultado,origem_azul,proposta_azul) "
//							+ "										values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
//			for (int c = 0; c < max; c++) {

				//CorretorInfo info = geradorCorretor();
//				PrimeiraCompra pc = popularRegistroInfo();
//				pstmt.setLong(1, pc.getId());
//				pstmt.setString(2, pc.getCpf());
//				pstmt.setString(3, pc.getData_proposta());
//				pstmt.setInt(4, pc.getProposta_cartao());
//				pstmt.setInt(5, pc.getCod_bandeira());
//				pstmt.setInt(6, pc.getCod_sit_proposta());
//				pstmt.setString(7, pc.getSituacao_proposta());
//				pstmt.setString(8, pc.getResultado());
//				pstmt.setInt(9, pc.getOrigem_azul());
//				pstmt.setInt(10, pc.getProposta_azul());
//				pstmt.setInt(11, cargaspc[r.nextInt(cargaspc.length)]);
//
//				assertThat(pstmt.executeUpdate(), is(equalTo(1)));
//			}
//
//			pstmt.close();
//
//			ResultSet rs = conn.createStatement().executeQuery("select count(*) from pc_carga");
//			rs.next();
//
//			int registros = rs.getInt(1);
//			rs.close();
//			conn.close();
//
//			assertThat(max, is(equalTo(registros)));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}
