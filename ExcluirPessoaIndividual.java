package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExcluirPessoaIndividual {
	public static void main(String[] args) throws SQLException {
		Connection conexao = FabricaConexao.getConexao();
		String sql = "SELECT * FROM pessoas";

		Statement stmt = conexao.createStatement();
		ResultSet resultado = stmt.executeQuery(sql);
		List<Pessoa> pessoas = new ArrayList<Pessoa>();

		while (resultado.next()) {
			int codigo = resultado.getInt("codigo");
			String nome = resultado.getString("nome");
			pessoas.add(new Pessoa(codigo, nome));
		}
		System.out.println("TABELA PESSOAS");
		for (Pessoa p : pessoas) {

			System.out.println("ID " + p.getCodigo() + "======> Nome: " + p.getNome());
		}
		Scanner entrada = new Scanner(System.in);

		System.out.println("informe o codigo da qual deseja excluir: ");
		int codigoRemover = entrada.nextInt();
		System.out.println(codigoRemover);

		String sql2 = "DELETE FROM pessoas WHERE codigo = ?";
		PreparedStatement stmt1 = conexao.prepareStatement(sql2);
		stmt1.setInt(1, codigoRemover);
		if (stmt1.executeUpdate() > 0) {
			System.out.println("Pessoa Removida com sucesso!");
		} else {
			System.out.println("Nada feito");
		}

		entrada.close();

		stmt.close();
		conexao.close();
	}
}
