package service;

import model.Bike;
import java.io.File;
import java.util.List;
import java.util.Optional;

public interface FileService {

    void writeBikeToFile(File file, String[] parameters);

    List<Bike> readFile(File file);

    Bike createBikeByParameters(String[] parameters);

    Optional<Bike> findBike(String[] parameters, File file);
}
