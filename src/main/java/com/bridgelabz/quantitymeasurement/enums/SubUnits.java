package com.bridgelabz.quantitymeasurement.enums;

public enum SubUnits {
    FOOT(UnitType.LENGTH),INCH(UnitType.LENGTH), YARD(UnitType.LENGTH),CENTIMETER(UnitType.LENGTH),
    GALLON(UnitType.VOLUME),LITRE(UnitType.VOLUME),MILLILITRE(UnitType.VOLUME),
    GRAMS(UnitType.WEIGHT),KILOGRAMS(UnitType.WEIGHT),TONNE(UnitType.WEIGHT),
    FAHRENHEIT(UnitType.TEMPERATURE),CELSIUS(UnitType.TEMPERATURE);

    public UnitType unitType;
    SubUnits(UnitType unitType) {
        this.unitType=unitType;
    }
}
