package me.dio.sdw.adapters.out;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import me.dio.sdw.ports.GenerativeAiApi;

@FeignClient(name = "openAiChatApi", url = "${openai.base-url}")
public interface OpenAiChatApi extends GenerativeAiApi{

    @PostMapping("/v1/chat/completions")
    OpenAiChatCompletionResp chatCompletion(OpenAiChatCompletionReq req);
    
    @Override
    default String generatedContent(String objective, String context) {
        String model = "gpt-4o";
        List<Message> messages = List.of(
            new Message("system", objective),
            new Message("user", context)
        );
        OpenAiChatCompletionReq req = new OpenAiChatCompletionReq(model, messages);
        OpenAiChatCompletionResp resp = chatCompletion(req);
        return resp.choices().get(0).message().content();
    }

    record OpenAiChatCompletionReq(String model, List<Message> messages) {}
    record Message(String role, String content) {}

    record OpenAiChatCompletionResp(List<Choice> choices) {}
    record Choice(Message message) {}


}
