package me.bangshinho.UrlShortener.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter
@Table(name = "short_url")
public class ShortUrl {

    public ShortUrl(String originUrl){
        this.originUrl = originUrl;
    }

    @Id @GeneratedValue
    private long id;
    private String url;
    private String originUrl;
    @ColumnDefault("0")
    private long request_count;

}
