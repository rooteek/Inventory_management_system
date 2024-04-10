
package Com.Service;

import Com.Repository.loginRepository;
import java.sql.SQLException;

public class loginService {
     loginRepository repo = new loginRepository();
    public int loginValidation(String user,String pass) throws SQLException,ClassNotFoundException{
        return repo.loginValidation(user, pass);
    }
}
