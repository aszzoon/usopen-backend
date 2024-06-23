package com.usopen.backend.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;


@Configurable
public class OepnAPIConfiguration {

  private static final String API_NAME = "Oepn API";
  private static final String API_VERSION = "1.0.0";
  private static final String API_DESCRIPTION = "웹 게시판 API";

  @Bean
  public OpenAPI OpenAPIConfig() {
    return new OpenAPI()
            .info(new Info().title("USOPEN")


                    .description("웹 게시판 API").version("1.0.0"));
  }


}
