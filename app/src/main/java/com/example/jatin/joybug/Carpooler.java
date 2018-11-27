package com.example.jatin.joybug;

public class Carpooler extends Carpoolers{
    private String username;
    private String password;
    private String name;
    private int age;
    private String location;
    private String bio;
    private String major;
    private String year;

    Carpooler(String setUsername, String setPassword, String setName, int setAge,
              String setLocation, String setBio, String setMajor, String setYear) {
        super(setUsername, setPassword, setName, setAge, setLocation, setBio, setMajor, setYear);
        this.name = setName;
        this.age = setAge;
        this.location = setLocation;
        this.bio = setBio;
        this.major = setMajor;
        this.year = setYear;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String setName) {
        this.name = setName;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int setAge) {
        this.age = setAge;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String setLocation) {
        this.location = setLocation;
    }

    public String getBio() {
        return this.location;
    }

    public void setBio(String setBio) {
        this.bio = setBio;
    }

    public String getMajor() {
        return this.major;
    }

    public void setMajor(String setMajor) {
        this.major = setMajor;
    }

    public String getYear() {
        return this.year;
    }

    public void setYear(String setYear) {
        this.year = setYear;
    }
}

//public class Example{
//    public static void main(String[] unused) {
//        Carpooler x = new Carpooler("ok", 18, "", "", "",
//                " ");
//        System.out.println(x.getAge());
//    }
//}