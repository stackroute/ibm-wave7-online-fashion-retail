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
    public Optional<Manufacture> getManufacture(int id) {
//        Designer designer = designerRepository.findById(id);
        return manufactureRepository.findById(id);
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
        String name = user1.get().getName();
        String email=user1.get().getEmail();
        String specifications= user1.get().getSpecifications();

        manufacture.setId(id);
        manufacture.setName(name);
        manufacture.setEmail(email);
        manufacture.setCity(manufacture.getCity());
        manufacture.setSpecifications(specifications);
        manufacture.setContact_number(manufacture.getContact_number());

        Manufacture savedManufacture = manufactureRepository.save(manufacture);
        return savedManufacture;
    }

}
