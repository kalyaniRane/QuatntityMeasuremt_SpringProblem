package com.bridgelabz.quantitymeasurement.services;

import com.bridgelabz.quantitymeasurement.dto.UnitConversionDto;
import com.bridgelabz.quantitymeasurement.enums.SubUnits;
import com.bridgelabz.quantitymeasurement.enums.UnitType;
import com.bridgelabz.quantitymeasurement.exception.QuantityMeasurementException;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuantityMeasurementService{

    public UnitType[] getUnitType() {
        return UnitType.values();
    }

    public List<SubUnits> getSubUnitType(String unittype){
        SubUnits[] subUnits=SubUnits.values();
        List<SubUnits> collect = Arrays.stream(subUnits)
                .filter(unit -> unit.unitType.equals(UnitType.valueOf(unittype)))
                .collect(Collectors.toList());
        return collect;
    }

    public double convertUnit(UnitConversionDto unitConversionDto) {
        if(unitConversionDto.getSubUnits1().unitType.equals(unitConversionDto.getSubUnits2().unitType)
                && !unitConversionDto.getSubUnits1().unitType.equals(UnitType.TEMPERATURE)){
            return (unitConversionDto.getQuantity()*unitConversionDto.getSubUnits1().value)/unitConversionDto.getSubUnits2().value;
        }else if(unitConversionDto.getSubUnits1().unitType.equals(unitConversionDto.getSubUnits2().unitType)
                && unitConversionDto.getSubUnits1().unitType.equals(UnitType.TEMPERATURE)) {
            if(unitConversionDto.getSubUnits1().equals(SubUnits.CELSIUS) && unitConversionDto.getSubUnits2().equals(SubUnits.FAHRENHEIT)){
                return (unitConversionDto.getQuantity()*unitConversionDto.getSubUnits1().value)+32;
            }
            else if (unitConversionDto.getSubUnits1().equals(SubUnits.FAHRENHEIT) && unitConversionDto.getSubUnits2().equals(SubUnits.CELSIUS)){
                return (unitConversionDto.getQuantity()-32)*unitConversionDto.getSubUnits1().value;
            }
        }

        throw new QuantityMeasurementException("Units Are MisMatch");
    }

}
