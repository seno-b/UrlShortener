package me.bangshinho.UrlShortener.service;

import me.bangshinho.UrlShortener.vo.ResultUrl;

public interface ConvertUrlService {

    ResultUrl getConvertUrl(String url);

    String getOriginUrl(String short_url);
}
