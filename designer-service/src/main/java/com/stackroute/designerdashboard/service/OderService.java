package com.stackroute.designerdashboard.service;

import com.stackroute.designerdashboard.model.DesignerOrder;

import java.util.List;
import java.util.Optional;


public interface OderService {

    public DesignerOrder saveDesigns(DesignerOrder designer);
    public List<DesignerOrder> getDesigns();
    public DesignerOrder updateDesigns(DesignerOrder designer, String id) throws  Exception;
    public Optional<DesignerOrder> deleteDesigns(String id);
    public Optional<DesignerOrder> getOrderById(String id);
}
