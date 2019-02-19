package guava;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Building {
    private int floorNum;
    private boolean hasParking;
    private List<Flat> flats;
    private String color;
}
