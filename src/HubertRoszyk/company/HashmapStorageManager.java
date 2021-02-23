package HubertRoszyk.company;

import java.io.*;
import java.util.*;

public class HashmapStorageManager {
    private String fileName;
    private String separator = ";";
    public HashmapStorageManager(String fileName) {
        this.fileName = fileName;
    }

    public void deleteContent() throws IOException { //literówka
        PrintWriter writer = new PrintWriter(fileName);
        writer.print("");
    }
    void write(HashMap<String, List<String>> hashmap) throws IOException {
        BufferedWriter writerHashmap = new BufferedWriter(new FileWriter(this.fileName, true));
        for(Map.Entry<String, List<String>> entry : hashmap.entrySet()) { //nie wiem jak to działa
            writerHashmap.write(entry.getKey() + separator);
            for(int i = 0; i < entry.getValue().size(); i++) {
                writerHashmap.write(entry.getValue().get(i) + separator);
            }
            writerHashmap.append("\n");
        }

        writerHashmap.close();

    }
    public HashMap<String, List<String>> readHashmap() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String [] readHashmap;
        List<String> readHashmapArray;
        String hashmapKey;
        HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>();
        String readHashmapString;

        while ((readHashmapString = reader.readLine()) != null) {
            List<String> hashmapValue = new ArrayList<String>();
            readHashmap = readHashmapString.split("\n");
            for (int i = 0; i < readHashmap.length; i ++) { // co tutaj?
                readHashmapArray = Arrays.asList(readHashmap[i].split(separator));
                hashmapKey = readHashmapArray.get(0);
                for(int j = 1; j < readHashmapArray.size(); j++) {
                    hashmapValue.add(readHashmapArray.get(j));
                }
                hashMap.put(hashmapKey, hashmapValue);
            }
        }
        reader.close();
        return hashMap;
    }
}
