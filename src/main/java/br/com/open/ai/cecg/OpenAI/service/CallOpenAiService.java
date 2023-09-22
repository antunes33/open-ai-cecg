package br.com.open.ai.cecg.OpenAI.service;

import br.com.open.ai.cecg.OpenAI.http.data.request.PiadaRequestDTO;
import br.com.open.ai.cecg.OpenAI.http.data.request.ScienceFictionRequestDTO;

public interface CallOpenAiService {
    String generateScienceFaction(ScienceFictionRequestDTO requestDTO);

    String generatePiada(PiadaRequestDTO requestDTO);
}
