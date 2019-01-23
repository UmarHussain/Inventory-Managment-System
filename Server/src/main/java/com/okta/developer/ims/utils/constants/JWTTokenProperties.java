package com.okta.developer.ims.utils.constants;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class JWTTokenProperties {
    @Value("${jwt.token.header}")
    private String tokenHeader;

    @Value("jwt.token.secret")
    private String tokenSecret;

    @Value("jwt.token.prefix")
    private String tokenPrefix;

    @Value("jwt.token.expiration.time")
    private String tokenExpirationTime;
}
