package com.zeddic.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class Constants {

    @Getter
    @AllArgsConstructor
    public enum Role{
        SYSTEM("system"),
        USER("user"),
        ASSISTANT("assistant");
        private final String value;
    }

    @Getter
    @AllArgsConstructor
    public enum Model {
        /** gpt-3.5-turbo */
        GPT_3_5_TURBO("gpt-3.5-turbo"),
        /** GPT4.0 */
        GPT_4("gpt-4"),
        /** GPT4.0 超长上下文 */
        GPT_4_32K("gpt-4-32k"),
        ;
        private final String code;
    }

}
