package model;

public enum BikeType {
    FOLDING("FOLDING"),
    SPEEDELEC("SPEEDELEC"),
    EBIKE("E-BIKE");

    private String bikeType;

    BikeType(String bikeType) {
        this.bikeType = bikeType;
    }

    public String getBikeType() {
        return bikeType;
    }

    public void setBikeType(String bikeType) {
        this.bikeType = bikeType;
    }
}
