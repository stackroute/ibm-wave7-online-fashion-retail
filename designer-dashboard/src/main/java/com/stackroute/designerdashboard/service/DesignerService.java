package com.stackroute.designerdashboard.service;

import com.stackroute.designerdashboard.model.Designer;

import java.util.List;
import java.util.Optional;

public interface DesignerService {

    public Designer saveDesigner(Designer designer);

    public Optional<Designer> getDesigner(int id);
    public List<Designer> getAllDesigners();

    public boolean deleteDesigner(int id) ;

    public Designer updateDesigner(Designer designer, int id);

}
