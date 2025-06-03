package it.epicode.Pratica_S5_L1;

import it.epicode.Pratica_S5_L1.bean.Drink;
import it.epicode.Pratica_S5_L1.bean.Pizza;
import it.epicode.Pratica_S5_L1.bean.Topping;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class Runner implements CommandLineRunner {

    private final Drink water;
    private final Topping mozzarella;
    private final Topping tomato;
    private final Pizza pizza;

    public Runner(Drink water, @Qualifier("mozzarella") Topping mozzarella,
                  @Qualifier("tomato") Topping tomato, Pizza pizza) {
        this.water = water;
        this.mozzarella = mozzarella;
        this.tomato = tomato;
        this.pizza = pizza;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(water);
        System.out.println(mozzarella);
        System.out.println(tomato);
        System.out.println(pizza);
    }
}
