package com.arvind.ooug.taskgci.models;

import java.io.Serializable;

public class ImageFilter implements Serializable {
    private String size;
    private String color;
    private String type;
    private String site;

    public ImageFilter(){
        this.color = "Any";
        this.size = "Any";
        this.site = "";
        this.type = "Any";
    }

    public ImageFilter(String size, String site, String type, String color){
        this.type = type;
        this.color = color;
        this.site = site;
        this.size = size;
    }

    public boolean noSelections(){
        if(size.equals("Any") && color.equals("Any") && type.equals("Any") && site.equals("")){
            return true;
        }
        return false;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }


}
