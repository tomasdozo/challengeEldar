package com.dozotomas.challenge;

import com.dozotomas.challenge.brands.Amex;
import com.dozotomas.challenge.exceptions.BrandNotFoundException;
import com.dozotomas.challenge.exceptions.InvalidOperationException;
import com.dozotomas.challenge.model.Card;
import com.dozotomas.challenge.brands.Nara;
import com.dozotomas.challenge.brands.Visa;
import com.dozotomas.challenge.utils.Utils;
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
        assertTrue(Utils.isValidOperation(999));
        assertFalse(Utils.isValidOperation(1001));
    }

    @Test
    void validCard() {
        assertTrue(Utils.isValidCard(card));
        card.setExpiration(LocalDate.now().minusYears(1));
        assertFalse(Utils.isValidCard(card));
    }

    @Test
    void unsignedLongTest() {
        assertEquals(Long.toUnsignedString(card.getNumber()), "9999999999999999999");
    }

    @Test
    void equals() {
        Card card1 = new Card(number, name, date, Visa.getInstance());

        card1.setBrand(Nara.getInstance());
        assertNotEquals(card, card1);
        card1.setBrand(Visa.getInstance());

        card1.setExpiration(LocalDate.now());
        assertNotEquals(card, card1);
        card1.setExpiration(date);

        card1.setCardholder("Indiana Jones");
        assertNotEquals(card, card1);
        card1.setCardholder(name);

        card1.setNumber(1234123412341234L);
        assertNotEquals(card, card1);
        card1.setNumber(number);

        assertEquals(card, card1);
    }

    @Test
    void feeTest() {
        double value = 500.0;
        try {
            assertEquals(Utils.fee("visa", value), (Visa.getInstance().rate() + 1) * value);
        } catch (Exception e) {
            fail();
        }
        try {
            assertEquals(Utils.fee("amex", value), (Amex.getInstance().rate() + 1) * value);
        } catch (Exception e) {
            fail();
        }try {
            assertEquals(Utils.fee("nara", value), (Nara.getInstance().rate() + 1) * value);
        } catch (Exception e) {
            fail();
        }

        assertThrows(InvalidOperationException.class, () -> Utils.fee("visa", 1001.0));
        assertThrows(BrandNotFoundException.class, () -> Utils.fee("visaa", 500.0));

    }
}
