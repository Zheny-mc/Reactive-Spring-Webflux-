package ru.cbrrate.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
//not using
@Data
@ConfigurationProperties(prefix = "cbr")
public class UrlConfig {
    String url;
}
