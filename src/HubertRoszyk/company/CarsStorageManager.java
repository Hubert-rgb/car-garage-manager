package HubertRoszyk.company;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarsStorageManager { 
    private String fileName;
    private String separator = ";";

    public CarsStorageManager(String fileName) {
        this.fileName = fileName;
    }

    public void deleteContent() throws IOException {
        PrintWriter writer = new PrintWriter(fileName);
        writer.print("");
    }
    void write(List<CarData> cars) throws IOException {
        BufferedWriter writerCars = new BufferedWriter(new FileWriter(this.fileName, true)); //zmienić nazwę writer Cars
        for (int i = 0; i < cars.size(); i++){
            writerCars.append(cars.get(i).mark);
            writerCars.append(separator);
            writerCars.append(cars.get(i).model);
            writerCars.append(separator);
            writerCars.append(cars.get(i).plate);
            writerCars.append(separator);
            writerCars.append(Integer.toString(cars.get(i).id));
            writerCars.append(separator);
            writerCars.append(cars.get(i).status);
            writerCars.append(separator);
            writerCars.append("\n");
        }
        writerCars.close();

    }
    List<CarData> readCar() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(this.fileName));
        String [] readCarsData;
        List<String> readCarData;
        String carsNew;
        List<CarData> cars = new ArrayList<CarData>();
        while ((carsNew = reader.readLine()) != null) { //miało być isValid ale chyaba już nie trzeba
            readCarsData = carsNew.split("\n");
            for(int j = 0; j < readCarsData.length; j++) {
                readCarData = Arrays.asList(readCarsData[j].split(separator));
                CarData readCar = new CarData(readCarData);
                cars.add(readCar);
            }
        }
        reader.close();
        return cars;
    }

}