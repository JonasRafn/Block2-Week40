package test;

import control.Control;
import entity.Person;

public class Tester {
    public static void main(String[] args) {
        Control control = new Control();
        
        Person p = new Person();
        p.setfName("Lars");
        p.setlName("Mortensen");
        p.setPhone("12345678");
        control.addPerson(p);
        
        Person p1 = new Person();
        p1.setfName("Jan");
        p1.setlName("Jansen");
        p1.setPhone("12345571");
        control.addPerson(p1);
    }
}
