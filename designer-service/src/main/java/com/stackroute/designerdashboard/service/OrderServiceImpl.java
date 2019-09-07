package com.stackroute.designerdashboard.service;

import com.stackroute.designerdashboard.model.DesignerOrder;
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
    public DesignerOrder saveDesigns(DesignerOrder designer) {
        DesignerOrder designer1= orderRepository.save(designer);
        return designer1;
    }

    @Override
    public List<DesignerOrder> getDesigns() {
        List<DesignerOrder> designerList= orderRepository.findAll();
        return designerList;
    }

    @Override
    public DesignerOrder updateDesigns(DesignerOrder designer, String id) throws Exception{
        Optional<DesignerOrder> dorder=orderRepository.findById(id);
        if(!dorder.isPresent())
        {
            throw new Exception("Order Not Found");
        }
        designer.setId(id);
        return orderRepository.save(designer);
    }

    @Override
    public Optional<DesignerOrder> deleteDesigns(String id) {
        Optional<DesignerOrder> order = orderRepository.findById(id);
         orderRepository.deleteById(id);

         return  order;
    }

    @Override
    public Optional<DesignerOrder> getOrderById(String id) {
      return orderRepository.findById(id);
    }
}
