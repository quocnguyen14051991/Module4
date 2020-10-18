package com.quocnguyen.service.checkloginimpl;

import com.quocnguyen.model.Login;
import com.quocnguyen.model.User;
import com.quocnguyen.repository.UserDAO;
import com.quocnguyen.service.CheckLogin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckLoginImpl implements CheckLogin {
    @Override
    public User checkLoginUser(Login login) {
        List<User> userList=UserDAO.users;
        for (User user:userList) {
            if(user.getAccount().equals(login.getAccount())&&user.getPassword().equals(login.getPassword()))
            {
                return user;
            }
        }
        return null;
    }
}
