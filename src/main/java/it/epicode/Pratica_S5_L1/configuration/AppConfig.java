package it.epicode.Pratica_S5_L1.configuration;

import it.epicode.Pratica_S5_L1.bean.Drink;
import it.epicode.Pratica_S5_L1.bean.Pizza;
import it.epicode.Pratica_S5_L1.bean.Topping;
import it.epicode.Pratica_S5_L1.enumeration.TipoDrink;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public Drink getWater() {
        Drink water = new Drink();
        water.setTipoDrink(TipoDrink.ANALCOLICO);
        water.setCalorie(0);
        water.setPrezzo(1);
        water.setNome("Water");
        return water;
    }

    @Bean(name = "tomato")
    @Primary
    public Topping getTomato() {
        Topping tomato = new Topping();
        tomato.setNome("Tomato");
        tomato.setPrezzo(1);
        tomato.setCalorie(100);
        tomato.setGlutenFree(true);
        return tomato;
    }

    @Bean(name = "mozzarella")
    public Topping getMozzarella() {
        Topping mozzarella = new Topping();
        mozzarella.setNome("Mozzarella");
        mozzarella.setPrezzo(1);
        mozzarella.setCalorie(200);
        mozzarella.setGlutenFree(true);
        return mozzarella;
    }

    @Bean
    public Pizza getPizza() {
        Pizza pizza = new Pizza();
        pizza.setNome("Pizza Margherita");
        pizza.setPrezzo(6.5);
        pizza.setCalorie(800);
        pizza.setToppings(List.of(getTomato(), getMozzarella()));
        return pizza;
    }
}
