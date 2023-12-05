package com.food.foodbox.shared.config.properties;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("cloud.aws")
public class S3Properties {
    private S3 s3;
    private Credentials credentials;

    @Data
    public static class S3 {
        private String bucket;
    }

    public String getBucket() {
        return s3.getBucket();
    }

    @Data
    public static class Credentials {
        private String accessKey;
        private String secretKey;
    }

    public String getAccessKey() {
        return credentials.getAccessKey();
    }

    public String getSecretKey() {
        return credentials.getSecretKey();
    }
}
