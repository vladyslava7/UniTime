package com.unitime.api.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

public class LinkUpdateDto {

    @NotBlank(message = "Посилання не може бути порожнім")
    @URL(message = "Недійсний формат URL")
    private String newUrl;

    @NotBlank(message = "Платформа (наприклад, Zoom) обов'язкова")
    private String platform;

    public String getNewUrl() { return newUrl; }
    public void setNewUrl(String newUrl) { this.newUrl = newUrl; }
    public String getPlatform() { return platform; }
    public void setPlatform(String platform) { this.platform = platform; }
}