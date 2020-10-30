package pl.coderslab.project.user.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.project.user.entity.User;
import pl.coderslab.project.user.repository.UserRepository;

import javax.transaction.Transactional;


@AllArgsConstructor
@Service
@Transactional
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public User findByUserName(String name) {
        return userRepository.findUserByUsername(name);
    }


    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(true);
        user.getRoles().add("ROLE_CLIENT");
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        user.setActive(true);
        user.getRoles().add("ROLE_CLIENT");
        userRepository.save(user);
    }

}
