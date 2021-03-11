package me.bangshinho.UrlShortener.repository;

import me.bangshinho.UrlShortener.entity.ShortUrl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ShortUrlRepositoryTest {

    @Autowired
    private ShortUrlRepository shortUrlRepository;

    @Test
    public void test(){

    }

    @Test
    public void findById() {
        ShortUrl shortUrl = new ShortUrl("https://www.naver.com");
        shortUrlRepository.save(shortUrl);

        ShortUrl findShortUrl = shortUrlRepository.findById(shortUrl.getId());

        Assertions.assertThat(shortUrl.getId()).isEqualTo(findShortUrl.getId());
        Assertions.assertThat(shortUrl.getOriginUrl()).isEqualTo(findShortUrl.getOriginUrl());
    }

    @Test
    public void existsByOriginUrl() {
        ShortUrl shortUrl = new ShortUrl("https://www.naver.com");
        shortUrlRepository.save(shortUrl);
        Assertions.assertThat(shortUrlRepository.existsByOriginUrl(shortUrl.getOriginUrl())).isTrue();
    }

    @Test
    public void findByOriginUrl() {
        ShortUrl shortUrl = new ShortUrl("https://www.naver.com");
        shortUrlRepository.save(shortUrl);

        ShortUrl findOriginUrl = shortUrlRepository.findByOriginUrl(shortUrl.getOriginUrl());

        Assertions.assertThat(shortUrl.getId()).isEqualTo(findOriginUrl.getId());
        Assertions.assertThat(shortUrl.getOriginUrl()).isEqualTo(findOriginUrl.getOriginUrl());
    }

    @Test
    public void findByUrl() {
        ShortUrl shortUrl = new ShortUrl("https://www.naver.com");
        shortUrl.setUrl("http://localhost:8080/Bde22");
        shortUrlRepository.save(shortUrl);

        ShortUrl findShortUrl = shortUrlRepository.findById(shortUrl.getId());

        Assertions.assertThat(shortUrl.getId()).isEqualTo(findShortUrl.getId());
        Assertions.assertThat(shortUrl.getOriginUrl()).isEqualTo(findShortUrl.getOriginUrl());
    }
}