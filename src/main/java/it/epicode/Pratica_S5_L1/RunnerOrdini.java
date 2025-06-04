package it.epicode.Pratica_S5_L1;

import it.epicode.Pratica_S5_L1.bean.Drink;
import it.epicode.Pratica_S5_L1.bean.Ordini;
import it.epicode.Pratica_S5_L1.bean.Pizza;
import it.epicode.Pratica_S5_L1.bean.Tavolo;
import it.epicode.Pratica_S5_L1.enumeration.StatoOrdine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@Order(3)
public class RunnerOrdini implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(RunnerOrdini.class);

    @Value("${costo.coperto}")
    private double costoCoperto;

    @Override
    public void run(String... args) throws Exception {

        log.info("Costo coperto letto da properties: {}", costoCoperto);

        // Creazione tavolo
        Tavolo tavolo1 = new Tavolo();
        tavolo1.setNumeroTavolo(5);
        tavolo1.setNumeroCoperti(3);
        tavolo1.setOccupato(true);

        // Creazione prodotti (esempio semplice)
        Pizza pizza = new Pizza();
        pizza.setNome("Margherita");
        pizza.setPrezzo(7.0);

        Drink drink = new Drink();
        drink.setNome("Acqua");
        drink.setPrezzo(2.0);

        // Creazione ordine
        Ordini ordine = new Ordini();
        ordine.setNumeroOrdine(1);
        ordine.setProdottiOrdinati(List.of(pizza, drink));
        ordine.setTavolo(tavolo1);
        ordine.setStratoOrdine(StatoOrdine.IN_CORSO);
        ordine.setOraDiAcquisizione(LocalDateTime.now());

        // Calcolo totale
        double totale = ordine.calcolaTotale(costoCoperto);

        // Stampa con logger
        log.info("Ordine n. {} per tavolo {}:", ordine.getNumeroOrdine(), tavolo1.getNumeroTavolo());
        log.info("Prodotti ordinati: {}", ordine.getProdottiOrdinati());
        log.info("Totale (prodotti + coperti): € {}", totale);
    }
}
