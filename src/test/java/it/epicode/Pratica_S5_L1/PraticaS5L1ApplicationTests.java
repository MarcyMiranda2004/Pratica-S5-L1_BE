package it.epicode.Pratica_S5_L1;

import it.epicode.Pratica_S5_L1.bean.Drink;
import it.epicode.Pratica_S5_L1.bean.Pizza;
import it.epicode.Pratica_S5_L1.bean.Tavolo;
import it.epicode.Pratica_S5_L1.bean.Topping;
import it.epicode.Pratica_S5_L1.enumeration.TipoDrink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PraticaS5L1ApplicationTests {

	@Autowired
	private ApplicationContext context;

	// Test 1
	@Test
	void tablesExists() {
		Tavolo tavolo1 = context.getBean("tavolo1", Tavolo.class);
		assertEquals("it.epicode.Pratica_S5_L1.bean.Tavolo", tavolo1.getClass().getName());
	}

	// Test 2
	@Test
	@DisplayName("Test Drink: Water bean")
	void testWaterBean() {
		Drink water = context.getBean("getWater", Drink.class);
		assertEquals("Water", water.getNome());
		assertEquals(0, water.getCalorie());
		assertEquals(1, water.getPrezzo());
		assertEquals(TipoDrink.ANALCOLICO, water.getTipoDrink());
	}

	// Test 3
	@Test
	@DisplayName("Test Topping Tomato is gluten-free and calorie count")
	void testTomatoTopping() {
		Topping tomato = context.getBean("tomato", Topping.class);
		assertTrue(tomato.isGlutenFree());
		assertEquals(100, tomato.getCalorie());
	}

	// Test 4
	@Test
	@DisplayName("Test Pizza composition with toppings")
	void testPizzaComposition() {
		Pizza pizza = context.getBean("getPizza", Pizza.class);
		assertEquals("Pizza Margherita", pizza.getNome());
		assertEquals(2, pizza.getToppings().size());
		List<String> toppingNames = pizza.getToppings().stream().map(Topping::getNome).toList();
		assertTrue(toppingNames.contains("Tomato"));
		assertTrue(toppingNames.contains("Mozzarella"));
	}

	// Test 5
	@ParameterizedTest
	@CsvSource({
			"Tomato, 1, 100, true",
			"Mozzarella, 1, 200, true"
	})
	@DisplayName("Test parametrico sui topping")
	void testToppingsParametrizzati(String nome, double prezzo, int calorie, boolean glutenFree) {
		Topping topping = switch (nome) {
			case "Tomato" -> context.getBean("tomato", Topping.class);
			case "Mozzarella" -> context.getBean("mozzarella", Topping.class);
			default -> throw new IllegalArgumentException("Topping non valido: " + nome);
		};

		assertEquals(nome, topping.getNome());
		assertEquals(prezzo, topping.getPrezzo());
		assertEquals(calorie, topping.getCalorie());
		assertEquals(glutenFree, topping.isGlutenFree());
	}

}
