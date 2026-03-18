package com.juhmaran.springaivertex.services;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

/**
 * spring-ai-vertex
 *
 * @author Juliane Maran
 * @since 17/03/2026
 */
@Service
public class VertexAiServiceImpl implements VertexAiService {

  private final ChatModel chatModel;

  public VertexAiServiceImpl(ChatModel chatModel) {
    this.chatModel = chatModel;
  }

  @Override
  public String getAnswer(String question) {
    PromptTemplate promptTemplate = new PromptTemplate(question);
    Prompt prompt = promptTemplate.create();
    ChatResponse response = chatModel.call(prompt);

    return response.getResult().getOutput().getText();
  }

}
