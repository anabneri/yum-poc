package br.com.poc.yum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.poc.yum.ConnectionFactory;
import br.com.poc.yum.modelos.Computador;

public class ComputadorDao {
	private Connection conexao;

	public ComputadorDao() throws ClassNotFoundException {
		this.conexao = new ConnectionFactory().getConnection();
	}
	
	public List<Computador> listaComputadores() throws SQLException{
		List<Computador> computadores = new ArrayList<Computador>();
		String sql = "select * from computadores_gerais where cod_cliente = 6;";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			computadores.add(adicionaComputador(rs));
		}
		return computadores;
	}

	private Computador adicionaComputador(ResultSet rs) throws SQLException {

		Computador pc = new Computador();
		pc.setIdComputador(rs.getInt("id_computador"));
		pc.setNumeroIp(rs.getString("numero_ip"));
		pc.setNome(rs.getString("nome_computador"));
		pc.setEnderecoMac(rs.getString("endereco_mac"));
		pc.setTipoProcessador(rs.getString("tipo_processador"));
		pc.setSistemaOperacional(rs.getString("tipo_sistema_operacional"));
		pc.setTamanhoHd(rs.getString("tamanho_hd"));

		return pc;

	}
}
