package com.example.demo.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : K.M.G.I.K.konara
 * @Time :11:58 AM
 * @since : 2/12/2024
 **/
@Configuration
public class ModelmapperConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
