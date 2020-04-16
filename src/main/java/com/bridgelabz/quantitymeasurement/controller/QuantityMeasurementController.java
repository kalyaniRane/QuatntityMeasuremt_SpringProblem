package com.bridgelabz.quantitymeasurement.controller;

import com.bridgelabz.quantitymeasurement.dto.UnitConversionDto;
import com.bridgelabz.quantitymeasurement.enums.SubUnits;
import com.bridgelabz.quantitymeasurement.enums.UnitType;
import com.bridgelabz.quantitymeasurement.services.QuantityMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuantityMeasurementController {

    @Autowired
    public QuantityMeasurementService quantityMeasurementService;

    @GetMapping("/unittype")
    public UnitType[] getUnits()
    {
        return quantityMeasurementService.getUnitType();
    }

    @GetMapping("/unittype/subunittype")
    public List<SubUnits> getSubUnits(@RequestParam("unittype") String unittype)
    {
        return quantityMeasurementService.getSubUnitType(unittype);
    }

    @PostMapping("/conversion/units")
    public double UnitConversion(@RequestBody UnitConversionDto unitConversionDto){
        return quantityMeasurementService.convertUnit(unitConversionDto);
    }

}
