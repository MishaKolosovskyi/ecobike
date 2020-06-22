package model.electricBikes;

import model.ElectricBike;
import java.util.Objects;

public class SpeedElectricBike extends ElectricBike {

    private SpeedElectricBike() {
    }

    public static SpeedElectricBikeBuilder newBuilder() {
        return new SpeedElectricBike().new SpeedElectricBikeBuilder();
    }

    public class SpeedElectricBikeBuilder {
        private SpeedElectricBikeBuilder() {

        }

        public SpeedElectricBikeBuilder setBrand(String brand) {
            SpeedElectricBike.this.setBrand(brand);
            return this;
        }

        public SpeedElectricBikeBuilder setPrice(String price) {
            SpeedElectricBike.this.setPrice(price);
            return this;
        }

        public SpeedElectricBikeBuilder setWeight(String weight) {
            SpeedElectricBike.this.setWeight(weight);
            return this;
        }

        public SpeedElectricBikeBuilder setAvailabilityOfLights(String availabilityOfLights) {
            SpeedElectricBike.this.setAvailabilityOfLights(availabilityOfLights);
            return this;
        }

        public SpeedElectricBikeBuilder setColor(String color) {
            SpeedElectricBike.this.setColor(color);
            return this;
        }

        public SpeedElectricBikeBuilder setBatteryCapacity(String batteryCapacity) {
            SpeedElectricBike.this.setBatteryCapacity(batteryCapacity);
            return this;
        }

        public SpeedElectricBikeBuilder setMaxSpeed(String maxSpeed) {
            SpeedElectricBike.this.setMaxSpeed(maxSpeed);
            return this;
        }

        public SpeedElectricBike build() {
            return SpeedElectricBike.this;
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
        if (!(o instanceof SpeedElectricBike)) {
            return false;
        }
        SpeedElectricBike that = (SpeedElectricBike) o;
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
