package guavaTest;

import com.google.common.base.*;
import com.google.common.collect.*;

import java.util.List;
import java.util.Map;


public class GuavaApi {





    public static Map<String,Car> createMap(){
        for (int i = 0; i <50 ; i++) {
            System.out.println("test rebase ");
        }
        return Maps.newHashMap();
    }

    public void testRebase(){

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
        return allCarshasColorGeneric(carList,FeaturePredicates.allCarsHasColor());
    }


    public static boolean allCarshasColorGeneric(List<Car> carList,Predicate carPredicate){
        return Iterables.all(carList,carPredicate);
    }

    public static List<Camioneta> convertToCamioneta(List<Car> carList){
        return Lists.newArrayList( Collections2.transform(carList,FeatureFunctionGuava.convertTOCamioneta()));
    }

    public static List<Boolean> anyHasResColor(List<Car> carList){
        return Lists.newArrayList(Collections2.transform(carList,Functions.compose(FeatureFunctionGuava.hasRedColor()
                ,FeatureFunctionGuava.convertTOCamioneta())));
    }

    public static List<Car> convertToCar(List<Camioneta> camList){
        return Lists.newArrayList(Collections2.transform(camList, FeatureFunctionGuava.convertTOCar()));
    }


    public static String joinString(List<String> colores) {
        return Joiner.on(",").join(colores);
    }

    public static boolean listIsNull(List<String> colors){
        return colors==null ?true:Iterables.isEmpty(colors);
    }


    public static Map<String, Camioneta> convertToMap(List<Camioneta> camionetas,Function<Camioneta,String> createKey){
        return Maps.uniqueIndex(camionetas.iterator(),createKey);
    }

    public static Map<String,String> transformmap(Map<String,Camioneta> camionetasMap,Function<Camioneta,String> camionetaToString){
        return Maps.transformValues(camionetasMap,camionetaToString);
    }

}
