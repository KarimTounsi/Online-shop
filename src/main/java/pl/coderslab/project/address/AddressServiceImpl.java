package pl.coderslab.project.address;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
