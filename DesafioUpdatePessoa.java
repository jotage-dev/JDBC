package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DesafioUpdatePessoa {
public static void main(String[] args) throws SQLException {

	
	
	Scanner entrada = new Scanner(System.in);
	
	System.out.println("Informe o codigo da pessoa ");
	int codigo = entrada.nextInt();
	
	String sql1 = "SELECT codigo, nome FROM pessoas WHERE codigo = ?";
	Connection conexao = FabricaConexao.getConexao();
	PreparedStatement stmt = conexao.prepareStatement(sql1);
	stmt.setInt(1, codigo);
	ResultSet r = stmt.executeQuery();
	if(r.next()) {
		Pessoa p = new Pessoa(r.getInt(1),r.getString(2));
		System.out.println("O nome atual é "+ p.getNome());
		entrada.nextLine();
	}
	System.out.println("\ninforme o nome Atualizado da pessoa: ");
	String nomeAtualizado = entrada.nextLine();
	String sql = "UPDATE pessoas SET nome = (?) WHERE codigo = ?";
	PreparedStatement stmt1 = conexao.prepareStatement(sql);
	
	stmt1.setString(1, nomeAtualizado);
	stmt1.setInt(2, codigo);
	stmt1.execute();
	if(nomeAtualizado !=null) {
	System.out.println("Alteraçao concluida");
	}
	entrada.close();
	
}
}
