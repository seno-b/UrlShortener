package me.bangshinho.UrlShortener.controller;

import me.bangshinho.UrlShortener.service.ConvertUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.net.URL;

@Controller
public class ConvertUrlController {

    @Autowired
    ConvertUrlService convertShortUrlService;

    @GetMapping("/{short_url}")
    public RedirectView redirectOriginUrl(@PathVariable("short_url") String short_url){
        String redirectUrl = convertShortUrlService.getOriginUrl(short_url);

        return new RedirectView(redirectUrl);
    }
}
