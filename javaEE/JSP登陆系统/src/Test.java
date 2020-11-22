import Dao.T_userDao;
import vo.T_user;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T_userDao dao = new T_userDao();
		T_user user = new T_user();
		//user.setUserid(12343455);
		user = dao.selectById(user);
		System.out.println(user);
	}

}
