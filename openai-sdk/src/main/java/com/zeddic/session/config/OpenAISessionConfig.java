package com.zeddic.session.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

@Getter
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OpenAISessionConfig {

    @NotNull
    private String apiHost;


    @NotNull
    private String apiKey;

}
