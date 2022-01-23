package com.dozotomas.challenge;

import com.dozotomas.challenge.exceptions.InvalidCardException;
import com.dozotomas.challenge.exceptions.InvalidOperationException;
import com.dozotomas.challenge.model.Card;
import com.dozotomas.challenge.model.Nara;
import com.dozotomas.challenge.model.Visa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChallengeApplicationTests {
    private LocalDate date;
    private String name;
    private long number;
    private Card card;

    @BeforeEach
    void setUp() {
        date = LocalDate.now().plusYears(1);
        name = "Tomás Dozo";
        number = Long.parseUnsignedLong("9999999999999999999");
        card = new Card(number, name, date, Visa.getInstance());

    }

    @Test
    void testingGettersAndSetters() {
        assertEquals(card.getCardholder(), name);
        assertEquals(Long.compareUnsigned(card.getNumber(), number), 0);
        assertEquals(card.getBrand(), Visa.getInstance());
        assertEquals(card.getExpiration(), date);
    }

    @Test
    void validOperation() {
        assertTrue(card.isValidOperation(999));
        assertFalse(card.isValidOperation(1001));
        assertThrows(InvalidOperationException.class, () -> card.rate(1001));
    }

    @Test
    void validCard() {
        assertTrue(card.isValidCard());
        card.setExpiration(LocalDate.now().minusYears(1));
        assertFalse(card.isValidCard());
        assertThrows(InvalidCardException.class, () -> card.rate(50));
    }

    @Test
    void unsignedLongTest() {
        assertEquals(Long.toUnsignedString(card.getNumber()), "9999999999999999999");
    }

    @Test
    void equals(){
        Card card1 = new Card(number,name,date,Visa.getInstance());

        card1.setBrand(Nara.getInstance());
        assertNotEquals(card,card1);
        card1.setBrand(Visa.getInstance());

        card1.setExpiration(LocalDate.now());
        assertNotEquals(card,card1);
        card1.setExpiration(date);

        card1.setCardholder("Indiana Jones");
        assertNotEquals(card,card1);
        card1.setCardholder(name);

        card1.setNumber(1234123412341234L);
        assertNotEquals(card,card1);
        card1.setNumber(number);

        assertEquals(card,card1);
    }

}
