package pl.coderslab.project.address.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.project.address.entity.Address;
import pl.coderslab.project.address.repository.AddressRepository;
import pl.coderslab.project.address.service.AddressService;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    AddressRepository addressRepository;


    @Override
    public void saveAddress(Address address) {
        addressRepository.save(address);
    }
}
