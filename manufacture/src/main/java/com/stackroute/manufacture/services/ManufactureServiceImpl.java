package com.stackroute.manufacture.services;

import com.stackroute.manufacture.domain.Manufacture;
import com.stackroute.manufacture.repository.ManufactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManufactureServiceImpl implements ManufactureService {
    ManufactureRepository manufactureRepository;

    @Autowired
    public ManufactureServiceImpl(ManufactureRepository manufactureRepository)
    {
        this.manufactureRepository = manufactureRepository;
    }

    @Override
    public Manufacture saveManufacture(Manufacture manufacture) {
        Manufacture savedManufacture = manufactureRepository.save(manufacture);
        return savedManufacture;
    }

    @Override
    public List<Manufacture> getAllManufactures() {
        return manufactureRepository.findAll();
    }

    @Override
    public boolean deleteManufacture(int id ){
      // Optional<User> user1 = userRepository.findById(id);

        try {
            manufactureRepository.deleteById(id);
            return true;
        }
        catch (Exception exception)
        {
            return false;
        }
    }
    @Override
    public Manufacture updateManufacture(Manufacture manufacture, int id)
    {
        Optional<Manufacture> user1 = manufactureRepository.findById(id);

        manufacture.setName(manufacture.getName());
        manufacture.setEmail(manufacture.getEmail());
        manufacture.setPrice(manufacture.getPrice());
        manufacture.setSpecifications(manufacture.getSpecifications());

        Manufacture savedManufacture = manufactureRepository.save(manufacture);
        return savedManufacture;
    }

}
