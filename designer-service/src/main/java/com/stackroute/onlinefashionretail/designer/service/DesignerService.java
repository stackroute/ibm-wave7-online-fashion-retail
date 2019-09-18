package com.stackroute.onlinefashionretail.designer.service;

import com.stackroute.onlinefashionretail.designer.model.Designer;
import com.stackroute.onlinefashionretail.designer.model.DesignerOrder;

import java.util.List;
import java.util.Optional;

public interface DesignerService {

    public Designer saveDesigner(Designer designer);

    public Optional<Designer> getDesigner(String id);
    public List<Designer> getAllDesigners();

    public boolean deleteDesigner(String id) ;

    public Designer updateDesigner(Designer designer, String id);

    public DesignerOrder saveOrder(DesignerOrder designerOrder, String id);

    public DesignerOrder updateOrder(DesignerOrder designerOrder, String id);

    public List<DesignerOrder> getAllOrders(String id);

}
