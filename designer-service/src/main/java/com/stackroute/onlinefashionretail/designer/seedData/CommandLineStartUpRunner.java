package com.stackroute.onlinefashionretail.designer.seedData;

import com.stackroute.onlinefashionretail.designer.service.DesignerOrderService;
import com.stackroute.onlinefashionretail.designer.service.DesignerService;
import com.stackroute.onlinefashionretail.designer.model.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class CommandLineStartUpRunner implements CommandLineRunner {
    private DesignerOrderService designerOrderService;
    private DesignerService designerService;


    /**
     * Use constructor based DI to inject TrackService here
     */
    public CommandLineStartUpRunner(DesignerOrderService designerOrderService, DesignerService designerService) {
        this.designerOrderService = designerOrderService;
        this.designerService = designerService;
    }

    @Override
    public void run(String... args) throws Exception {
        /* *Pre-fill the database whenever application starts*/
        Designer designer1 = new Designer("1",
                9847287456L,
                "Sabyasachi",
                "Kolkata",
                "designs@sabyasachi.com",
                4.7f,
                new ArrayList<>());

        Designer designer2 = new Designer("2",
                9847132560L,
                "Manish Malhotra",
                "Delhi",
                "designs@manishmalhotra.com",
                4.6f,
                new ArrayList<>());

        Design design1 = new Design("1",
                "Embroidered Lehenga",
                "imageLehenga",
                0,
                0,
                0f,
                34,
                "in-progress");

        Design design2 = new Design("4",
                "Metallic Detail Earrings",
                "imageEarrings",
                0,
                0,
                0f,
                200,
                "in-progress");

        Manufacturer manufacturer1 = new Manufacturer("1","RJ Enterprise","rj@gmail.com","bangalore","tailor",4.5f,9836199304L,new ArrayList<ManufacturerOrder>(),new ArrayList<BasePrice>());

        DesignerOrder designerOrder1 = new DesignerOrder("1",design1,List.of(Map.of("1",3.0,"2",5.0)),manufacturer1,"");
        DesignerOrder designerOrder2 = new DesignerOrder("2",design2,List.of(Map.of("1",35.0,"2",5.0)),manufacturer1,"");
        try {
            designerService.saveDesigner(designer1);
            designerService.saveDesigner(designer2);
            System.out.println("Designer seed data saved");
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        try {
            designerOrderService.saveDesigns(designerOrder1);
            designerOrderService.saveDesigns(designerOrder2);
            System.out.println("designerOrder seed data saved");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
