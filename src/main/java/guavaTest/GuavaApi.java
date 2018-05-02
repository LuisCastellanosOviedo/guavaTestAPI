package guavaTest;

import com.google.common.base.*;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;


public class GuavaApi {





    public static Map<String,Car> createMap(){
        for (int i = 0; i <50 ; i++) {
            System.out.println("test rebase ");
        }
        return Maps.newHashMap();
    }


    public static void addElementToMap(Map<String, Car> map, String key, Car carTest) {
        map.put(key,carTest);
    }

    public static List<Car> createList() {
        return Lists.newArrayList();
    }

    public static List<Car> filterNullList(List<Car> carList) {
        return Lists.newArrayList( Collections2.filter(carList, Predicates.notNull()));
    }

    public static List<Car> filterCarByColor(List<Car> carList){
        return Lists.newArrayList(Collections2.filter(carList,FeaturePredicates.carColorPredicate()));
    }

    public static boolean allCarsHasColor(List<Car> carList){
        return Iterables.all(carList,FeaturePredicates.AllCarsHasColor());
    }

    public static List<Camioneta> convertToCamioneta(List<Car> carList){
        return Lists.newArrayList( Collections2.transform(carList,FeatureFunctionGuava.convertTOCamioneta()));
    }

    public static List<Boolean> anyHasResColor(List<Car> carList){
        return Lists.newArrayList(Collections2.transform(carList,Functions.compose(FeatureFunctionGuava.hasRedColor()
                ,FeatureFunctionGuava.convertTOCamioneta())));
    }


    public static String joinString(List<String> colores) {
        return Joiner.on(",").join(colores);
    }

}
