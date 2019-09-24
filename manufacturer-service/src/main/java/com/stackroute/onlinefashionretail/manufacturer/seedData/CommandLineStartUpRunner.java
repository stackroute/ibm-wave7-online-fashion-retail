package com.stackroute.onlinefashionretail.manufacturer.seedData;


import com.stackroute.onlinefashionretail.manufacturer.domain.BasePrice;
import com.stackroute.onlinefashionretail.manufacturer.domain.Designer;
import com.stackroute.onlinefashionretail.manufacturer.domain.Manufacturer;
import com.stackroute.onlinefashionretail.manufacturer.domain.ManufacturerOrder;
import com.stackroute.onlinefashionretail.manufacturer.services.BasepriceService;
import com.stackroute.onlinefashionretail.manufacturer.services.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class CommandLineStartUpRunner implements CommandLineRunner {
    private ManufactureService manufactureService;
    private BasepriceService basepriceService;

    /**
     * Use constructor based DI to inject TrackService here
     */
    @Autowired
    private KafkaTemplate<String, Manufacturer> kafkaTemplate;

    @Autowired
    public CommandLineStartUpRunner(ManufactureService manufactureService, BasepriceService basepriceService) {
        this.manufactureService = manufactureService;
        this.basepriceService = basepriceService;
    }


    @Override
    public void run(String... args) throws Exception {
        /* *Pre-fill the database whenever application starts*/
        Designer designer1 = new Designer("1",
                "Arpita",
                "Kolkata",
                4.7f,
                "arpi@gmail.com",
                9847287456L,
                new ArrayList<>());

        Designer designer2 = new Designer("2",
                "Suchita",
                "Delhi",
                4.6f,
                "suchita@gmail.com",
                9847132560L,
                new ArrayList<>());

        ManufacturerOrder manufacturerOrder1 = new ManufacturerOrder("1","","Arpita","imageLehenga.jpeg",50,"in-progress");
        ManufacturerOrder manufacturerOrder2 = new ManufacturerOrder("2","","Arpita","imageShirt.jpeg",200,"in-progress");
        ManufacturerOrder manufacturerOrder3 = new ManufacturerOrder("3","","Suchita","imageEarrings.jpeg",100,"in-progress");
        ManufacturerOrder manufacturerOrder4 = new ManufacturerOrder("4","","Suchita","imageDress.jpeg",50,"in-progress");
        BasePrice basePrice1 = new BasePrice("1","Lehenga",250f);
        BasePrice basePrice2 = new BasePrice("2","Shirt",150f);
        BasePrice basePrice3 = new BasePrice("3","Skirt",190f);
        BasePrice basePrice4 = new BasePrice("4","Lehenga",20f);
        BasePrice basePrice5 = new BasePrice("5","Shirt",170f);
        BasePrice basePrice6 = new BasePrice("6","Skirt",200f);
        BasePrice basePrice7 = new BasePrice("7","Lehenga",300f);
        BasePrice basePrice8 = new BasePrice("8","Shirt",100f);
        BasePrice basePrice9 = new BasePrice("9","Skirt",140f);

        Manufacturer manufacturer1 = new Manufacturer("1","RJ Enterprise","rj@gmail.com","bangalore","tailor",4.5f,9836199304L,List.of(manufacturerOrder1,manufacturerOrder3));
        manufacturer1.setBasePrices(List.of(basePrice1,basePrice2,basePrice3));
        kafkaTemplate.send("recommendationManufacturer",manufacturer1);
        Manufacturer manufacturer2 = new Manufacturer("2","KSV Enterprise","ksv@gmail.com","delhi","tailor",3.5f,9836123304L, List.of(manufacturerOrder2,manufacturerOrder4));
        manufacturer2.setBasePrices(List.of(basePrice4,basePrice5,basePrice6));
        kafkaTemplate.send("recommendationManufacturer",manufacturer2);
        Manufacturer manufacturer3 = new Manufacturer("3","LM Footwear Works","lm34@gmail.com","bangalore","shoemaker",4f,9830299304L,new ArrayList<>());
        manufacturer3.setBasePrices(List.of(basePrice7,basePrice8,basePrice9));
        kafkaTemplate.send("recommendationManufacturer",manufacturer3);


        try {
           manufactureService.saveManufacture(manufacturer1);
            manufactureService.saveManufacture(manufacturer2);
            manufactureService.saveManufacture(manufacturer3);
            System.out.println("saved manufacturer seed data");
            basepriceService.saveBaseprice(basePrice1);
            basepriceService.saveBaseprice(basePrice2);
            basepriceService.saveBaseprice(basePrice3);
            basepriceService.saveBaseprice(basePrice4);
            basepriceService.saveBaseprice(basePrice5);
            basepriceService.saveBaseprice(basePrice6);
            basepriceService.saveBaseprice(basePrice7);
            basepriceService.saveBaseprice(basePrice8);
            basepriceService.saveBaseprice(basePrice9);
            System.out.println("saved base price seed data");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
