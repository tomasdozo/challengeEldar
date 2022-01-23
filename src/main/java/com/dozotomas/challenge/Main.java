package com.dozotomas.challenge;

import com.dozotomas.challenge.model.Card;
import com.dozotomas.challenge.utils.BrandEnums;
import com.dozotomas.challenge.utils.Utils;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now().plusYears(1);
        String name = "Tomás Dozo";
        long number = Long.parseUnsignedLong("9999999999999999999");
        Card card = new Card(number, name, date, BrandEnums.NARA.getInstance());

        //Información de la tarjeta
        System.out.println(card);

        //Información sobre una operación
        int value = 990;
        String isValidOp = Utils.isValidOperation(value) ? "valid" : "invalid";
        System.out.println("The operation for $" + value + " is " + isValidOp + ".");

        //Información sobre la tarjeta
        String isValidCard = Utils.isValidCard(card) ? "valid" : "invalid";
        System.out.println("The card is " + isValidCard + " for operate.");

        //Comparando dos tarjetas
        Card card2 = new Card(number, name, date, BrandEnums.AMEX.getInstance());
        if (card.equals(card2)) System.out.println("The cards are the same");
        else System.out.println("The cards aren't the same");

        try {
            System.out.println("The final value of the operation is: $" + Utils.fee("visa",990.0));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
