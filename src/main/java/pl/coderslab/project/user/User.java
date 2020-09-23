package pl.coderslab.project.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.context.annotation.Role;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "user_id")
        private Long id;

        @Column(name = "email", unique = true, nullable = false)
        @Email(message = "*Podaj prawidłowy adres e-mail")
        @NotEmpty(message = "*Proszę podać e-mail")
        private String email;

        @Column(name = "password", nullable = false)
        @Length(min = 5, message = "*Twoje hasło musi mieć co najmniej 5 znaków")
        @NotEmpty(message = "*Proszę podać swoje hasło")
        private String password;

        @Column(name = "username", nullable = false, unique = true)
        @Length(min = 5, message = "*Twoja nazwa użytkownika musi mieć co najmniej 5 znaków")
        @NotEmpty(message = "*Proszę podać swoje imię i nazwisko")
        private String username;

        @Column(name = "name")
        @NotEmpty(message = "*Proszę podać swoje imię i nazwisko")
        private String firstName;

        @Column(name = "last_name")
        @NotEmpty(message = "*Proszę podać swoje nazwisko")
        private String lastName;

        @Column(name = "active", nullable = false)
        private boolean active;

        @CollectionTable(name = "user_roles")
        @ElementCollection
        private Set<String> roles = new HashSet<>();

}
