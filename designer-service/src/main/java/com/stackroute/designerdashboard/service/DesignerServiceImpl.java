package com.stackroute.designerdashboard.service;

import com.stackroute.designerdashboard.model.Designer;
import com.stackroute.designerdashboard.repository.DesignerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DesignerServiceImpl implements DesignerService {

    DesignerRepository designerRepository;

    @Autowired
    public DesignerServiceImpl(DesignerRepository designerRepository)
    {
        this.designerRepository = designerRepository;
    }

    @Override
    public Designer saveDesigner(Designer designer) {
        Designer savedDesigner = designerRepository.save(designer);
        return savedDesigner;
    }


    @Override
    public Optional<Designer> getDesigner(String id) {
//        Designer designer = designerRepository.findById(id);
        return designerRepository.findById(id);
    }

    @Override
    public List<Designer> getAllDesigners()
    {
        return designerRepository.findAll();
    }

    @Override
    public boolean deleteDesigner(String id ){
      // Optional<User> user1 = userRepository.findById(id);

        try {

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
        Optional<Designer> designer1 = designerRepository.findById(id);
        String name=designer1.get().getName();
        String email=designer1.get().getEmail();
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

}
