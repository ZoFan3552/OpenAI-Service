package com.zeddic;

import com.zeddic.common.Constants;
import com.zeddic.domain.chat.model.ChatCompletionRequest;
import com.zeddic.domain.chat.model.ChatCompletionResponse;
import com.zeddic.domain.chat.model.Message;
import com.zeddic.session.OpenAISession;
import com.zeddic.session.config.OpenAISessionConfig;
import com.zeddic.session.factory.DefaultOpenAISessionFactory;
import com.zeddic.session.factory.OpenAISessionFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

@Slf4j
public class APITest {
    private OpenAISession session;

    @Before
    public void test_OpenAISessionFactory() {
        OpenAISessionConfig config = new OpenAISessionConfig();
        config.setApiHost("https://pro-share-aws-api.zcyai.com/");
        config.setApiKey("sk-L4FMiW39EvjL2kqu871f3d52BfC94183872eC537Ab819eA9");

        OpenAISessionFactory factory = new DefaultOpenAISessionFactory(config);
        this.session = factory.createSession();
    }

    @Test
    public void test_chatCompletion(){
        //创建参数
        ChatCompletionRequest request = ChatCompletionRequest.builder()
                .messages(Collections.singletonList(Message.builder()
                        .role(Constants.Role.USER.getValue()).content("写一个Java冒泡排序").build()))
                .model(Constants.Model.GPT_4.getCode())
                .build();
        ChatCompletionResponse response = session.completions(request);
        response.getChoices().forEach(message -> log.info("测试结果:{}" ,message.getMessage()));

    }
}
