package guavaTest;



public class Camioneta {


private boolean hasPlaton;
private int Sites;
private String color;


    public Camioneta(boolean hasPlaton, int sites, String color) {
        this.hasPlaton = hasPlaton;
        Sites = sites;
        this.color = color;
    }


    public Camioneta() {

    }


    public boolean isHasPlaton() {
        return hasPlaton;
    }

    public void setHasPlaton(boolean hasPlaton) {
        this.hasPlaton = hasPlaton;
    }

    public int getSites() {
        return Sites;
    }

    public void setSites(int sites) {
        Sites = sites;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
