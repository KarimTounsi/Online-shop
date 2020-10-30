package pl.coderslab.project.address.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.project.address.entity.Address;


public interface AddressRepository extends JpaRepository<Address, Long> {


}
