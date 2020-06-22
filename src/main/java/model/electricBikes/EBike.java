package model.electricBikes;

import model.ElectricBike;
import java.util.Objects;

public class EBike extends ElectricBike {

    private EBike() {
    }

    public static EBikeBuilder newBuilder() {
        return new EBike().new EBikeBuilder();
    }

    public class EBikeBuilder {
        private EBikeBuilder() {

        }

        public EBikeBuilder setBrand(String brand) {
            EBike.this.setBrand(brand);
            return this;
        }

        public EBikeBuilder setPrice(String price) {
            EBike.this.setPrice(price);
            return this;
        }

        public EBikeBuilder setWeight(String weight) {
            EBike.this.setWeight(weight);
            return this;
        }

        public EBikeBuilder setAvailabilityOfLights(String availabilityOfLights) {
            EBike.this.setAvailabilityOfLights(availabilityOfLights);
            return this;
        }

        public EBikeBuilder setColor(String color) {
            EBike.this.setColor(color);
            return this;
        }

        public EBikeBuilder setBatteryCapacity(String batteryCapacity) {
            EBike.this.setBatteryCapacity(batteryCapacity);
            return this;
        }

        public EBikeBuilder setMaxSpeed(String maxSpeed) {
            EBike.this.setMaxSpeed(maxSpeed);
            return this;
        }

        public EBike build() {
            return EBike.this;
        }
    }

    @Override
    public String toString() {
        String getAvailabilityOfLights = getAvailabilityOfLights().equals("true") ?
                "and head/tail light." : "and no head/tail light.";
        return String.format("%s with %s mAh battery %s \nPrice: %s euros.", getBrand(),
                getBatteryCapacity(), getAvailabilityOfLights, getPrice());
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof EBike)) {
            return false;
        }
        EBike that = (EBike) o;
        return ((that.getBrand().isEmpty() || Objects.equals(getBrand(), that.getBrand())) &&
                (that.getColor().isEmpty() || Objects.equals(getColor(), that.getColor())) &&
                (that.getWeight().isEmpty() || Objects.equals(getWeight(), that.getWeight())) &&
                (that.getAvailabilityOfLights().isEmpty() ||
                      Objects.equals(getAvailabilityOfLights(), that.getAvailabilityOfLights())) &&
                (that.getPrice().isEmpty() || Objects.equals(getPrice(), that.getPrice())) &&
                (that.getBatteryCapacity().isEmpty() ||
                      Objects.equals(getBatteryCapacity(), that.getBatteryCapacity())) &&
                (that.getMaxSpeed().isEmpty() || Objects.equals(getMaxSpeed(), that.getMaxSpeed())));
    }
}
