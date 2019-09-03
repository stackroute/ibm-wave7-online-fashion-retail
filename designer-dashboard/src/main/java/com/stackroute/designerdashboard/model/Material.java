package com.stackroute.designerdashboard.model;

public class Material {
    private String name;
    private String M_image;
    private String Categiry;

    public Material() {
    }

    public Material(String name, String m_image, String categiry) {
        this.name = name;
        M_image = m_image;
        Categiry = categiry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getM_image() {
        return M_image;
    }

    public void setM_image(String m_image) {
        M_image = m_image;
    }

    public String getCategiry() {
        return Categiry;
    }

    public void setCategiry(String categiry) {
        Categiry = categiry;
    }
}
