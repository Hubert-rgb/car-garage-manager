package HubertRoszyk.company;
import HubertRoszyk.company.MechanicData;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

class StorageManager { //filename podawane w konstruktorze
    String fileName;

    public StorageManager(String fileName) {
        this.fileName = fileName;
    }

    public void delateContent(String fileName) throws IOException { //literówka
        PrintWriter writer = new PrintWriter(fileName);
        writer.print("");
    }
    public void write(String[] str) throws IOException {
        BufferedWriter writerCars = new BufferedWriter(new FileWriter(this.fileName, true)); //zmienić nazwę writer Cars
        for (int i = 0; i < str.length; i++){ // length of array z str
            writerCars.append(str[i]); //str ==>
            writerCars.append(' '); //inne separatory
        }           // rozdzielanie poszczególnych objektów spacją
        writerCars.close();

    }
    public List<String[]> readCar() throws IOException {  //nazwy zmiennych
        BufferedReader reader = new BufferedReader(new FileReader(this.fileName));
        String [] carsNewData;
        String carsNew;
        List<String[]> cars = new ArrayList<String[]>();
        if ((carsNew = reader.readLine()) != null) {
            carsNewData = carsNew.split(" ");
            for (int i = 0; i < carsNewData.length; i += 3) {
                String[] carData = {carsNewData[i], carsNewData[i + 1], carsNewData[i + 2]};
                cars.add(carData);
            }
        }
        return cars;
    }
    public List<MechanicData> readMechanic(List<MechanicData> mechanics) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Mechanics.txt"));
        String [] readMechanicsArray;
        String readMechanicsString;

        if ((readMechanicsString = reader.readLine()) != null) {
            readMechanicsArray = readMechanicsString.split(" ");
            int a = 3;
            for (int i = 0; i < readMechanicsArray.length; i += a) {
                MechanicData mechanic = new MechanicData();
                a = 3;
                String[] mechanicData = {readMechanicsArray[i], readMechanicsArray[i + 1]};
                mechanic.data = mechanicData;

                int mehanicRepairigCars = Integer.parseInt(readMechanicsArray[i + 2]);
                mechanic.repearingCars = mehanicRepairigCars;

                if (mehanicRepairigCars > 0) {
                    a += (mehanicRepairigCars * 3);
                    String[] car1 = {readMechanicsArray[i + 3], readMechanicsArray[i + 4], readMechanicsArray[i + 5]};
                    switch (mehanicRepairigCars) { // zmienić na pętlę for
                        case 1:
                            mechanic.repairingCarsList.add(car1);
                            break;
                        case 2:
                            String[] car2 = {readMechanicsArray[i + 6], readMechanicsArray[i + 7], readMechanicsArray[i + 8]};
                            mechanic.repairingCarsList.add(car1);
                            mechanic.repairingCarsList.add(car2);
                    }

                }
                mechanics.add(mechanic);
            }
        }
        return (mechanics);
        //zmieniam coś
    }
}