package be.continuum.data;

public class Car {

    private String brand;
    private String model;
    private int pollutionCo2;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPollutionCo2() {
        return pollutionCo2;
    }

    public void setPollutionCo2(int pollutionCo2) {
        this.pollutionCo2 = pollutionCo2;
    }
}
