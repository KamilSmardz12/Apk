package service;

import lombok.Getter;
import model.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import static service.Constants.*;

@Getter
public class WeatherData {
    private City city;
    private Humidity humidity;
    private LastUpdate lastUpdate;
    private Pressure pressure;
    private Temperature temperature;

    public void setAllWeatherDataByTagNames(Document doc) {
        NodeList list = doc.getElementsByTagName("current");
        Node node = list.item(0);
        Element rootElement = (Element) node;

        setAttribute(CITY, rootElement);
        setAttribute(COUNTRY, rootElement);
        setAttribute(TEMPERATURE, rootElement);
        setAttribute(HUMIDITY, rootElement);
        setAttribute(PRESSURE, rootElement);
        setAttribute(LAST_UPDATE, rootElement);
    }

    private void setAttribute(Constants attributeName, Element addElement) {
        String name = attributeName.getValue();
        NodeList listOfElements = addElement.getElementsByTagName(name);
        Node node = listOfElements.item(0);
        Element currentElement = (Element) node;

        switch (name) {
            case "city":
                city = new City(currentElement.getAttribute(ID.getValue()), currentElement.getAttribute(NAME.getValue()));
                break;
            case "country":
                city.setCountry(currentElement.getTextContent());
                break;
            case "temperature":
                temperature = new Temperature(currentElement.getAttribute(VALUE.getValue()), currentElement.getAttribute(UNIT.getValue()));
                break;
            case "humidity":
                humidity = new Humidity(currentElement.getAttribute(VALUE.getValue()), currentElement.getAttribute(UNIT.getValue()));
                break;
            case "pressure":
                pressure = new Pressure(currentElement.getAttribute(VALUE.getValue()), currentElement.getAttribute(UNIT.getValue()));
                break;
            case "lastupdate":
                lastUpdate = new LastUpdate(currentElement.getAttribute(VALUE.getValue()));
                break;
        }
    }

}
