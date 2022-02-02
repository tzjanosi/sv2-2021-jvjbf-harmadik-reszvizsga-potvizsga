package streams;

import java.util.List;

public class Apartment {
    private String city;
    private int area;
    private BathRoomType bathRoomType;
    private List<String> extras;

    public Apartment(String city, int area, BathRoomType bathRoomType, List<String> extras) {
        this.city = city;
        this.area = area;
        this.bathRoomType = bathRoomType;
        this.extras = extras;
    }

    public boolean containsAllExtras(String ... extrasToCheck){
        for (String extra: extrasToCheck) {
            if(!extras.contains(extra)){
                return false;
            }
        }
        return true;
    }

    public String getLocation() {
        return city;
    }

    public int getSize() {
        return area;
    }

    public BathRoomType getBathRoomType() {
        return bathRoomType;
    }

    public List<String> getExtras() {
        return extras;
    }
}
