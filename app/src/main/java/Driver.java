import com.example.jatin.joybug.Carpooler;

public class Driver {
    private String name;
    private int age;
    private String location;
    private String bio;
    private String major;
    private String year;
    private String car;
    private String drivingHistory;

    Driver(String setName, int setAge, String setLocation, String setBio, String setMajor,
              String setYear, String setCar, String setDrivingHistory) {
        this.name = setName;
        this.age = setAge;
        this.location = setLocation;
        this.bio = setBio;
        this.major = setMajor;
        this.year = setYear;
        this.car = setCar;
        this.drivingHistory = setDrivingHistory;
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

    public String getCar() {
        return this.car;
    }

    public void setCar(String setCar) {
        this.car = setCar;
    }

    public String getDrivingHistory() {
        return this.drivingHistory;
    }

    public void setDrivingHistory(String setDrivingHistory) {
        this.drivingHistory = setDrivingHistory;
    }
}