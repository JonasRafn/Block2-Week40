package utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class DataGenerator {
    
    private static List<String> fnames = new ArrayList() {
        {
        add("Don");
        add("John");
        add("Arnold");
        }
    };
    
    private static List<String> lnames = new ArrayList() {
        {
        add("Rambo");
        add("Schwarzenegger");
        add("Johnson");
        }
    };
    
    private static List<String> streets = new ArrayList() {
        {
        add("Allegade 12");
        add("Lærkevej 10");
        add("Torvet 3");
        }
    };
    
    private static List<String> cities = new ArrayList() {
        {
        add("Aarhus");
        add("Lyngby");
        add("Kolding");
        }
    };
    
    
    
    public static String generateData(int num, String data) {
        
        String[] fields = data.split(",");
        String res = ""; 
        JsonArray names = new JsonArray();
        
        if (fields.length < 1) 
            return res;
        
        for (int i = 0; i < num; i++) {
            
            JsonObject person = new JsonObject();
            person.addProperty(fields[0], fnames.get(ThreadLocalRandom.current().nextInt(1, fnames.size())));
            
            if (fields.length > 1) 
                person.addProperty(fields[1], lnames.get(ThreadLocalRandom.current().nextInt(1, lnames.size())));
            
            if (fields.length > 2) 
                person.addProperty(fields[2], streets.get(ThreadLocalRandom.current().nextInt(1, streets.size())));
            
            if (fields.length > 3) 
                person.addProperty(fields[3], cities.get(ThreadLocalRandom.current().nextInt(1, cities.size())));
            
            
            names.add(person);
        }
        
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        res = gson.toJson(names); 
        
        return res;
    }
    
}