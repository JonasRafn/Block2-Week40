package facade;

import entity.Person;
import java.util.List;

public interface CRUDInterface {

    public Person addPerson(Person p);
    public Person delestPerson(int id);
    public Person getPerson(int id);
    public List<Person> getPersons();
    public Person editPerson(Person p);
}
