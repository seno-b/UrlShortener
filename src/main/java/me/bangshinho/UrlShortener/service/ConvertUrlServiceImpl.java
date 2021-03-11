package me.bangshinho.UrlShortener.service;


import me.bangshinho.UrlShortener.module.Base62UrlEncoder;
import me.bangshinho.UrlShortener.module.UrlEncoder;
import me.bangshinho.UrlShortener.vo.ResultUrl;
import me.bangshinho.UrlShortener.common.type.UrlType;
import me.bangshinho.UrlShortener.dao.ConvertUrlDao;
import me.bangshinho.UrlShortener.entity.ShortUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ConvertUrlServiceImpl implements ConvertUrlService {

    @Autowired
    private ConvertUrlDao convertUrlDao;

    @Autowired
    private Base62UrlEncoder base62UrlEncoder;

    @Override
    @Transactional
    public ResultUrl getConvertUrl(String url) {

        if(UrlEncoder.isUrl(url)){
            return null;
        }

        ResultUrl result = new ResultUrl();

        if(convertUrlDao.isExists(url)){
            ShortUrl shortUrl = convertUrlDao.getShortUrlByOriginUrl(url);
            shortUrl.setRequest_count(shortUrl.getRequest_count() + 1);

            result.setOrigin_url(shortUrl.getOriginUrl());
            result.setShort_url(shortUrl.getUrl());
            result.setRequest_count(shortUrl.getRequest_count());
            result.setType(UrlType.SHORT);

        }else{

            ShortUrl shortUrl = new ShortUrl(url);
            convertUrlDao.save(shortUrl);
            shortUrl.setUrl(base62UrlEncoder.encodeToLong(shortUrl.getId()));

            result.setOrigin_url(shortUrl.getOriginUrl());
            result.setShort_url(shortUrl.getUrl());
            result.setRequest_count(shortUrl.getRequest_count());
            result.setType(UrlType.NONE);
        }

        return result;
    }

    @Override
    public String getOriginUrl(String short_url) {

        ShortUrl shortUrl = convertUrlDao.getShortUrlByShortUrl(base62UrlEncoder.URL_PREFIX + short_url);
        if(shortUrl != null){
            return shortUrl.getOriginUrl();
        }
        return base62UrlEncoder.URL_PREFIX;
    }
}
