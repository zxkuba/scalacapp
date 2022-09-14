package com.example.demo.service;

import com.example.demo.controller.ScraperController;
import com.example.demo.model.ResponseDTO;
import lombok.Value;
import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Service
public class ScraperServiceImpl implements ScraperService{

    @Override
    public Set<ResponseDTO>getJokes (){
        Set<ResponseDTO> responseDTOS = new HashSet<>();
        extractData(responseDTOS);
        return responseDTOS;
    }

    private void extractData(Set<ResponseDTO> responseDTOS){

        try{
            Document document = Jsoup.connect("http://bash.org.pl/latest/").get();
            Element element = document.getElementById("content");
            Elements elements = element.getElementsByClass("quote post-content post-body");
            for (Element ads: elements){
                ResponseDTO responseDTO = new ResponseDTO();
                if (StringUtils.isNotEmpty(ads.attr("class"))){
                        responseDTO.setContent(ads.attr("class"));
                }
                if (responseDTO.getContent() != null) responseDTOS.add(responseDTO);
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }

    }


}
