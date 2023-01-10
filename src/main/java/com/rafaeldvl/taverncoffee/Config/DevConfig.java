package com.rafaeldvl.taverncoffee.Config;

import com.rafaeldvl.taverncoffee.Services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {

    @Autowired
    private DBService dbService;

    @Value("${spring.profiles.active}")
    private String value;

    @Bean
    public boolean instanciaDB(){
        if(value.equals("create")) {
            this.dbService.instanciaDB();
        }
        return false;
    }

}
