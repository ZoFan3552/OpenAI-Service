package com.zeddic;

import com.zeddic.domain.chat.model.ChatCompletionRequest;
import com.zeddic.domain.chat.model.ChatCompletionResponse;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IOpenAIAPI {

    @POST("v1/chat/completions")
    Single<ChatCompletionResponse> completions(@Body ChatCompletionRequest chatCompletionRequest);
}
