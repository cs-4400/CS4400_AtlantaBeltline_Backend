package com.CS4400.AtlantaBeltLine.DTO;

public class TransitDTO {

    private String route;
    private String type;
    private int price;

    public TransitDTO() {
    }

    public TransitDTO(String route, String type, int price) {
        this.route = route;
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
