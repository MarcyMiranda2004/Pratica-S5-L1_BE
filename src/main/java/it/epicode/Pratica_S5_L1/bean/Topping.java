package it.epicode.Pratica_S5_L1.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class Topping extends Prodotto{
    private boolean glutenFree;
}