package jdbc;

public class DAOTeste {
public static void main(String[] args) {
	DAO dao = new DAO();
	String sql = "INSERT INTO pessoas (nome) VALUES (?) ";
	dao.incluir(sql,"João");
	dao.incluir(sql,"Ana");
	dao.incluir(sql,"Felipe");
	dao.incluir(sql,"Djalma");
}
}
