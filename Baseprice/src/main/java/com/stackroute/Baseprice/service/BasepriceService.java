package com.stackroute.Baseprice.service;

import com.stackroute.Baseprice.domain.Baseprice;

import java.util.List;

public interface BasepriceService
{


        public Baseprice saveBaseprice(Baseprice baseprice);

        public List<Baseprice> getAllBaseprice();

        public boolean deleteBaseprice(int id) ;

        public Baseprice updateBaseprice(Baseprice baseprice, int id);

    }

