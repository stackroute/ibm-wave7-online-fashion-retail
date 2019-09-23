package com.stackroute.onlinefashionretail.supplier.seedData;

import com.stackroute.onlinefashionretail.supplier.domain.Mapping;
import com.stackroute.onlinefashionretail.supplier.domain.Material;
import com.stackroute.onlinefashionretail.supplier.domain.Supplier;
import com.stackroute.onlinefashionretail.supplier.domain.SupplierOrder;
import com.stackroute.onlinefashionretail.supplier.services.MappingService;
import com.stackroute.onlinefashionretail.supplier.services.MaterialService;
import com.stackroute.onlinefashionretail.supplier.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommandLineStartUpRunner implements CommandLineRunner {
    private SupplierService supplierService;
    private MaterialService materialService;
    private MappingService mappingService;

    /**
     * Use constructor based DI to inject TrackService here
     */
    @Autowired
    private KafkaTemplate<String, Supplier> kafkaTemplate;

    public CommandLineStartUpRunner(SupplierService supplierService, MaterialService materialService, MappingService mappingService) {
        this.supplierService = supplierService;
        this.materialService = materialService;
        this.mappingService = mappingService;
    }





    @Override
    public void run(String... args) throws Exception {
        /* *Pre-fill the database whenever application starts*/
        Material material1 = new Material("1","Clothing","Linen","imageLinen.jpeg");
        Material material2 = new Material("2","Clothing","Cotton","imageCotton.jpeg");
        Material material3 = new Material("3","Footwear","Tan Leather","imageTanLeather.jpeg");
        Material material4 = new Material("4","Footwear","Black Laces","imageBlackLaces.jpeg");
        Material material5 = new Material("5","Jewellery","Steel 5mm rings","imageSteelRings.jpeg");
        Material material6 = new Material("6","Jewellery","Decorative Feathers","imageDecorativeFeathers.jpeg");

        SupplierOrder supplierOrder1 = new SupplierOrder("1","Ritu Mehta",material1,45.0,"in-progress","");
        SupplierOrder supplierOrder2 = new SupplierOrder("2","Ritu Mehta",material2,235.0,"in-progress","");
        SupplierOrder supplierOrder3 = new SupplierOrder("3","Manish Malhotra",material3,90.0,"in-progress","");

        Supplier supplier1 = new Supplier("1","CG Fabrics and Accesories","Delhi",4.5f,"cgfabrics@gmail.com",List.of(supplierOrder1,supplierOrder2));
        kafkaTemplate.send("recommendationSupplier",supplier1);
        Supplier supplier2 = new Supplier("2","BH Fabrics and Leathers","Banngalore",3.4f,"bhfabandacc@gmail.com",List.of(supplierOrder3));
        kafkaTemplate.send("recommendationSupplier",supplier2);
        Mapping mapping1 = new Mapping("1",45.5,890,material1,supplier1,"metres");
        Mapping mapping2 = new Mapping("2",66.5,400,material2,supplier1,"metres");
        Mapping mapping3 = new Mapping("3",125,800,material3,supplier2,"metres");
        Mapping mapping4 = new Mapping("4",15,650,material4,supplier1,"units");
        Mapping mapping5 = new Mapping("5",5,1000,material5,supplier1,"units");
        Mapping mapping6 = new Mapping("6",15,500,material6,supplier1,"pieces");
        Mapping mapping7 = new Mapping("7",34.5,450,material1,supplier2,"metres");


        try {

            materialService.saveMaterial(material1);
            materialService.saveMaterial(material2);
            materialService.saveMaterial(material3);
            materialService.saveMaterial(material4);
            materialService.saveMaterial(material5);
            materialService.saveMaterial(material6);
            System.out.println("saved materials seed data");

            supplierService.saveSupplier(supplier1);
            supplierService.saveSupplier(supplier2);
            System.out.println("saved suppliers seed data");

            mappingService.saveMapping(mapping1);
            mappingService.saveMapping(mapping2);
            mappingService.saveMapping(mapping3);
            mappingService.saveMapping(mapping4);
            mappingService.saveMapping(mapping5);
            mappingService.saveMapping(mapping6);
            mappingService.saveMapping(mapping7);
            System.out.println("saved mappings seed data");

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
