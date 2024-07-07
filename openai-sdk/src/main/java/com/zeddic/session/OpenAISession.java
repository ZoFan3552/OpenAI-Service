package com.zeddic.session;

import com.zeddic.domain.chat.model.ChatCompletionRequest;
import com.zeddic.domain.chat.model.ChatCompletionResponse;

public interface OpenAISession {

    /**
     * 默认 GPT-3.5 问答模型
     * @param request 请求信息
     * @return                      返回结果
     */
    ChatCompletionResponse completions(ChatCompletionRequest request);
}
