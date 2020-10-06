package pl.coderslab.project.user;

public interface UserService {

    User findByUserName(String firstName);

    void saveUser(User user);

    void updateUser(User user);


//   RegisterUserResponse RegisterUser(RegisterUserRequest request);


}
