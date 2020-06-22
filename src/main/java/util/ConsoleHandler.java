package util;

import model.Bike;
import model.BikeType;
import service.FileService;
import service.impl.FileServiceImpl;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

public class ConsoleHandler {

    private static final FileService fileService = new FileServiceImpl();
    private static final Validator validator = new Validator();

    public void printBike(List<Bike> bikes) {
        for (Bike bike : bikes) {
            System.out.println(bike.toString());
        }
    }

    public void showEcoBikeMenu() {
        System.out.println("Please make your choice: \n" +
                " 1 - Show the entire EcoBike catalog \n" +
                " 2 – Add a new folding bike \n" +
                " 3 – Add a new speedelec \n" +
                " 4 – Add a new e-bike \n" +
                " 5 – Find the first item of a particular brand \n" +
                " 6 – Write to file \n" +
                " 7 – Stop the program");
    }

    public void showEcoBikeCatalog(String path) {
        File file = new File(path);
        List<Bike> bikes = fileService.readFile(file);
        printBike(bikes);
    }

    public String[] getBikeParameters(BufferedReader reader, boolean checkBrand, String brand)
            throws IOException {
        System.out.println("The weight of the bike (in grams) ");
        String weight = checkBrand ? validator.isStringInteger(reader) : reader.readLine();
        System.out.println("The availability of lights at front and back (true/false) ");
        String availabilityOfLights = checkBrand ? validator.isStringBoolean(reader) :
                reader.readLine();
        System.out.println("A color ");
        String color = checkBrand ? validator.checkString(reader) : reader.readLine();
        System.out.println("The price ");
        String price = checkBrand ? validator.isStringInteger(reader) : reader.readLine();
        String wheels = "";
        String gears = "";
        String speed = "";
        String battery = "";
        if (brand.startsWith(BikeType.FOLDING.getBikeType())) {
            System.out.println("The size of the wheels (in inch) ");
            wheels = checkBrand ? validator.isStringInteger(reader) : reader.readLine();
            System.out.println("The number of gears ");
            gears = checkBrand ? validator.isStringInteger(reader) : reader.readLine();
        } else {
            System.out.println("The maximum speed (in km/h) ");
            speed = checkBrand ? validator.isStringInteger(reader) : reader.readLine();
            System.out.println("The battery capacity (in mAh) ");
            battery = checkBrand ? validator.isStringInteger(reader) : reader.readLine();
        }
        return getDataFromUser(brand, weight, availabilityOfLights, color, price, wheels, gears,
                speed, battery);
    }

    public String[] getDataFromUser(String brand, String weight, String availabilityOfLights,
                                    String color, String price, String wheels, String gears,
                                    String speed, String battery) {
        if (brand.startsWith(BikeType.FOLDING.getBikeType())) {
            return new String[]{brand, wheels, gears, weight, availabilityOfLights, color, price};
        } else {
            return new String[]{brand, speed, weight, availabilityOfLights, battery, color, price};
        }
    }

    public void writeToFile(File file, String brand, BufferedReader reader, boolean checkBrand)
            throws IOException {
        String[] bikeParameters = getBikeParameters(reader, checkBrand, brand);
        fileService.writeBikeToFile(file, bikeParameters);
    }

    public void findBike(File file, BufferedReader reader, String brand, boolean checkBrand)
            throws IOException {
        String[] bikeParameters = getBikeParameters(reader, checkBrand, brand);
        Optional<Bike> optionalBike = fileService.findBike(bikeParameters, file);
        if (optionalBike.isPresent()) {
            Bike bike = optionalBike.get();
            System.out.println(bike.toString());
        } else {
            System.out.println("There is no bike");
        }
    }

    public void startProgram() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the path:");
            String path = validator.checkFile(reader.readLine(), reader);
            while (true) {
                showEcoBikeMenu();
                int number = Integer.parseInt(validator.isStringInteger(reader));
                switch (number) {
                    case 1:
                        showEcoBikeCatalog(path);
                        continue;
                    case 2:
                    case 3:
                    case 4:
                    case 6:
                        System.out.println("Enter a brand");
                        writeToFile(new File(path), validator.getBrand(reader, number), reader,
                                true);
                        continue;
                    case 5:
                        System.out.println("Enter a brand");
                        findBike(new File(path), reader, validator.getBrand(reader, number),
                                  false);
                        continue;
                    case 7:
                        break;
                    default:
                        continue;
                }
                break;
            }
        } catch (IOException e) {
            System.out.println("startProgram method, ConsoleHandler class " + e);
        }
    }
}
