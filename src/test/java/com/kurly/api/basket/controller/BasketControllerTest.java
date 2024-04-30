package com.kurly.api.basket.controller;


import com.kurly.api.basket.service.impl.BasketServiceImpl;
import com.kurly.api.jpa.repository.BasketProductRepository;
import com.kurly.api.jpa.repository.BasketRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;



class BasketControllerTest {

    @Mock
    private BasketRepository basketRepository;

    @Mock
    private BasketProductRepository basketProductRepository;

    @InjectMocks
    private BasketServiceImpl basketServiceImpl;

    @Test
    void updateBasket() {
            //when


        //given

        //then

    }
}