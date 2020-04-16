package com.bridgelabz.quantitymeasurement.controller;

import com.bridgelabz.quantitymeasurement.dto.UnitConversionDto;
import com.bridgelabz.quantitymeasurement.dto.UnitConversionResponseDto;
import com.bridgelabz.quantitymeasurement.enums.SubUnits;
import com.bridgelabz.quantitymeasurement.enums.UnitType;
import com.bridgelabz.quantitymeasurement.services.QuantityMeasurementService;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(QuantityMeasurementController.class)
public class testQuantityMeasurementController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuantityMeasurementService service;


    UnitConversionDto conversionDto;
    Gson gson;
    @BeforeEach
    void setUp() {
        conversionDto=new UnitConversionDto(SubUnits.FOOT,SubUnits.INCH,1);
        gson=new Gson();
    }

    @Test
    void givenUnits_WhenGetUnits_ShouldReturnJsonArray() throws Exception {
        UnitType[] expectedTypes={UnitType.LENGTH,UnitType.WEIGHT,UnitType.TEMPERATURE,UnitType.VOLUME};

        given(service.getUnitType()).willReturn(expectedTypes);
        mockMvc.perform(get("/unittype")).andDo(print())
                .andExpect(content().json(Arrays.toString(expectedTypes)));

    }

    @Test
    void givenSubUnits_WhenGetSubUnits_ShouldReturnJsonArray() throws Exception {
        List<SubUnits> subUnits= new ArrayList<>();
        subUnits.add(SubUnits.FOOT);
        subUnits.add(SubUnits.INCH);
        subUnits.add(SubUnits.YARD);
        subUnits.add(SubUnits.CENTIMETER);

        given(service.getSubUnitType(anyString())).willReturn(subUnits);
        mockMvc.perform(get("/unittype/subunittype?unittype=LENGTH")).andDo(print())
                .andExpect(content().json(String.valueOf(subUnits)));

    }

    @Test
    void testConvertUnits() throws Exception {
        String  jsonDto = gson.toJson(conversionDto);

        when(service.convertUnit(any())).thenReturn(12.0);
        mockMvc.perform(post("/conversion/units")
                .content(jsonDto)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(String.valueOf(12.0)));

    }

    @Test
    void givenUnit_WhenConvertSecondUnit_ShouldReturnResult() throws Exception {
        String  jsonDto = gson.toJson(conversionDto);

        when(service.convertUnit(any())).thenReturn(12.0);
        MvcResult mvcResult = mockMvc.perform(post("/conversion/units")
                .content(jsonDto)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();
        UnitConversionResponseDto responseDto = gson.fromJson(contentAsString, UnitConversionResponseDto.class);
        double responseData = (double) responseDto.getResponseData();
        Assert.assertEquals(12,responseData,0.0);

    }

}
