package me.bangshinho.UrlShortener.controller;

import me.bangshinho.UrlShortener.service.ConvertUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ConvertUrlRestController {

    @Autowired
    ConvertUrlService convertShortUrlService;

    @PostMapping(value = "/convert/url", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<?> getConvertUrlAjax(@RequestParam(defaultValue = "") String convert_url){
        return ResponseEntity.ok(convertShortUrlService.getConvertUrl(convert_url.trim()));
    }
}
