package com.zeddic.session;

import com.zeddic.IOpenAIAPI;
import com.zeddic.domain.chat.model.ChatCompletionRequest;
import com.zeddic.domain.chat.model.ChatCompletionResponse;

public class DefaultOpenAISession implements OpenAISession {
   private final IOpenAIAPI api;

   public DefaultOpenAISession(IOpenAIAPI api) {
       this.api = api;
   }
    @Override
    public ChatCompletionResponse completions(ChatCompletionRequest request) {
        return this.api.completions(request).blockingGet();
    }
}
