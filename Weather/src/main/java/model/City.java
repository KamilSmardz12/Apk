package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class City {
    private final String id;
    private final String name;
    private String country;

    public City(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
