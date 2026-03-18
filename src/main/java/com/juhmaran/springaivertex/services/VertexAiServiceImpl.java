package com.juhmaran.springaivertex.services;

import com.juhmaran.springaivertex.model.Answer;
import com.juhmaran.springaivertex.model.GetCapitalRequest;
import com.juhmaran.springaivertex.model.GetCapitalResponse;
import com.juhmaran.springaivertex.model.Question;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.converter.BeanOutputConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.Map;
import java.util.Objects;

/**
 * Service Implementation
 *
 * @author Juliane Maran
 * @since 17/03/2026
 */
@Service
public class VertexAiServiceImpl implements VertexAiService {

  @Autowired
  ObjectMapper objectMapper;

  private final ChatModel chatModel;

  public VertexAiServiceImpl(ChatModel chatModel) {
    this.chatModel = chatModel;
  }

  @Value("classpath:templates/get-capital-prompt.st")
  private Resource getCapitalPrompt;

  @Value("classpath:templates/get-capital-with-info.st")
  private Resource getCapitalPromptWithInfo;

  @Override
  public Answer getCapitalWithInfo(GetCapitalRequest getCapitalRequest) {
    PromptTemplate promptTemplate = new PromptTemplate(getCapitalPromptWithInfo);
    Prompt prompt = promptTemplate.create(Map.of("stateOrCountry", getCapitalRequest.stateOrCountry()));
    ChatResponse response = chatModel.call(prompt);

    return new Answer(Objects.requireNonNull(response.getResult()).getOutput().getText());
  }

  @Override
  public GetCapitalResponse getCapital(GetCapitalRequest getCapitalRequest) {

    // No curso utiliza o BeanOutputParser, mas na nova versão do Spring AI passou a ser deprecated
    // BeanOutputParser<GetCapitalRequest> parser = BeanOutputParser<>(GetCapitalRequest.class);

    BeanOutputConverter<GetCapitalResponse> converter = new BeanOutputConverter<>(GetCapitalResponse.class);
    String format = converter.getFormat();
    System.out.println("Format: \n" + format);

    PromptTemplate promptTemplate = new PromptTemplate(getCapitalPrompt);
    Prompt prompt = promptTemplate.create(Map.of(
      "stateOrCountry", getCapitalRequest.stateOrCountry(),
      "format", format));
    ChatResponse response = chatModel.call(prompt);

//    System.out.println(Objects.requireNonNull(response.getResult()).getOutput().getText());

    return converter.convert(Objects.requireNonNull(response.getResult().getOutput().getText()));

//    String responseString;
//
//    try {
//      JsonNode jsonNode = objectMapper.readTree(response.getResult().getOutput().getText());
//      responseString = jsonNode.get("answer").asString();
//    } catch (JacksonException e) {
//      throw new RuntimeException(e);
//    }
//
//    return new Answer(responseString);
    //return new Answer(response.getResult().getOutput().getText());
  }

  @Override
  public Answer getAnswer(Question question) {
    System.out.println("I was called");

    PromptTemplate promptTemplate = new PromptTemplate(question.question());
    Prompt prompt = promptTemplate.create();
    ChatResponse response = chatModel.call(prompt);

    return new Answer(Objects.requireNonNull(response.getResult()).getOutput().getText());
  }

  @Override
  public String getAnswer(String question) {
    PromptTemplate promptTemplate = new PromptTemplate(question);
    Prompt prompt = promptTemplate.create();
    ChatResponse response = chatModel.call(prompt);

    return Objects.requireNonNull(response.getResult()).getOutput().getText();
  }

}
