package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/blvcrud?useTimezone=true&serverTimezone=UTC";

	private String user = "root";
	private String password = "banco397350";

	private Connection conectar() {
		Connection con = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	
	
	// CREATE
	public void createCliente(Cliente cliente) {
		String sql = "insert into clientes (nome, email, senha) values (?, ?, ?)";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, cliente.getNome());
			pst.setString(2, cliente.getEmail());
			pst.setString(3, cliente.getSenha());

			pst.executeUpdate();
			System.out.println("Cliente Cadastrado com Sucesso!");
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	
	// READ
	public ArrayList<Cliente> readClientes() {

		ArrayList<Cliente> clientes = new ArrayList();

		String sql = "select * from clientes order by nome";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String idcli = rs.getString(1);
				String nome = rs.getString(2);
				String email = rs.getString(3);
				String senha = rs.getString(4);

				clientes.add(new Cliente(idcli, nome, email, senha));
			}
			con.close();
			return clientes;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}
	
	
	//UPDATE
	public void atualizarContato (Cliente cliente) {
		String sql = "select * from clientes where idcli = ?";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, cliente.getIdcli());
			ResultSet rs = pst.executeQuery();

			while(rs.next()) {
				cliente.setIdcli(rs.getString(1));
				cliente.setNome(rs.getString(2));
				cliente.setEmail(rs.getString(3));
				cliente.setSenha(rs.getString(4));
			}
			con.close();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	//UPDATE CONTINUACAO - ALTERANDO NO BANCO
	public void updateCliente(Cliente cliente) {
		String sql = "update clientes set nome=?, email=?, senha=? where idcli=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, cliente.getNome());
			pst.setString(2, cliente.getEmail());
			pst.setString(3, cliente.getSenha());
			pst.setString(4, cliente.getIdcli());
			
			pst.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//DELETE 
	public void deletarCliente(Cliente cliente) {
	String sql = "delete from clientes where idcli = ?";
	try {
		Connection con = conectar();
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, cliente.getIdcli());
		pst.executeUpdate();
		con.close();
		
	} catch (Exception e) {
		System.out.println(e);
	}
	}
	
	
	

}
