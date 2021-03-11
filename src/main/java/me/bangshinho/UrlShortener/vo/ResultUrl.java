package me.bangshinho.UrlShortener.vo;

import lombok.Getter;
import lombok.Setter;
import me.bangshinho.UrlShortener.common.type.UrlType;

import java.math.BigInteger;

@Getter @Setter
public class ResultUrl {

    private BigInteger id;
    private String short_url;
    private String origin_url;
    private long request_count;
    private UrlType type;
}
