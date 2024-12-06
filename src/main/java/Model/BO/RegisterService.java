package Model.BO;

import java.sql.Connection;

import Model.Bean.Users;
import Model.DAO.RegisterRepository;

public class RegisterService {
	private RegisterRepository registerRepository = new RegisterRepository();
	public boolean InsertAccount(Connection conn, Users users) {
		return registerRepository.InsertAccount(conn, users);
	}
	public boolean checkUser(String username) {
		return registerRepository.checkUser(username);
	}
}
