package learn.springframework.spring6restmvc.repositories;

import jakarta.validation.ConstraintViolationException;
import learn.springframework.spring6restmvc.entities.Beer;
import learn.springframework.spring6restmvc.model.BeerStyle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class BeerRepositoryTest {
    @Autowired
    BeerRepository beerRepository;

    @Test
    void testSaveBeerNewTooLong() {
        assertThrows(ConstraintViolationException.class, () -> {
            Beer savedBeer = beerRepository.save(Beer.builder()
                    .beerName("My Beer 5720943587723098757209435877230987572094358772309875720943587723098757209435877230987572094358772309875720943587723098757209435877230987")
                    .beerStyle(BeerStyle.PALE_ALE)
                    .upc("6230948753240")
                    .price(new BigDecimal(11.19))
                    .build());

            beerRepository.flush();
        });
    }

    @Test
    void testSaveBeer() {
        Beer savedBeer = beerRepository.save(Beer.builder()
                        .beerName("My Beer")
                        .beerStyle(BeerStyle.PALE_ALE)
                        .upc("6230948753240")
                        .price(new BigDecimal("11.19"))
                .build());

        beerRepository.flush();

        assertThat(savedBeer).isNotNull();
        assertThat(savedBeer.getId()).isNotNull();
    }
}