package model;

public abstract class NonElectricBike extends Bike {

    private String sizeOfWheels;
    private String numberOfGears;

    public String getSizeOfWheels() {
        return sizeOfWheels;
    }

    public void setSizeOfWheels(String sizeOfWheels) {
        this.sizeOfWheels = sizeOfWheels;
    }

    public String getNumberOfGears() {
        return numberOfGears;
    }

    public void setNumberOfGears(String numberOfGears) {
        this.numberOfGears = numberOfGears;
    }
}
