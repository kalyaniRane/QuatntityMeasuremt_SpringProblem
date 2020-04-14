package com.bridgelabz.quantitymeasurement.service;

import com.bridgelabz.quantitymeasurement.enums.UnitType;
import com.bridgelabz.quantitymeasurement.services.QuantityMeasurementService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class testQuantityMeasurementService {

    @Test
    public void givenUnitType_WhenNotNull_ShouldReturnTrue() {
        QuantityMeasurementService service=new QuantityMeasurementService();
        QuantityMeasurementService service1=new QuantityMeasurementService();

        UnitType[] unitType = service.getUnitType();
//        UnitType[] unitType1 = service1.getUnitType();

        Assert.assertNotNull(unitType);
    }

}
