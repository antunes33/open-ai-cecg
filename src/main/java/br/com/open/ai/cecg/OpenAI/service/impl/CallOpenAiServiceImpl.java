package br.com.open.ai.cecg.OpenAI.service.impl;

import br.com.open.ai.cecg.OpenAI.componente.ChatStreamComponent;
import br.com.open.ai.cecg.OpenAI.http.data.request.PiadaRequestDTO;
import br.com.open.ai.cecg.OpenAI.http.data.request.ScienceFictionRequestDTO;
import br.com.open.ai.cecg.OpenAI.service.CallOpenAiService;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record CallOpenAiServiceImpl(ChatStreamComponent streamComponent) implements CallOpenAiService {

    public static final String SCIENCE_FICTION_PROMPT_MESSAGE =
            "Gere uma estória de ficção científica de acordo com o" +
                    "seguinte cenário: %s";

    public static final String PIADA_PROMPT_MESSAGE =
            "Gere uma piada sobre Pato Branco ser maior que Beltrão como se fosse o Humorista %s";


    @Override
    public String generateScienceFaction(ScienceFictionRequestDTO requestDTO) {
        ChatCompletionRequest chatCompletionRequest = streamComponent.createChatStreamRequest(List.of(
                new ChatMessage(ChatMessageRole.SYSTEM.value(), String.format(SCIENCE_FICTION_PROMPT_MESSAGE, requestDTO.scenario()))));


        return streamComponent.getChatStreamResult(chatCompletionRequest);
    }

    @Override
    public String generatePiada(PiadaRequestDTO requestDTO) {
        ChatCompletionRequest chatCompletionRequest = streamComponent.createChatStreamRequest(List.of(
                new ChatMessage(ChatMessageRole.SYSTEM.value(), String.format(PIADA_PROMPT_MESSAGE, requestDTO.humorista()))));


        return streamComponent.getChatStreamResult(chatCompletionRequest);
    }
}
