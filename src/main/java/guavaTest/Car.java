package guavaTest;

public class Car {


private String color;
private int tireNumber;
private String brand;


    public Car(String color, int tireNumber, String brand) {
        this.color = color;
        this.tireNumber = tireNumber;
        this.brand = brand;
    }

    public Car() {
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getTireNumber() {
        return tireNumber;
    }

    public void setTireNumber(int tireNumber) {
        this.tireNumber = tireNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}

