package it.epicode.Pratica_S5_L1.bean;

import it.epicode.Pratica_S5_L1.enumeration.StatoOrdine;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Ordini {
    private List<Prodotto> prodottiOrdinati;
    private Tavolo tavolo;
    private int numeroOrdine;
    private StatoOrdine stratoOrdine;
    private LocalDateTime oraDiAcquisizione;

    public double calcolaTotale(double costoCoperto) {
        double totaleProdotti = prodottiOrdinati.stream()
                .mapToDouble(Prodotto::getPrezzo)
                .sum();
        double totaleCoperti = tavolo.getNumeroCoperti() * costoCoperto;
        return totaleProdotti + totaleCoperti;
    }

}

