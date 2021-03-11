package me.bangshinho.UrlShortener.dao;

import me.bangshinho.UrlShortener.entity.ShortUrl;
import me.bangshinho.UrlShortener.repository.ShortUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ConvertUrlDao {

    @Autowired
    private ShortUrlRepository shortUrlRepository;

    public boolean isExists(String url) {
        return shortUrlRepository.existsByOriginUrl(url);
    }

    public ShortUrl getShortUrlByOriginUrl(String url) {
        return shortUrlRepository.findByOriginUrl(url);
    }

    public void save(ShortUrl shortUrl) {
        shortUrlRepository.save(shortUrl);
    }

    public ShortUrl getShortUrlByShortUrl(String short_url) {
        return shortUrlRepository.findByUrl(short_url);
    }
}
