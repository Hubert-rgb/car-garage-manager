package HubertRoszyk.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MechanicsStorageManager {
    private String fileName;
    private String separator = ";";
    public MechanicsStorageManager(String fileName) {
        this.fileName = fileName;
    }

    public void deleteContent() throws IOException { //literówka
        PrintWriter writer = new PrintWriter(fileName);
        writer.print("");
    }
    void write(List<String> mechanicsList) throws IOException {
        BufferedWriter writerMechanics = new BufferedWriter(new FileWriter(this.fileName, true));
        for (int i = 0; i < mechanicsList.size(); i++){
            writerMechanics.append(mechanicsList.get(i));
            writerMechanics.append(separator);
        }
        writerMechanics.append("\n");
        writerMechanics.close();

    }
    public List<MechanicData> readMechanic() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Mechanics.txt"));
        List<MechanicData> mechanics = new ArrayList<MechanicData>();
        List<String> readMechanicArray;
        String readMechanics;

        while ((readMechanics = reader.readLine()) != null) {
            readMechanicArray = Arrays.asList(readMechanics.split(separator));

            MechanicData mechanic = new MechanicData(readMechanicArray);

            mechanics.add(mechanic);
        }
        reader.close();
        return (mechanics);
    }
}
