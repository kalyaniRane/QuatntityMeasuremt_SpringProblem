package com.bridgelabz.quantitymeasurement.enums;

public enum SubUnits {
    FOOT(UnitType.LENGTH,12.0),INCH(UnitType.LENGTH, 1.0), YARD(UnitType.LENGTH, 36.0),CENTIMETER(UnitType.LENGTH, 1/2.5),
    GALLON(UnitType.VOLUME, 3.785),LITRE(UnitType.VOLUME, 1.0),MILLILITRE(UnitType.VOLUME, 1/1000.0),
    GRAMS(UnitType.WEIGHT, 1/1000.0),KILOGRAMS(UnitType.WEIGHT, 1.0),TONNE(UnitType.WEIGHT, 1000.0),
    FAHRENHEIT(UnitType.TEMPERATURE, 0.5556),CELSIUS(UnitType.TEMPERATURE, 9/5.0);

    public double value;
    public UnitType unitType;
    SubUnits(UnitType unitType, double value) {
        this.unitType=unitType;
        this.value=value;
    }
}
