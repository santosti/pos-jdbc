package pos_java_jdbc.pos_java_jdbc;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import dao.UserPosDao;
import model.UserPosJava;

public class TesteBancoJDBC {

	@Test
	public void initBanco() {
		UserPosDao userPosDao = new UserPosDao();
		UserPosJava userPosJava = new UserPosJava();

		userPosJava.setId(6L);
		userPosJava.setNome("teste3");
		userPosJava.setEmail("teste3@gmail.com");

		userPosDao.salvar(userPosJava);
	}

	@Test
	public void initListar() {
		UserPosDao dao = new UserPosDao();

		try {
			List<UserPosJava> list = dao.listar();

			for (UserPosJava userPosJava : list) {
				System.out.println(userPosJava);
				System.out.println("-------------------------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void initBuscar() {
		UserPosDao dao = new UserPosDao();
		try {
			UserPosJava userPosJava = dao.buscar(3L);
			System.out.println(userPosJava);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void initAtualizar() {
		try {
			UserPosDao dao = new UserPosDao();
			
			UserPosJava objetoBanco = dao.buscar(3L);
			objetoBanco.setNome("Teste de nome atualizado");
			dao.atualizar(objetoBanco);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
