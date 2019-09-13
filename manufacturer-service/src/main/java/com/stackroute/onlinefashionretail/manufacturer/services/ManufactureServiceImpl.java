package com.stackroute.onlinefashionretail.manufacturer.services;

import com.stackroute.onlinefashionretail.manufacturer.domain.Manufacturer;
import com.stackroute.onlinefashionretail.manufacturer.repository.ManufactureRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManufactureServiceImpl implements ManufactureService {
    private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    ManufactureRepository manufactureRepository;

    @Autowired
    public ManufactureServiceImpl(ManufactureRepository manufactureRepository)
    {
        this.manufactureRepository = manufactureRepository;
    }

    @Override
    public Manufacturer saveManufacture(Manufacturer manufacturer) {
        Manufacturer savedManufacturer = manufactureRepository.save(manufacturer);
        return savedManufacturer;
    }

    @Override
    public Optional<Manufacturer> getManufacture(String id) {
        logger.info("inside getManufacturer in ManufactureServiceimpl");
        return manufactureRepository.findById(id);
    }

    @Override
    public List<Manufacturer> getAllManufactures() {
        logger.info("inside getAllManufacturer in ManufactureServiceimpl");
        return manufactureRepository.findAll();
    }

    @Override
    public boolean deleteManufacture(String id ){
        try {
            logger.info("inside deleteManufacturer try block in ManufactureServiceimpl");
            manufactureRepository.deleteById(id);
            return true;
        }
        catch (Exception exception)
        {
            logger.info("inside deleteManufacturer in ManufactureServiceimpl");
            return false;
        }
    }
    @Override
    public Manufacturer updateManufacture(Manufacturer manufacturer, String id)
    {
        logger.info("inside updateManufacturer in ManufactureServiceimpl");
        Optional<Manufacturer> user1 = manufactureRepository.findById(id);
        String name = user1.get().getName();
        String email=user1.get().getEmail();
        String specifications= user1.get().getSpecifications();

        manufacturer.setId(id);
        manufacturer.setName(name);
        manufacturer.setEmail(email);
        manufacturer.setCity(manufacturer.getCity());
        manufacturer.setSpecifications(specifications);
        manufacturer.setContact_number(manufacturer.getContact_number());
        Manufacturer savedManufacturer = manufactureRepository.save(manufacturer);
        return savedManufacturer;
    }

}
