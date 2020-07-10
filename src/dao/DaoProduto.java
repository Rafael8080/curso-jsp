package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Produto;
import connection.SingleConnection;

public class DaoProduto {
	
	private Connection connection;
	
	public DaoProduto() {
		connection = SingleConnection.getConnection();
	}
	
	public void salvar (Produto produto) {
		String sql = "insert into produto (nome, quantidade, valor) VALUES (?, ?, ?)";
		try {		
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, produto.getNome());
			insert.setDouble(2, produto.getQuantidade());
			insert.setDouble(3, produto.getValor());
			insert.execute();
			connection.commit();
		}catch(Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	public List<Produto> listar() throws Exception{
		
		List<Produto> listar = new ArrayList<Produto>();
		
		String sql = "select * from produto";
		
		
			PreparedStatement select = connection.prepareStatement(sql);
			ResultSet resultset = select.executeQuery();
			
			while(resultset.next()) {
				Produto produto = new Produto();
				produto.setId(resultset.getLong("id"));
				produto.setNome(resultset.getString("nome"));
				produto.setQuantidade(resultset.getDouble("quantidade"));
				produto.setValor(resultset.getDouble("valor"));
				listar.add(produto);
			}
			
			return listar;
		
	}


	
}
