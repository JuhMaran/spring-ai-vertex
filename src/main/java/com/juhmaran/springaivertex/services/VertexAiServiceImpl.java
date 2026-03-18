package com.juhmaran.springaivertex.services;

import com.juhmaran.springaivertex.model.Answer;
import com.juhmaran.springaivertex.model.Question;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;

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
  public Answer getAnswer(Question question) {
    var promptTemplate = new PromptTemplate(question.question());
    Prompt prompt = promptTemplate.create();
    ChatResponse response = chatModel.call(prompt);

    return new Answer(Objects.requireNonNull(response.getResult()).getOutput().getText());
  }

  @Override
  public String getAnswer(String question) {
    var promptTemplate = new PromptTemplate(question);
    Prompt prompt = promptTemplate.create();
    ChatResponse response = chatModel.call(prompt);

    return Objects.requireNonNull(response.getResult()).getOutput().getText();
  }

}
