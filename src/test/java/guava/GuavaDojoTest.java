package guava;


import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class GuavaDojoTest {


    /*@Test
    public void validateHouseBuilding() {

        House house = new House(1, 3);
        Building building = GuavaDojo.convertHouseIntoBuilding(house, GuavaDojo.getHouseBuildingFunction());

        Assert.assertEquals(house.getFloorNum(),building.getFloorNum());

    }

    @Test
    public void testIterables() {
        List<House> houseList = Arrays.asList(new House(), new House(), null);

        Iterables.filter(houseList, Predicates.notNull());
        Iterables.filter(houseList, new Predicate<House>() {
            @Override
            public boolean apply(House input) {
                return input != null;
            }
        });
        FluentIterable.from(houseList)
                .transform(GuavaDojo.getHouseBuildingFunction()).toList();

    }*/

    @Test
    public void testFlatsWith4People(){
        List<Building> buildings = new ArrayList<>();
        List<Flat> flats = new ArrayList<>();
        Flat flat = new Flat(4);
        flats.add(flat);
        
        Flat flat2 = new Flat(5);
        flats.add(flat2);
        
        Flat flat3 = new Flat(4);
        flats.add(flat3);
        
        Flat flat4 = new Flat(4);
        flats.add(flat4);
        
        Flat flat5 = new Flat(1);
        flats.add(flat5);

        List<Flat> flatBs2 = new ArrayList<Flat>();
        Flat flatB = new Flat(4);
        flatBs2.add(flatB);

        Flat flatB2 = new Flat(4);
        flatBs2.add(flatB2);

        Flat flatB3 = new Flat(4);
        flatBs2.add(flatB3);

        Flat flatB4 = new Flat(4);
        flatBs2.add(flatB4);

        Flat flatB5 = new Flat(4);
        flatBs2.add(flatB5);

        Building building = new Building(1,true, flats,"BLUE");
        Building buildingB = new Building(1,true, flatBs2,"RED");
        buildings.add(building);
        buildings.add(buildingB);

        Assert.assertEquals(8, GuavaDojo
                .filterFlatsByOccupancy(buildings, GuavaDojo.getFilterByGato(4))
                .size());

        Assert.assertEquals(null, GuavaDojo.trñyFindExample(buildings).orNull());


    }


}
