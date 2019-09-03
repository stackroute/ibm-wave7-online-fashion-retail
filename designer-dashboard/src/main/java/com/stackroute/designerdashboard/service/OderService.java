package com.stackroute.designerdashboard.service;

import com.stackroute.designerdashboard.model.Dorder;
import com.stackroute.designerdashboard.model.Order;

import java.util.List;
import java.util.Optional;


public interface OderService {

    public Dorder saveDesigns(Dorder designer);
    public List<Dorder> getDesigns();
    public Order updateDesigns(Order designer, int id);
    public Optional<Dorder> deleteDesigns(int id);
}
