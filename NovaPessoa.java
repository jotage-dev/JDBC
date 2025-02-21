package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class NovaPessoa {
public static void main(String[] args)throws SQLException {
	Scanner entrada = new Scanner(System.in);
	
	System.out.println("informe o nome: ");
	String nome = entrada.nextLine();
	System.out.println(nome);
	
	Connection conexao = FabricaConexao.getConexao();
	
	String sql = "INSERT INTO PESSOAS"
			+ " (nome) "
			+ "VALUES (?)";
	PreparedStatement stmt = conexao.prepareStatement(sql);
	stmt.setString(1, nome);
	stmt.execute();
	System.out.println(nome+" incluida com sucesso!");
	entrada.close();
}
}
