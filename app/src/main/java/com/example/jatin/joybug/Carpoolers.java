package com.example.jatin.joybug;
import java.util.List;
import java.util.ArrayList;

public class Carpoolers {
    private List carpoolers = new ArrayList();

    Carpoolers(String setUserName, String setPassword, String setName, int setAge,
               String setLocation, String setBio, String setMajor,
              String setYear) {
        List newCarpooler = new ArrayList();
        newCarpooler.add(setUserName);
        newCarpooler.add(setPassword);
        newCarpooler.add(setName);
        newCarpooler.add(setAge);
        newCarpooler.add(setLocation);
        newCarpooler.add(setBio);
        newCarpooler.add(setMajor);
        newCarpooler.add(setYear);
        this.carpoolers.add(newCarpooler);
        System.out.println("run");
        System.out.println(carpoolers);
    }

    public List showCarpoolers() {
        return this.carpoolers;
    }

    public static void main(String[] unused) {
        Carpooler x = new Carpooler("ok", "ok", "ok", 1,
                "ok","ok", "ok", "ok");
        Carpooler y = new Carpooler("ok", "ok", "ok", 2,
                "ok","ok", "ok", "ok");
        Carpooler z = new Carpooler("ok", "ok", "ok", 3,
                "ok","ok", "ok", "ok");
        List ok = x.showCarpoolers();
        for (int i = 0; i < ok.size(); i++) {
            System.out.println(ok.get(i));
        }
    }
}
