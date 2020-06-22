package model.nonElectricBikes;

import model.NonElectricBike;
import java.util.Objects;

public class FoldingBike extends NonElectricBike {

    private FoldingBike() {
    }

    public static FoldingBikeBuilder newBuilder() {
        return new FoldingBike().new FoldingBikeBuilder();
    }

    public class FoldingBikeBuilder {

        private FoldingBikeBuilder() {

        }

        public FoldingBikeBuilder setBrand(String brand) {
            FoldingBike.this.setBrand(brand);
            return this;
        }

        public FoldingBikeBuilder setPrice(String price) {
            FoldingBike.this.setPrice(price);
            return this;
        }

        public FoldingBikeBuilder setWeight(String weight) {
            FoldingBike.this.setWeight(weight);
            return this;
        }

        public FoldingBikeBuilder setAvailabilityOfLights(String availabilityOfLights) {
            FoldingBike.this.setAvailabilityOfLights(availabilityOfLights);
            return this;
        }

        public FoldingBikeBuilder setColor(String color) {
            FoldingBike.this.setColor(color);
            return this;
        }

        public FoldingBikeBuilder setSizeOfWheels(String sizeOfWheels) {
            FoldingBike.this.setSizeOfWheels(sizeOfWheels);
            return this;
        }

        public FoldingBikeBuilder setNumberOfGears(String numberOfGears) {
            FoldingBike.this.setNumberOfGears(numberOfGears);
            return this;
        }

        public FoldingBike build() {
            return FoldingBike.this;
        }
    }

    @Override
    public String toString() {
        String getAvailabilityOfLights = getAvailabilityOfLights().equals("true") ?
                "and head/tail light." : "and no head/tail light.";
        return String.format("%s %s gear(s) %s \nPrice: %s euros.", getBrand(), getNumberOfGears(),
                getAvailabilityOfLights, getPrice());
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof FoldingBike)) {
            return false;
        }
        FoldingBike that = (FoldingBike) o;
        return ((that.getBrand().isEmpty() || Objects.equals(getBrand(), that.getBrand())) &&
                (that.getColor().isEmpty() || Objects.equals(getColor(), that.getColor())) &&
                (that.getWeight().isEmpty() || Objects.equals(getWeight(), that.getWeight())) &&
                (that.getAvailabilityOfLights().isEmpty() ||
                      Objects.equals(getAvailabilityOfLights(), that.getAvailabilityOfLights())) &&
                (that.getPrice().isEmpty() || Objects.equals(getPrice(), that.getPrice())) &&
                (that.getNumberOfGears().isEmpty() ||
                      Objects.equals(getNumberOfGears(), that.getNumberOfGears())) &&
                (that.getSizeOfWheels().isEmpty() || Objects.equals(getSizeOfWheels(),
                        that.getSizeOfWheels())));
    }
}
