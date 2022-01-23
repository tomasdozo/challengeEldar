package com.dozotomas.challenge;

import com.dozotomas.challenge.model.Amex;
import com.dozotomas.challenge.model.Card;
import com.dozotomas.challenge.model.Nara;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now().plusYears(1);
        String name = "Tomás Dozo";
        long number = Long.parseUnsignedLong("9999999999999999999");
        Card card = new Card(number, name, date, Nara.getInstance());

        //Información de la tarjeta
        System.out.println(card);

        //Información sobre una operación
        int value = 990;
        String isValidOp = card.isValidOperation(value) ? "valid" : "invalid";
        System.out.println("The operation for $" + value + " is " + isValidOp + ".");

        //Información sobre la tarjeta
        String isValidCard = card.isValidCard() ? "valid" : "invalid";
        System.out.println("The card is " + isValidCard + " for operate.");

        //Comparando dos tarjetas
        Card card2 = new Card(number, name, date, Amex.getInstance());
        if (card.equals(card2)) System.out.println("The cards are the same");
        else System.out.println("The cards aren't the same");

        try {
            System.out.println(card.rate(990));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
