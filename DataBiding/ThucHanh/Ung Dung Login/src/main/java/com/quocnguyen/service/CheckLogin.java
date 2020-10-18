package com.quocnguyen.service;

import com.quocnguyen.model.Login;
import com.quocnguyen.model.User;

public interface CheckLogin {
   User checkLoginUser(Login login);
}
