package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.Game;

public class GameMinDTO {
    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    public GameMinDTO() {
        
    }
    // Customizar a saída do DTO
    // Tem mais campos, mas aqui vai retornar apenas 5 dados
    public GameMinDTO(Game entity) { 
        id = entity.getId();
        title = entity.getTitle();
        year = entity.getYear();
        imgUrl = getImgUrl();
        shortDescription = getShortDescription();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }

}
