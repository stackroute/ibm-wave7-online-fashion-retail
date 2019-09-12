package com.stackroute.manufacture.seedData;


import com.stackroute.manufacture.domain.BasePrice;
import com.stackroute.manufacture.domain.Manufacturer;
import com.stackroute.manufacture.services.BasepriceService;
import com.stackroute.manufacture.services.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CommandLineStartUpRunner implements CommandLineRunner {
    private ManufactureService manufactureService;
    private BasepriceService basepriceService;

    /**
     * Use constructor based DI to inject TrackService here
     */
    @Autowired
    public CommandLineStartUpRunner(ManufactureService manufactureService, BasepriceService basepriceService) {
        this.manufactureService = manufactureService;
        this.basepriceService = basepriceService;
    }


    @Override
    public void run(String... args) throws Exception {
        /* *Pre-fill the database whenever application starts*/
        Manufacturer manufacturer1 = new Manufacturer("1","RJ Enterprise","rj@gmail.com","bangalore","tailor",4.5f,9836199304L,new ArrayList<>());
        Manufacturer manufacturer2 = new Manufacturer("2","KSV Enterprise","ksv@gmail.com","delhi","tailor",3.5f,9836123304L,new ArrayList<>());
        Manufacturer manufacturer3 = new Manufacturer("3","LM Footwear Works","lm34@gmail.com","bangalore","shoemaker",4f,9830299304L,new ArrayList<>());

        BasePrice basePrice1 = new BasePrice("1","Lehenga",250f);
        BasePrice basePrice2 = new BasePrice("2","Shirt",150f);
        BasePrice basePrice3 = new BasePrice("3","Skirt",190f);

        try {
           manufactureService.saveManufacture(manufacturer1);
            manufactureService.saveManufacture(manufacturer2);
            manufactureService.saveManufacture(manufacturer3);
            System.out.println("saved manufacturer seed data");
            basepriceService.saveBaseprice(basePrice1);
            basepriceService.saveBaseprice(basePrice2);
            basepriceService.saveBaseprice(basePrice3);
            System.out.println("saved base price seed data");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
