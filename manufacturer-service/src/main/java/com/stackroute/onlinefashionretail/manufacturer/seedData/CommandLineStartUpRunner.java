package com.stackroute.onlinefashionretail.manufacturer.seedData;


import com.stackroute.onlinefashionretail.manufacturer.domain.BasePrice;
import com.stackroute.onlinefashionretail.manufacturer.domain.Designer;
import com.stackroute.onlinefashionretail.manufacturer.domain.Manufacturer;
import com.stackroute.onlinefashionretail.manufacturer.domain.ManufacturerOrder;
import com.stackroute.onlinefashionretail.manufacturer.services.BasepriceService;
import com.stackroute.onlinefashionretail.manufacturer.services.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
        Designer designer1 = new Designer("1",
                "Sabyasachi",
                "Kolkata",
                4.7f,
                "designs@sabyasachi.com",
                9847287456L,
                new ArrayList<>());

        Designer designer2 = new Designer("2",
                "Manish Malhotra",
                "Delhi",
                4.6f,
                "designs@manishmalhotra.com",
                9847132560L,
                new ArrayList<>());

        ManufacturerOrder manufacturerOrder1 = new ManufacturerOrder("1","","Sabyasachi","imageLehenga",50,"in-progress");
        ManufacturerOrder manufacturerOrder2 = new ManufacturerOrder("2","","Sabyasachi","imageShirt",200,"in-progress");
        ManufacturerOrder manufacturerOrder3 = new ManufacturerOrder("3","","Manish Malhotra","imageEarrings",100,"in-progress");
        ManufacturerOrder manufacturerOrder4 = new ManufacturerOrder("4","","Manish Malhotra","imageDress",50,"in-progress");

        Manufacturer manufacturer1 = new Manufacturer("1","RJ Enterprise","rj@gmail.com","bangalore","tailor",4.5f,9836199304L,List.of(manufacturerOrder1,manufacturerOrder3));
        Manufacturer manufacturer2 = new Manufacturer("2","KSV Enterprise","ksv@gmail.com","delhi","tailor",3.5f,9836123304L, List.of(manufacturerOrder2,manufacturerOrder4));
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
