package convert;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Person;
import java.util.List;

public class JSONConverter {

    Gson gson;

    public JSONConverter() {
        gson = new GsonBuilder().
                setPrettyPrinting().
                setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).
                create();
    }

    public static Person getPersonFromJSon(String js) {
        return null;
    }

    public static String getJSONFromPerson(Person p) {

        return null;
    }

    public static String getJSONFromPerson(List<Person> persons) {

        return null;
    }
}
