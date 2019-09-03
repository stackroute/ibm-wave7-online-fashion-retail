package com.stackroute.Baseprice.service;

import com.stackroute.Baseprice.domain.Baseprice;
import com.stackroute.Baseprice.repository.BasepriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BasepriceServiceImpl implements BasepriceService
{

    BasepriceRepository basepriceRepository;

        @Autowired
        public BasepriceServiceImpl(BasepriceRepository basepriceRepository)
        {
            this.basepriceRepository = basepriceRepository;
        }

        @Override
        public Baseprice saveBaseprice(Baseprice baseprice) {
            Baseprice savedBaseprice = basepriceRepository.save(baseprice);
            return savedBaseprice;
        }

    @Override
    public List<Baseprice> getAllBaseprice() {
        return basepriceRepository.findAll();
    }


        @Override
        public boolean deleteBaseprice(int id ){
            // Optional<User> user1 = userRepository.findById(id);

            try {
                basepriceRepository.deleteById(id);
                return true;
            }
            catch (Exception exception)
            {
                return false;
            }
        }
        @Override
        public Baseprice updateBaseprice(Baseprice baseprice, int id)
        {
            Optional<Baseprice> user1 = basepriceRepository.findById(id);

            baseprice.setId(id);
            baseprice.setName(baseprice.getName());
            baseprice.setPrice(baseprice.getPrice());


            Baseprice savedBaseprice = basepriceRepository.save(baseprice);
            return savedBaseprice;
        }

    }


