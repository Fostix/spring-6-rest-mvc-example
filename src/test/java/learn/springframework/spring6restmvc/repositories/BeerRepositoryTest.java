package learn.springframework.spring6restmvc.repositories;

import jakarta.validation.ConstraintViolationException;
import learn.springframework.spring6restmvc.bootstrap.BootstrapData;
import learn.springframework.spring6restmvc.entities.Beer;
import learn.springframework.spring6restmvc.model.BeerStyle;
import learn.springframework.spring6restmvc.services.BeerCsvServiceImpl;
import learn.springframework.spring6restmvc.services.BeerServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import({BootstrapData.class, BeerCsvServiceImpl.class})
class BeerRepositoryTest {
    @Autowired
    BeerRepository beerRepository;

    @Test
    void testGetBeerListByName() {
        List<Beer> list = beerRepository.findAllByBeerNameIsLikeIgnoreCase("%IPA%");

        assertThat(list.size()).isEqualTo(336);
    }

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