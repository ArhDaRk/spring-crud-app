import userDAO.UserDAO;
import userDAO.UserDAOImp;
import model.User;

public class main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAOImp();
        userDAO.addUser(new User("tre","bu","Y"));
    }
}
