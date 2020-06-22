package service.impl;

import model.Bike;
import model.BikeType;
import model.electricBikes.EBike;
import model.nonElectricBikes.FoldingBike;
import model.electricBikes.SpeedElectricBike;
import service.FileService;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FileServiceImpl implements FileService {

    @Override
    public List<Bike> readFile(File file) {
        List<Bike> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] bikeData = new String[7];
                String[] split = line.split("; ");
                System.arraycopy(split, 0, bikeData, 0, bikeData.length);
                if (bikeData[0].startsWith(BikeType.FOLDING.getBikeType())) {
                    FoldingBike foldingBike = createFoldingBike(bikeData);
                    list.add(foldingBike);
                } else if (bikeData[0].startsWith(BikeType.SPEEDELEC.getBikeType())) {
                    SpeedElectricBike speedElectricBike = createSpeedElectricBike(bikeData);
                    list.add(speedElectricBike);
                } else {
                    EBike ebike = createEbike(bikeData);
                    list.add(ebike);
                }
            }
        } catch (IOException e) {
            System.out.println("readFile method, FileServiceImpl class " + e);
        }
        return list;
    }

    @Override
    public void writeBikeToFile(File file, String[] parameters) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            for (int i = 0; i < parameters.length - 1; i++) {
                writer.append(parameters[i]).append("; ");
            }
            writer.append(parameters[parameters.length - 1]).append("\n");
        } catch (IOException e) {
            System.out.println("writeToFile method, FileServiceImpl class " + e);
        }
    }

    private EBike createEbike(String[] bikeData) {
        return EBike.newBuilder()
                .setBrand(bikeData[0])
                .setMaxSpeed(bikeData[1])
                .setWeight(bikeData[2])
                .setAvailabilityOfLights(bikeData[3])
                .setBatteryCapacity(bikeData[4])
                .setColor(bikeData[5])
                .setPrice(bikeData[6])
                .build();
    }

    private SpeedElectricBike createSpeedElectricBike(String[] bikeData) {
        return SpeedElectricBike.newBuilder()
                .setBrand(bikeData[0])
                .setMaxSpeed(bikeData[1])
                .setWeight(bikeData[2])
                .setAvailabilityOfLights(bikeData[3])
                .setBatteryCapacity(bikeData[4])
                .setColor(bikeData[5])
                .setPrice(bikeData[6])
                .build();
    }

    private FoldingBike createFoldingBike(String[] bikeData) {
        return FoldingBike.newBuilder()
                .setBrand(bikeData[0])
                .setSizeOfWheels(bikeData[1])
                .setNumberOfGears(bikeData[2])
                .setWeight(bikeData[3])
                .setAvailabilityOfLights(bikeData[4])
                .setColor(bikeData[5])
                .setPrice(bikeData[6])
                .build();
    }

    @Override
    public Bike createBikeByParameters(String[] bikeData) {
        if (bikeData[0].startsWith(BikeType.SPEEDELEC.getBikeType())) {
            return createSpeedElectricBike(bikeData);
        } else if (bikeData[0].startsWith(BikeType.EBIKE.getBikeType())) {
            return createEbike(bikeData);
        } else {
            return createFoldingBike(bikeData);
        }
    }

    @Override
    public Optional<Bike> findBike(String[] parameters, File file) {
        Bike bikeFromUser = createBikeByParameters(parameters);
        List<Bike> bikes = readFile(file);
        for (Bike bikeFromList : bikes) {
            if (bikeFromList.equals(bikeFromUser)) {
                return Optional.of(bikeFromList);
            }
        }
        return Optional.empty();
    }
}
