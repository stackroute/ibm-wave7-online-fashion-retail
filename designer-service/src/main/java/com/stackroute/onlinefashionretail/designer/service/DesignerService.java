package com.stackroute.onlinefashionretail.designer.service;

import com.stackroute.onlinefashionretail.designer.model.Designer;

import java.util.List;
import java.util.Optional;

public interface DesignerService {

    public Designer saveDesigner(Designer designer);

    public Optional<Designer> getDesigner(String id);
    public List<Designer> getAllDesigners();

    public boolean deleteDesigner(String id) ;

    public Designer updateDesigner(Designer designer, String id);

}
