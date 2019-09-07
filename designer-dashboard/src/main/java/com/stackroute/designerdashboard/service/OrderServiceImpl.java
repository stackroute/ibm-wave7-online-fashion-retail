package com.stackroute.designerdashboard.service;

import com.stackroute.designerdashboard.model.Dorder;
import com.stackroute.designerdashboard.model.Order;
import com.stackroute.designerdashboard.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OderService {
    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Dorder saveDesigns(Dorder designer) {
        Dorder designer1= orderRepository.save(designer);
        return designer1;
    }

    @Override
    public List<Dorder> getDesigns() {
        List<Dorder> designerList= orderRepository.findAll();
        return designerList;
    }

    @Override
    public Order updateDesigns(Order designer, String id) {
        return null;
    }

    @Override
    public Optional<Dorder> deleteDesigns(String id) {
        Optional<Dorder> order = orderRepository.findById(id);
         orderRepository.deleteById(id);

         return  order;
    }

    @Override
    public Optional<Dorder> getOrderById(String id) {
      return orderRepository.findById(id);
    }
}
