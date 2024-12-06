package Model.BO;

import Model.DAO.ForgotPasswordRepository;

public class ForgotPasswordService {
	private ForgotPasswordRepository forgotPasswordRepository = new ForgotPasswordRepository();
	
	public void Edit_Pass(String pass, String mail) {
		forgotPasswordRepository.Edit_Pass(pass, mail);
	}
	
	
}
