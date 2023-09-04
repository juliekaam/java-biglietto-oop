package BigliettoTreno;

import java.util.Scanner;

public class Biglietteria {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean isValid = false;

        Biglietto biglietto = null;
        while (!isValid) {
            System.out.println("numero di km:");
            int km = Integer.parseInt(scan.nextLine());

            System.out.println("digita l'eta:");
            int age = Integer.parseInt(scan.nextLine());
            //provo a creare un ogetto di tipo biglietto

            try {
                biglietto = new Biglietto(km, age);
                isValid = true;
                System.out.println("il Biglietto è valido");
            } catch (RuntimeException e) {
                if (km < 0) {
                    System.out.println("la distanza non puo essere meno di  0");
                } else if (age < 0 || age > 100) {
                    System.out.println("l'eta deve essere compresa tra 0 e100");
                }

            }
        }

        System.out.println(" Il tuo biglietto vale: " + biglietto.calcolaPrezzo() + "€");

        scan.close();
    }
}

