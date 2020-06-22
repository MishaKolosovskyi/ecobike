package model;

public abstract class Bike {
    private String price;
    private String brand;
    private String weight;
    private String availabilityOfLights;
    private String color;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getAvailabilityOfLights() {
        return availabilityOfLights;
    }

    public void setAvailabilityOfLights(String availabilityOfLights) {
        this.availabilityOfLights = availabilityOfLights;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
