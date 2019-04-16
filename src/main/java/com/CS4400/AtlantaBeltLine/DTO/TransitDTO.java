package com.CS4400.AtlantaBeltLine.DTO;

public class TransitDTO {

    private String type;
    private String route;
    private int price;

    public TransitDTO() {
    }

    public TransitDTO(String type, String route, int price) {
        this.type = type;
        this.route = route;
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
