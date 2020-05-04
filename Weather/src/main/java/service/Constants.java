package service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Constants {

    CITY("city"),
    COUNTRY("country"),
    HUMIDITY("humidity"),
    PRESSURE("pressure"),
    TEMPERATURE("temperature"),
    LAST_UPDATE("lastupdate"),
    UNIT("unit"),
    ID("id"),
    NAME("name"),
    VALUE("value");

  private final String value;
}
