package com.udea.sitas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

@ExtendWith(MockitoExtension.class)
public class SitasApplicationTest {

    @Spy
    ModelMapper modelMapper;

    @Test
    public void contextLoads() {
        Assertions.assertEquals(1,1);
    }
}
