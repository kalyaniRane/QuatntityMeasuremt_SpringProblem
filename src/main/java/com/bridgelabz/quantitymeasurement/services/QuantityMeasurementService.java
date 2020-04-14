package com.bridgelabz.quantitymeasurement.services;

import com.bridgelabz.quantitymeasurement.enums.UnitType;
import org.springframework.stereotype.Service;

@Service
public class QuantityMeasurementService {

    public UnitType[] getUnitType() {
        return UnitType.values();
    }

}
