package com.bridgelabz.quantitymeasurement.dto;

import com.bridgelabz.quantitymeasurement.enums.SubUnits;

public class UnitConversionDto {
    SubUnits subUnits1;
    SubUnits subUnits2;
    double quantity;

    public UnitConversionDto(SubUnits subUnits1, SubUnits subUnits2, double quantity) {
        this.subUnits1 = subUnits1;
        this.subUnits2 = subUnits2;
        this.quantity = quantity;
    }

    public SubUnits getSubUnits1() {
        return subUnits1;
    }

    public SubUnits getSubUnits2() {
        return subUnits2;
    }

    public double getQuantity() {
        return quantity;
    }
}
