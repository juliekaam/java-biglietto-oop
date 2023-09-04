package BigliettoTreno;

import java.math.BigDecimal;

public class Biglietto {
    /*Consegna: creare una classe Biglietto con due attributi interi: km e età del passeggero.
Nel costruttore vanno valorizzati entrambi gli attributi, assicurandosi che abbiano valori validi
(creare due metodi isValidKm e isValidEta che implementano questa logica).
 In caso anche solo uno non sia valido, sollevare un’eccezione. Aggiungere tre costanti:
il costo chilometrico di 21 centesimi di €/km (BigDecimal),
lo sconto over 65 del 40 % (BigDecimal)
lo sconto minorenni del 20% (BigDecimal).
Implementare il metodo public che calcola il prezzo del biglietto comprensivo di eventuale sconto (calcolaPrezzo).
Per eseguire il calcolo dello sconto aggiungere un metodo private calcolaSconto, da chiamare dentro al metodo calcolaPrezzo.*/
    private  int km;
    private  int age;

    private final BigDecimal COSTO_KM = new BigDecimal("0.21");
    private final BigDecimal OVER = new BigDecimal("0.4");
    private final BigDecimal MINORI = new BigDecimal("0.2");

    public Biglietto(int km, int age) throws RuntimeException{
        isValidKm(km);
        this.km = km;
        isValidEta(age);
        this.age = age;
    }
    private void isValidKm (int km){
       if(km<0){
           throw new RuntimeException();
       }
    }

    private void isValidEta(int age){
        if (age<0 || age>100){
            throw new RuntimeException();
        }
    }



    private BigDecimal calcolaSconto() {
        if (age > 65) {
            return OVER;
        } else if (age < 18) {
            return MINORI;
        } else {
            return new BigDecimal("1");

        }

    }


    public BigDecimal calcolaPrezzo() {
        BigDecimal prezzo = new BigDecimal(km);
        prezzo= prezzo.multiply(COSTO_KM);
        return prezzo.multiply(calcolaSconto());
    }
}

