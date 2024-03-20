package com.seccion4.InyeccionDependenciaFactura;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.seccion4.InyeccionDependenciaFactura.models.Item;
import com.seccion4.InyeccionDependenciaFactura.models.Product;

@Configuration
@PropertySources({@PropertySource(value ="classpath:data.properties", encoding = "UTF-8" )})
/* @PropertySource("classpath:data.properties") */
public class AppConfig {

    @Bean
    /* @Primary */
    List<Item> itemsInvoice() {
        Product p1 = new Product("Camara", 800);
        Product p2 = new Product("Bicicleta", 1200);
        return Arrays.asList(new Item(p1, 2),
                new Item(p2, 4));
    }

    @Bean("default")
    List<Item> itemsInvoiceOficce() {
        Product p1 = new Product("Monitor", 700);
        Product p2 = new Product("Notebook", 2400);
        Product p3 = new Product("Silla", 800);
        Product p4 = new Product("Impresora HP", 900);
        return Arrays.asList(new Item(p1, 4),
                new Item(p2, 6),
                new Item(p3, 1),
                new Item(p4, 4));
    }
}
