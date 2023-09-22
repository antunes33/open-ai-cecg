package br.com.open.ai.cecg.OpenAI.http.impl;

import br.com.open.ai.cecg.OpenAI.http.OpenAIController;
import br.com.open.ai.cecg.OpenAI.http.data.request.PiadaRequestDTO;
import br.com.open.ai.cecg.OpenAI.http.data.request.ScienceFictionRequestDTO;
import br.com.open.ai.cecg.OpenAI.service.CallOpenAiService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/openai-cecg")
public record OpenAIControllerImpl(CallOpenAiService service) implements OpenAIController {

    @Override
    @PostMapping(value = "/science-fiction")
    @ResponseStatus(HttpStatus.OK)
    public String generateScienceFiction(@RequestBody ScienceFictionRequestDTO requestDTO) {
        return service.generateScienceFaction(requestDTO);
    }

    @Override
    @PostMapping(value = "/piada")
    @ResponseStatus(HttpStatus.OK)
    public String generatePiada(@RequestBody PiadaRequestDTO requestDTO) {
        return service.generatePiada(requestDTO);
    }

}
