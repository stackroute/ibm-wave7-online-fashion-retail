package com.example.designerdashboard.service;

import com.example.designerdashboard.model.Dorder;
import com.example.designerdashboard.model.Order;

import java.util.List;
import java.util.Optional;


public interface OderService {

    public Dorder saveDesigns(Dorder designer);
    public List<Dorder> getDesigns();
    public Order updateDesigns(Order designer, int id);
    public Optional<Dorder> deleteDesigns(int id);
}
