package pl.coderslab.project.test;


import lombok.RequiredArgsConstructor;
import pl.coderslab.project.user.entity.User;
import pl.coderslab.project.user.repository.UserRepository;

@RequiredArgsConstructor
public class DefaultRegistrationService implements RegistrationService {

    private final UserRepository userRepository;

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest request) {
        validate(request);
        User user = createUser(request);
        return validResponse(user);
    }

    private void validate(RegisterUserRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new IllegalStateException("Username with " + request.getUsername() + " already exists");
        }
    }

    private RegisterUserResponse validResponse(User user) {
        return new RegisterUserResponse(user.getId());
    }

    private User createUser(RegisterUserRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        userRepository.save(user);
        return user;
    }
}
