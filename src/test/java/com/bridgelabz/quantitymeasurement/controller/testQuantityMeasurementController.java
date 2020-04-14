package com.bridgelabz.quantitymeasurement.controller;

import com.bridgelabz.quantitymeasurement.enums.UnitType;
import com.bridgelabz.quantitymeasurement.services.QuantityMeasurementService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@WebMvcTest(QuantityMeasurementController.class)
public class testQuantityMeasurementController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuantityMeasurementService service;

    @Test
    void givenUnits_WhenGetUnits_ShouldReturnJsonArray() throws Exception {
        UnitType[] expectedTypes={UnitType.LENGTH,UnitType.WEIGHT,UnitType.TEMPRATURE,UnitType.VOLUME};

        given(service.getUnitType()).willReturn(expectedTypes);
        mockMvc.perform(get("/unittype")).andDo(print())
                .andExpect(content().json(Arrays.toString(expectedTypes)));

    }

}
