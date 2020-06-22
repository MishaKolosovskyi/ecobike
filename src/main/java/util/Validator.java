package util;

import model.BikeType;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class Validator {

    public String getBrand(BufferedReader reader, int number) throws IOException {
        if (number == 2) {
            return getType(reader, BikeType.FOLDING.getBikeType());
        } else if (number == 3) {
            return getType(reader, BikeType.SPEEDELEC.getBikeType());
        } else if (number == 4){
            return getType(reader, BikeType.EBIKE.getBikeType());
        }else {
            return checkBrand(reader);
        }
    }

    private String checkBrand(BufferedReader reader) throws IOException {
        String brand = reader.readLine();
        while (!(brand.startsWith(BikeType.FOLDING.getBikeType()) ||
                brand.startsWith(BikeType.EBIKE.getBikeType()) ||
                brand.startsWith(BikeType.SPEEDELEC.getBikeType()))){
            brand = reader.readLine();
        }
        return brand;
    }

    private String getType(BufferedReader reader, String type) throws IOException {
        String brand = reader.readLine();
        while (!brand.startsWith(type)) {
            brand = reader.readLine();
        }
        return brand;
    }

    public String checkString(BufferedReader reader) throws IOException {
        String string = reader.readLine();
        while (string.isEmpty()) {
            string = reader.readLine();
        }
        return string;
    }

    public String isStringInteger(BufferedReader reader) throws IOException {
        String string = reader.readLine();
        boolean isInt;
        do {
            try {
                Integer.parseInt(string);
                isInt = true;
            } catch (NumberFormatException e) {
                string = reader.readLine();
                isInt = false;
            }
        } while (!isInt);
        return string;
    }

    public String isStringBoolean(BufferedReader reader) throws IOException {
        String string = reader.readLine();
        while (!(string.equals("true") || string.equals("false"))) {
            string = reader.readLine().toLowerCase();
        }
        return string;
    }

    public String checkFile(String path, BufferedReader reader) throws IOException {
        File file = new File(path);
        boolean exists = file.exists();
        while (!exists) {
            path = reader.readLine();
            exists = new File(path).exists();
        }
        return path;
    }
}
