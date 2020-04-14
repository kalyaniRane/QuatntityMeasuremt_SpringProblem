package com.bridgelabz.quantitymeasurement.controller;

import com.bridgelabz.quantitymeasurement.enums.UnitType;
import com.bridgelabz.quantitymeasurement.services.QuantityMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuantityMeasurementController {

    @Autowired
    public QuantityMeasurementService quantityMeasurementService;

    @GetMapping("/unittype")
    public UnitType[] getUnits()
    {
        return quantityMeasurementService.getUnitType();
    }

}
