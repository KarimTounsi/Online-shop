package pl.coderslab.project.register;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import pl.coderslab.project.test.DefaultRegistrationService;
import pl.coderslab.project.test.RegisterUserRequest;
import pl.coderslab.project.test.RegisterUserResponse;
import pl.coderslab.project.user.User;
import pl.coderslab.project.user.UserRepository;

import java.util.Random;

@DisplayName("Units tests for DefaultRegistrationService")
class DefaultRegistrationServiceTest {

    private UserRepository userRepository;
    private DefaultRegistrationService service;

    @BeforeEach
    public void prepare() {
        userRepository = Mockito.mock(UserRepository.class);
        service = new DefaultRegistrationService(userRepository);
    }

    @Nested
    @DisplayName("Units tests for DefaultRegistrationService::registerUser")
    class RegisterUser {

        @Test
        @DisplayName("Response should not be null")
        public void responseShouldNotBeNull() {
            RegisterUserRequest request = new RegisterUserRequest();
            RegisterUserResponse response = service.registerUser(request);

            Assertions.assertThat(response).isNotNull();
        }

        @Test
        @DisplayName("Should use UserRepository")
        public void shouldUseUserRepository() {
            Mockito.when(userRepository.save(ArgumentMatchers.any(User.class)))
                    .thenReturn(new User());

            RegisterUserRequest request = new RegisterUserRequest();
            RegisterUserResponse response = service.registerUser(request);

            Mockito.verify(userRepository, Mockito.times(1))
                    .save(ArgumentMatchers.any(User.class));
        }

        @Test
        @DisplayName("Should use username and password from request")
        public void shouldUseUsernameAndPasswordFromRequest() {
            ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
            Mockito.when(userRepository.save(userCaptor.capture())).thenReturn(new User());

            RegisterUserRequest request = new RegisterUserRequest("joesmith", "s3cr3t");
            RegisterUserResponse response = service.registerUser(request);

            User user = userCaptor.getValue();
            Assertions.assertThat(user).isNotNull();

            Assertions.assertThat(user)
                    .extracting(User::getUsername)
                        .isNotNull()
                        .isEqualTo(request.getUsername());

            Assertions.assertThat(user)
                    .extracting(User::getPassword)
                        .isNotNull()
                        .isEqualTo(request.getPassword());
        }

        @Test
        @DisplayName("Response should contains registered User id")
        public void responseShouldContainsRegisteredUserId() {
            Long randomId = new Random().nextLong();
            Mockito.when(userRepository.save(ArgumentMatchers.any(User.class)))
                    .then(invocation -> {
                        User userArg = invocation.getArgument(0, User.class);
                        userArg.setId(randomId);
                        return userArg;
                    });

            RegisterUserRequest request = new RegisterUserRequest("joesmith", "s3cr3t");
            RegisterUserResponse response = service.registerUser(request);

            Assertions.assertThat(response.getUserId())
                    .isNotNull()
                    .isEqualTo(randomId);

        }

        @Test
        @DisplayName("Should throw RuntimeException when username already exists")
        public void shouldThrowRuntimeExceptionWhenUsernameAlreadyExists() {
            Mockito.when(userRepository.existsByUsername("joesmith"))
                    .thenReturn(true);

            RegisterUserRequest request = new RegisterUserRequest("joesmith", "s3cr3t");

            Assertions.assertThatThrownBy(() -> service.registerUser(request))
                    .hasNoCause()
                    .hasMessageContaining("joesmith")
                    .hasMessageContaining("already exists")
                    .isInstanceOf(RuntimeException.class);
        }

    }








}