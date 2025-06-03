package it.epicode.Pratica_S5_L1.bean;

import it.epicode.Pratica_S5_L1.enumeration.TipoDrink;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data//creare automaticamente tutti i metodi di base di una classe attraverso Lombok
@NoArgsConstructor//crea il costruttore vuoto
@ToString(callSuper = true)//questa annotazione fa capire a Spring che deve chiamare
//anche il ToString della superclasse
public class Drink extends Prodotto{
    private TipoDrink tipoDrink;
}
