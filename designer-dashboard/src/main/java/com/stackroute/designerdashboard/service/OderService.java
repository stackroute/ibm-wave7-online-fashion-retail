package com.stackroute.designerdashboard.service;

import com.stackroute.designerdashboard.model.Dorder;
import com.stackroute.designerdashboard.model.Order;

import java.util.List;
import java.util.Optional;


public interface OderService {

    public Dorder saveDesigns(Dorder designer);
    public List<Dorder> getDesigns();
    public Order updateDesigns(Order designer, String id);
    public Optional<Dorder> deleteDesigns(String id);
    public Optional<Dorder> getOrderById(String id);
}
