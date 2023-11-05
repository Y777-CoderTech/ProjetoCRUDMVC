package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseConnection;
import models.Cliente;

public class ClienteDAO {
	private Connection connection;

	public ClienteDAO() throws SQLException {
		connection = DatabaseConnection.createConnection();
	}

	public void closeConnection() {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void createCliente(Cliente cliente) {
		String sql = "INSERT INTO cliente (nomeCliente,cpfCliente,rgCliente,telefoneCliente) VALUES (?,?,?,?)";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getRg());
			stmt.setString(4, cliente.getTelefone());

			

			stmt.executeUpdate();

			System.out.println("Cliente criado com sucesso!");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Cliente findCliente(int id) {
		Cliente cliente = null;
		String sql = "SELECT * FROM cliente WHERE idCliente=?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setInt(1, id);
			ResultSet r = stmt.executeQuery();

			if (r.next()) {
				cliente = new Cliente();
				cliente.setId(r.getInt("idCliente"));
				cliente.setNome(r.getString("nomeCliente"));
				cliente.setCpf(r.getString("cpfCliente"));
				cliente.setRg(r.getString("rgCliente"));
				cliente.setTelefone(r.getString("telefoneCliente"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cliente;
	}

	public List<Cliente> getClientes() {

		String sql = "SELECT * FROM cliente";

		List<Cliente> clientes = new ArrayList<Cliente>();

		ResultSet r = null;

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			r = stmt.executeQuery();

			while (r.next()) {
				Cliente cliente = new Cliente();
				cliente = new Cliente();
				cliente.setId(r.getInt("idCliente"));
				cliente.setNome(r.getString("nomeCliente"));
				cliente.setCpf(r.getString("cpfCliente"));
				cliente.setRg(r.getString("rgCliente"));
				cliente.setTelefone(r.getString("telefoneCliente"));

				clientes.add(cliente);
			}
		} catch (Exception e) {

			e.printStackTrace();

		}
		return clientes;

	}

	public void updateCliente(Cliente cliente) {

		String sql = "UPDATE cliente SET nomeCliente = ?,cpfCliente = ?, rgCliente = ?, telefoneCliente = ? WHERE idCliente = ?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getRg());
			stmt.setString(4, cliente.getTelefone());
			stmt.setInt(5, cliente.getId());

			stmt.executeUpdate();

			System.out.println("Cliente atualizado com sucesso!");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void deleteClient(int id) {
		String sql = "DELETE FROM cliente WHERE idCliente = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setInt(1, id);
			stmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
