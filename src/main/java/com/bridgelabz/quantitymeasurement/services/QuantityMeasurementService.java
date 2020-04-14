package com.bridgelabz.quantitymeasurement.services;

import com.bridgelabz.quantitymeasurement.enums.SubUnits;
import com.bridgelabz.quantitymeasurement.enums.UnitType;
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

}
