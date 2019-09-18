package com.stackroute.onlinefashionretail.designer.service;

import com.stackroute.onlinefashionretail.designer.model.Designer;
import com.stackroute.onlinefashionretail.designer.model.DesignerOrder;
import com.stackroute.onlinefashionretail.designer.repository.DesignerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DesignerServiceImpl implements DesignerService {
    private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
    DesignerRepository designerRepository;

    @Autowired
    public DesignerServiceImpl(DesignerRepository designerRepository)
    {
        this.designerRepository = designerRepository;
    }

    @Override
    public Designer saveDesigner(Designer designer) {
        logger.info("Entered into saveDesigner method in DesignerServiceImpl");
        Designer savedDesigner = designerRepository.save(designer);
        return savedDesigner;
    }


    @Override
    public Optional<Designer> getDesigner(String id) {
        logger.info("Entered into getDesigner into DesignerServiceImpl");
//        Designer designer = designerRepository.findById(id);
        return designerRepository.findById(id);
    }

    @Override
    public List<Designer> getAllDesigners()

    {
        logger.info("Entered into getAllDesigner into DesignerServiceImpl");
        return designerRepository.findAll();
    }

    @Override
    public boolean deleteDesigner(String id ){
      // Optional<User> user1 = userRepository.findById(id);

        try {
            logger.info("Entered into deleteDesigner into DesignerServiceImpl");
            designerRepository.deleteById(id);

            return true;

        }
        catch (Exception exception)
        {
            return false;
        }
    }
    @Override
    public Designer updateDesigner(Designer designer, String id)
    {
        logger.info("Entered into updateDesigner into DesignerServiceImpl");
        Optional<Designer> designer1 = designerRepository.findById(id);
        String name=designer1.get().getName();
        String email=designer1.get().getEmail();
        System.out.println(designer1);
        Designer designer2=new Designer();
        designer2.setId(id);
        designer2.setName(name);
        designer2.setEmail(email);
        designer2.setContactNumber(designer.getContactNumber());
        designer2.setCity(designer.getCity());
        designer2.setRating(designer.getRating());

        Designer savedDesigner = designerRepository.save(designer2);
        return savedDesigner;
    }

    @Override
    public DesignerOrder saveOrder(DesignerOrder designerOrder, String id) {
        if (designerRepository.findById(id).isEmpty())
            return null;
        Designer designer = designerRepository.findById(id).get();
        designer.getOrderList().add(designerOrder);
        designerRepository.save(designer);
        return designerOrder;
    }

    @Override
    public DesignerOrder updateOrder(DesignerOrder designerOrder, String id) {
        if (designerRepository.findById(id).isEmpty())
            return null;
        Designer designer = designerRepository.findById(id).get();
        for (DesignerOrder designerOrder1: designer.getOrderList()
        ){
            if (designerOrder1.getId().equals(designerOrder.getId())){
                designerOrder1.setDesignOrder(designerOrder.getDesignOrder());
                break;
            }
        }
        designerRepository.save(designer);
        return designerOrder;
    }

    @Override
    public List<DesignerOrder> getAllOrders(String id) {
        if (designerRepository.findById(id).isEmpty())
            return null;
        return designerRepository.findById(id).get().getOrderList();
    }

}
