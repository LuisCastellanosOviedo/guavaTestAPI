package guava;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables;

import java.util.ArrayList;
import java.util.List;

public class GuavaDojo {

    /*public static Building convertHouseIntoBuilding(House house, Function function){
        Function<House, Building> fun = function;

        return fun.apply(house);
    }

    public static Function<House, Building> getHouseBuildingFunction() {
        return new Function<House, Building>() {
                @Override
                public Building apply(House input) {
                    Building building = new Building(input.getFloorNum(),true);
                    return building;
                }
            };
    }*/

    public static List<Flat> filterFlatsByOccupancy( List<Building> buildings, Predicate<Flat> predicate ){

        return FluentIterable.from( buildings )
                .transformAndConcat( getFlats() )
                .filter( predicate )
                .toList();

    }

    private static Function<Building, List<Flat>> getFlats(){
        return new Function<Building, List<Flat>>() {
            @Override
            public List<Flat> apply(Building input) {
                return input.getFlats();
            }
        };
    }

    public static Predicate<Flat> getFilterByGato(int numPersonas){
        return new Predicate<Flat>() {
            @Override
            public boolean apply(Flat input) {
                return input.getPersons() == numPersonas;
            }
        };
    }

    public static Optional<Building> tryFindExample(List<Building> buildingList){

        return Iterables.tryFind(buildingList, new Predicate<Building>() {
            @Override
            public boolean apply(Building input) {
                return input.getColor().equalsIgnoreCase("YELLOW");
            }
        });

    }


}
