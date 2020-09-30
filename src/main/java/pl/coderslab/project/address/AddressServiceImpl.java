package pl.coderslab.project.address;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {

    AddressRepository addressRepository;


    @Override
    public void saveAddress(Address address) {
        addressRepository.save(address);
    }
}
