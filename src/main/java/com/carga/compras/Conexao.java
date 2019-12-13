package com.carga.compras;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Conexao {

	private static Logger logger = LoggerFactory.getLogger(Conexao.class);

	private final Properties dbProps = new Properties();

	protected void dbInit(File path) {
		logger.debug("Verificando banco de dados...");
		dbProps.clear();

		try {

			dbProps.load(new FileInputStream(path));
			Class.forName(dbProps.getProperty("db.driver"));

		} catch (IOException | ClassNotFoundException e) {
			throw new IllegalArgumentException("Erro ao carregar configurações de banco.", e);
		}
	}

	public Connection connect() throws SQLException {
		Carga carga = new Carga();
		dbInit(carga.getFile(Carga.getParams().get("-d")));
		return DriverManager.getConnection(dbProps.getProperty("db.url"), dbProps.getProperty("db.user"),
				dbProps.getProperty("db.pass"));
	}

	/*
	 * protected void listarPrimeiraCompra(List<PrimeiraCompra>
	 * registrosPrimeiraCompra) throws IOException {
	 * 
	 * String sql = getSql(); logger.trace("Tipo carga: {} => {}",sql);
	 * List<PrimeiraCompra> listPrimeiraCompra = new ArrayList<>();
	 * 
	 * try { Connection conn = connect();
	 * 
	 * ResultSet rs =
	 * conn.createStatement().executeQuery("SELECT * FROM compras.pc_carga"); while
	 * (rs.next()) {
	 * 
	 * PrimeiraCompra primeiraCompra = new PrimeiraCompra();
	 * 
	 * primeiraCompra.setCpf(rs.getString(0));
	 * primeiraCompra.setData_proposta(rs.getDate(1));
	 * primeiraCompra.setProposta_cartao(rs.getInt(2));
	 * primeiraCompra.setCod_bandeira(rs.getInt(4));
	 * primeiraCompra.setCod_sit_proposta(rs.getInt(7));
	 * primeiraCompra.setSituacao_proposta(rs.getString(8));
	 * primeiraCompra.setResultado(rs.getString(9));
	 * primeiraCompra.setOrigem_azul(rs.getInt(11));
	 * primeiraCompra.setProposta_azul(rs.getInt(12));
	 * listPrimeiraCompra.add(primeiraCompra);
	 * 
	 * System.out.println("teste" + primeiraCompra.toString()); }
	 * 
	 * rs.close();
	 * 
	 * } catch (SQLException e) { throw new
	 * IOException("Erro ao buscar registros na base de dados.", e); }
	 * 
	 * }
	 */

	/*
	 * private void primeiraCompraInteracao() {
	 * 
	 * Hashtable<Object, Object> registros = null; for (int c = 0; c <
	 * registros.size(); c++) {
	 * 
	 * // PrimeiraCompra info = registros.get(c); // LOGGER.info("line: {}", info);
	 * 
	 * // boolean cargaOk = (info); // if (!cargaOk) { // erroList.add(info); }
	 * logger.info(""); }
	 */

//	protected void listarSegundaCompra(List<SegundaCompra> registrosSegundaCompra) throws IOException {
//
//		String sql2 = getSql2();
//		logger.trace("Tipo carga: {} => {}", sql2);
//		List<SegundaCompra> listSegundaCompra = new ArrayList<>();
//
//		try {
//			Connection conn = connect();
//
//			ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM compras.sc_carga");
//			while (rs.next()) {
//
//				SegundaCompra segundaCompra = new SegundaCompra();
//
//				segundaCompra.setRegistro(rs.getInt(0));
//				segundaCompra.setData_hora(rs.getDate(2));
//				segundaCompra.setAutorizacao_valor(rs.getDouble(8));
//				segundaCompra.setAutorizacao_parcelas(rs.getInt(9));
//				segundaCompra.setOrigem(rs.getInt(10));
//				segundaCompra.setProposta(rs.getInt(11));
//				segundaCompra.setApolice(rs.getInt(12));
//				segundaCompra.setPayware_retorno_codigo(rs.getInt(13));
//				segundaCompra.setPayware_retorno_descricao(rs.getString(14));
//				segundaCompra.setCsu_statusAprovacaoRejeicao(rs.getString(15));
//				listSegundaCompra.add(segundaCompra);
//
//				System.out.println("teste" + segundaCompra.toString());
//			}
//
//			rs.close();
//
//		} catch (SQLException e) {
//			throw new IOException("Erro ao buscar registros na base de dados.", e);
//		}
//
//	}

	private String getSql() {

		String sql = "INSERT INTO log_porto_primeiracompra (cpf,data_proposta,proposta_cartao,cod_bandeira,"
				+ "cod_sit_proposta,situacao_proposta,resultado,origem_azul,proposta_azul) "

				+ "VALUES (?,?,?,?,?,?,?,?,?);";

		return sql;
	}
	
	
	private String getSql2() {

		String sql2 = "INSERT INTO log_porto_segundacompra (registro,data_hora,autorizacao_valor,autorizacao_parcelas,"
				+ "origem,proposta,apolice,payware_retorno_codigo,payware_retorno_descricao,csu_statusAprovacaoRejeicao) "

				+ "VALUES (?,?,?,?,?,?,?,?,?,?);";

		return sql2;
	}


	public void gravaPrimeiraCompra(List<PrimeiraCompra> listPrimeiraCompra) {
		try (Connection conn = connect()) {

			PreparedStatement stmt = conn.prepareStatement(getSql());
			for (PrimeiraCompra primeiraCompra : listPrimeiraCompra) {
				logger.debug("classe", primeiraCompra.getData_proposta().getTime());
				logger.debug("classe", primeiraCompra.getData_proposta());

				java.sql.Timestamp dataSql = new java.sql.Timestamp(primeiraCompra.getData_proposta().getTime());

				logger.debug("timestamp", dataSql);

				stmt.setString(1, primeiraCompra.getCpf());
				stmt.setTimestamp(2, dataSql);
				stmt.setString(3, primeiraCompra.getProposta_cartao());
				stmt.setInt(4, primeiraCompra.getCod_bandeira());
				stmt.setInt(5, primeiraCompra.getCod_sit_proposta());
				stmt.setString(6, primeiraCompra.getSituacao_proposta());
				stmt.setString(7, primeiraCompra.getResultado());
				stmt.setInt(8, primeiraCompra.getOrigem_azul());
				stmt.setInt(9, primeiraCompra.getProposta_azul());
				stmt.executeUpdate();

			}
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	public void gravaSegundaCompra(List<SegundaCompra> listSegundaCompra) {
		try (Connection conn = connect()) {

			PreparedStatement stmt = conn.prepareStatement(getSql2());
			for (SegundaCompra segundaCompra : listSegundaCompra) {
				logger.debug("classe", segundaCompra.getData_hora().getTime());
				logger.debug("classe", segundaCompra.getData_hora());

				java.sql.Timestamp dataSql2 = new java.sql.Timestamp(segundaCompra.getData_hora().getTime());

				logger.debug("timestamp", dataSql2);

				stmt.setInt(1, segundaCompra.getRegistro());
				stmt.setTimestamp(2, dataSql2);
				stmt.setDouble(3, segundaCompra.getAutorizacao_valor());
				stmt.setInt(4, segundaCompra.getAutorizacao_parcelas());
				stmt.setString(5, segundaCompra.getOrigem());
				stmt.setString(6, segundaCompra.getProposta());
				stmt.setString(7, segundaCompra.getApolice());
				stmt.setInt(8, segundaCompra.getPayware_retorno_codigo());
				stmt.setString(9, segundaCompra.getPayware_retorno_descricao());
				stmt.setString(10, segundaCompra.getCsu_statusAprovacaoRejeicao());
				stmt.executeUpdate();

			}
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
