package br.com.open.ai.cecg.OpenAI.service.impl;

import br.com.open.ai.cecg.OpenAI.componente.ChatStreamComponent;
import br.com.open.ai.cecg.OpenAI.http.data.request.ScienceFictionRequestDTO;
import br.com.open.ai.cecg.OpenAI.service.CallOpenAiService;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;

import java.util.List;

public record CallOpenAiServiceImpl(ChatStreamComponent streamComponent ) implements CallOpenAiService {

   public static final String SCIENCE_FICTION_PROMPT_MESSAGE =
           "Gere uma estória de ficção científica de acordo com o" +
                   "seguinte cenário: %s";


    @Override
    public String generateScienceFaction(ScienceFictionRequestDTO requestDTO) {
        ChatCompletionRequest chatCompletionRequest = streamComponent.createChatStreamRequest(List.of(
                new ChatMessage(ChatMessageRole.SYSTEM.value(), String.format(SCIENCE_FICTION_PROMPT_MESSAGE, requestDTO.scenario()))));




        return streamComponent.getChatStreamResult(chatCompletionRequest);
    }
}
