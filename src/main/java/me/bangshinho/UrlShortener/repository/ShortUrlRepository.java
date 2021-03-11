package me.bangshinho.UrlShortener.repository;

import me.bangshinho.UrlShortener.entity.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortUrlRepository extends JpaRepository<ShortUrl, Long> {

    ShortUrl findById(long id);

    boolean existsByOriginUrl(String url);

    ShortUrl findByOriginUrl(String url);

    ShortUrl findByUrl(String short_url);
}
