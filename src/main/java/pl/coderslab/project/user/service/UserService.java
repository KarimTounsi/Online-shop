package pl.coderslab.project.user.service;

import pl.coderslab.project.user.entity.User;

public interface UserService {

    User findByUserName(String firstName);

    void saveUser(User user);

    void updateUser(User user);


//   RegisterUserResponse RegisterUser(RegisterUserRequest request);


}
