package com.bridgelabz.quantitymeasurement.controller;

import com.bridgelabz.quantitymeasurement.dto.UnitConversionDto;
import com.bridgelabz.quantitymeasurement.dto.UnitConversionResponseDto;
import com.bridgelabz.quantitymeasurement.services.QuantityMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuantityMeasurementController {

    @Autowired
    public QuantityMeasurementService quantityMeasurementService;

    @GetMapping("/unittype")
    public ResponseEntity getUnits()
    {
        return new ResponseEntity(quantityMeasurementService.getUnitType(), HttpStatus.OK);

    }

    @GetMapping("/unittype/subunittype")
    public ResponseEntity getSubUnits(@RequestParam("unittype") String unittype)
    {
        return new ResponseEntity(quantityMeasurementService.getSubUnitType(unittype), HttpStatus.OK);
    }

    @PostMapping("/conversion/units")
    public ResponseEntity UnitConversion(@RequestBody UnitConversionDto unitConversionDto){
        double result = quantityMeasurementService.convertUnit(unitConversionDto);
        UnitConversionResponseDto responseDto=new UnitConversionResponseDto(200,"Response Successful",result);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

}
