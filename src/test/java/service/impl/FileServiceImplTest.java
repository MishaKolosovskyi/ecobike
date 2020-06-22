package service.impl;

import model.Bike;
import model.electricBikes.EBike;
import model.nonElectricBikes.FoldingBike;
import org.junit.Test;
import java.io.File;
import java.util.Optional;
import static org.junit.Assert.assertEquals;

public class FileServiceImplTest {

    private FileServiceImpl fileService = new FileServiceImpl();

    @Test
    public void correctCreatingBikeByParameters() {
        String[] foldingBikeParameters =
                new String[]{"FOLDING BIKE BMW", "1", "1", "1", "true", "lemon", "1"};
        Bike foldingBikeByParameters = fileService.createBikeByParameters(foldingBikeParameters);
        assertEquals(FoldingBike.newBuilder()
                .setBrand("FOLDING BIKE BMW")
                .setSizeOfWheels("1")
                .setNumberOfGears("1")
                .setWeight("1")
                .setAvailabilityOfLights("true")
                .setColor("lemon")
                .setPrice("1")
                .build(), foldingBikeByParameters);
        String[] ebikeParameters =
                new String[]{"E-BIKE Gazelle", "1", "1", "true", "1", "lemon", "1"};
        Bike ebikeByParameters = fileService.createBikeByParameters(ebikeParameters);
        assertEquals(EBike.newBuilder()
                .setBrand("E-BIKE Gazelle")
                .setMaxSpeed("1")
                .setWeight("1")
                .setAvailabilityOfLights("true")
                .setBatteryCapacity("1")
                .setColor("lemon")
                .setPrice("1")
                .build(), ebikeByParameters);
    }

    @Test
    public void correctBikeFinding() {
        File file = new File("src/main/resources/ecobike.txt");
        String[] foldingBikeParameters =
                new String[]{"FOLDING BIKE BMW", "", "", "", "", "lemon", ""};
        Optional<Bike> optionalFoldingBike = fileService.findBike(foldingBikeParameters, file);
        if (optionalFoldingBike.isPresent()){
            FoldingBike bike  =  (FoldingBike) optionalFoldingBike.get();
            assertEquals("FOLDING BIKE BMW", bike.getBrand());
            assertEquals("20", bike.getSizeOfWheels());
            assertEquals("7", bike.getNumberOfGears());
            assertEquals("14400", bike.getWeight());
            assertEquals("false", bike.getAvailabilityOfLights());
            assertEquals("lemon", bike.getColor());
            assertEquals("1085", bike.getPrice());
        }
        String[] ebikeParameters = new String[]{"E-BIKE Gazelle", "", "", "", "26000", "", "1735"};
        Optional<Bike> optionalBike = fileService.findBike(ebikeParameters, file);
        if (optionalBike.isPresent()) {
            EBike bike = (EBike) optionalBike.get();
            assertEquals("E-BIKE Gazelle", bike.getBrand());
            assertEquals("25", bike.getMaxSpeed());
            assertEquals("22200", bike.getWeight());
            assertEquals("true", bike.getAvailabilityOfLights());
            assertEquals("26000", bike.getBatteryCapacity());
            assertEquals("silver", bike.getColor());
            assertEquals("1735", bike.getPrice());
        }
    }

    @Test
    public void wrongBikeFinding() {
        File file = new File("src/main/resources/ecobike.txt");
        String[] data = new String[]{"NONE", "", "", "", "", "", ""};
        Optional<Bike> optionalFoldingBike = fileService.findBike(data, file);
            assertEquals(false, optionalFoldingBike.isPresent());
    }
}
