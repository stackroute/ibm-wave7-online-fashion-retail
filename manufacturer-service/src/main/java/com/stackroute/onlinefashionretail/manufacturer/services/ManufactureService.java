package com.stackroute.onlinefashionretail.manufacturer.services;

import com.stackroute.onlinefashionretail.manufacturer.domain.BasePrice;
import com.stackroute.onlinefashionretail.manufacturer.domain.Manufacturer;
import com.stackroute.onlinefashionretail.manufacturer.domain.ManufacturerOrder;

import java.util.List;
import java.util.Optional;

public interface ManufactureService {

    public Manufacturer saveManufacture(Manufacturer manufacturer);

    public List<Manufacturer> getAllManufactures();

    public boolean deleteManufacture(String id) ;

    public Optional<Manufacturer> getManufacture(String id);

    public Manufacturer updateManufacture(Manufacturer manufacturer, String id);

    public ManufacturerOrder saveOrder(String id, ManufacturerOrder manufacturerOrder) throws Exception;
    public List<ManufacturerOrder> getAllOrders(String id);
    public boolean deleteOrder(String id);
    public ManufacturerOrder updateOrder(ManufacturerOrder manufacturerOrder, String id);

    public BasePrice saveBaseprice(BasePrice baseprice, String id);

    public List<BasePrice> getAllBaseprice(String id);

}
