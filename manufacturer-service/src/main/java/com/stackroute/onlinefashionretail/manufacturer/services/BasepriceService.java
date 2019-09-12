package com.stackroute.onlinefashionretail.manufacturer.services;

import com.stackroute.onlinefashionretail.manufacturer.domain.BasePrice;

import java.util.List;

public interface BasepriceService
{


        public BasePrice saveBaseprice(BasePrice baseprice);

        public List<BasePrice> getAllBaseprice();

        public boolean deleteBaseprice(String id) ;

        public BasePrice updateBaseprice(BasePrice baseprice, String id);

    }

