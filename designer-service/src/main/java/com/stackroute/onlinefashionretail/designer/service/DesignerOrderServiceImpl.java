package com.stackroute.onlinefashionretail.designer.service;

import com.stackroute.onlinefashionretail.designer.model.DesignerOrder;
import com.stackroute.onlinefashionretail.designer.repository.DesignerOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DesignerOrderServiceImpl implements DesignerOrderService {
    private DesignerOrderRepository designerOrderRepository;

    @Autowired
    public DesignerOrderServiceImpl(DesignerOrderRepository designerOrderRepository) {
        this.designerOrderRepository = designerOrderRepository;
    }

    @Override
    public DesignerOrder saveDesigns(DesignerOrder designer) {
        DesignerOrder designer1= designerOrderRepository.save(designer);
        return designer1;
    }

    @Override
    public List<DesignerOrder> getDesigns() {
        List<DesignerOrder> designerList= designerOrderRepository.findAll();
        return designerList;
    }

    @Override
    public DesignerOrder updateDesigns(DesignerOrder designer, String id) throws Exception{
        Optional<DesignerOrder> dorder= designerOrderRepository.findById(id);
        if(!dorder.isPresent())
        {
            throw new Exception("Order Not Found");
        }
        designer.setId(id);
        return designerOrderRepository.save(designer);
    }

    @Override
    public Optional<DesignerOrder> deleteDesigns(String id) {
        Optional<DesignerOrder> order = designerOrderRepository.findById(id);
         designerOrderRepository.deleteById(id);

         return  order;
    }

    @Override
    public Optional<DesignerOrder> getOrderById(String id) {
      return designerOrderRepository.findById(id);
    }
}
