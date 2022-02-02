package streams;

import java.util.ArrayList;
import java.util.List;

public class ApartmentRental {
    private List<Apartment> apartmentsList=new ArrayList<>();

    public void addApartment(Apartment apartment){
        if(apartment==null){
            throw new IllegalArgumentException("Apartment mustn't be null!");
        }
        apartmentsList.add(apartment);
    }

    public List<Apartment> findApartmentByLocation(String city){
        return apartmentsList.stream()
                .filter(a -> a.getLocation().equals(city))
                .toList();
    }

    public List<Apartment> findApartmentByExtras(String ... extrasToCheck){
        return apartmentsList.stream()
                .filter(a->a.containsAllExtras(extrasToCheck))
                .toList();
    }

    public boolean isThereApartmentWithBathroomType(BathRoomType bathRoomType){
        return apartmentsList.stream()
                .anyMatch(a->a.getBathRoomType()==bathRoomType);
    }

    public List<Integer> findApartmentsSize(){
        return apartmentsList.stream()
                .map(a->a.getSize())
                .toList();
    }
}
