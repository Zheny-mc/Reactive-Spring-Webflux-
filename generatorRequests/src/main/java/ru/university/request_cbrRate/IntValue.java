package ru.university.request_cbrRate;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "number")
public class IntValue {
    Integer number;
}
