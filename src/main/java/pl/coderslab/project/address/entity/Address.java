package pl.coderslab.project.address.entity;


import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Entity
@Table(name = "Addresses")
@Transactional
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;

    public Address() {
    }

    @Email(message = "*Podaj prawidłowy adres e-mail")
    @NotEmpty(message = "*Proszę podać e-mail")
    private String email;
    @NotEmpty(message = "*Proszę podać swoje imię")
    private String firstName;
    @NotEmpty(message = "*Proszę podać swoje nazwisko")
    private String lastName;
    @NotEmpty(message = "*Proszę podać adres")
    private String streetHome;
    @NotEmpty(message = "*Proszę podać kraj")
    private String country;
    @NotEmpty(message = "*Proszę podać kod pocztowy")
    private String postcode;
    @NotEmpty(message = "*Proszę podać miasto")
    private String city;
    @NotEmpty(message = "*Proszę podać województwo")
    private String voivodeship;
    @AssertTrue
    private boolean terms;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetHome() {
        return streetHome;
    }

    public void setStreetHome(String streetHome) {
        this.streetHome = streetHome;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getVoivodeship() {
        return voivodeship;
    }

    public void setVoivodeship(String voivodeship) {
        this.voivodeship = voivodeship;
    }

    public boolean isTerms() {
        return terms;
    }

    public void setTerms(boolean terms) {
        this.terms = terms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id.equals(address.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
