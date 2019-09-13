package com.stackroute.onlinefashionretail.manufacturer.services;

import com.stackroute.onlinefashionretail.manufacturer.domain.BasePrice;
import com.stackroute.onlinefashionretail.manufacturer.repository.BasepriceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BasepriceServiceImpl implements BasepriceService
{
    private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    BasepriceRepository basepriceRepository;

        @Autowired
        public BasepriceServiceImpl(BasepriceRepository basepriceRepository)
        {
            this.basepriceRepository = basepriceRepository;
        }

        @Override
        public BasePrice saveBaseprice(BasePrice baseprice) {
            logger.info("Inside saveBase in BasePriceImpl");
            BasePrice savedBaseprice = basepriceRepository.save(baseprice);
            return savedBaseprice;
        }

    @Override
    public List<BasePrice> getAllBaseprice() {
        logger.info("Inside getAllBasePrice in BasePriceImpl");
            return basepriceRepository.findAll();
    }

    @Override
    public boolean deleteBaseprice(String id ){
      try {
          logger.info("Inside deleteBaseprice in BasePriceImpl");
          basepriceRepository.deleteById(id);
          return true;
      }
      catch (Exception exception) {
          logger.info("Inside deleteBaseprice  catch block in BasePriceImpl");
                return false;
      }
        }
        @Override
        public BasePrice updateBaseprice(BasePrice baseprice, String id)
        {
            logger.info("Inside updateBaseprice  catch block in BasePriceImpl");
            Optional<BasePrice> user1 = basepriceRepository.findById(id);
            baseprice.setId(id);
            baseprice.setName(baseprice.getName());
            baseprice.setPrice(baseprice.getPrice());
            BasePrice savedBaseprice = basepriceRepository.save(baseprice);
            return savedBaseprice;
        }

    }


