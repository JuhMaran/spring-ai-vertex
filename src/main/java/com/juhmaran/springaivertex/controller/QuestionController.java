package com.juhmaran.springaivertex.controller;

import com.juhmaran.springaivertex.model.Answer;
import com.juhmaran.springaivertex.model.GetCapitalRequest;
import com.juhmaran.springaivertex.model.Question;
import com.juhmaran.springaivertex.services.VertexAiService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * spring-ai-vertex
 *
 * @author Juliane Maran
 * @since 17/03/2026
 */
@RestController
public class QuestionController {

  private final VertexAiService vertexAiService;

  public QuestionController(VertexAiService vertexAiService) {
    this.vertexAiService = vertexAiService;
  }

  @PostMapping("/capitalWithInfo")
  public Answer getCapitalWithInfo(@RequestBody GetCapitalRequest getCapitalRequest) {
    return this.vertexAiService.getCapitalWithInfo(getCapitalRequest);
  }

  @PostMapping("/capital")
  public Answer getCapital(@RequestBody GetCapitalRequest getCapitalRequest) {
    return this.vertexAiService.getCapital(getCapitalRequest);
  }

  @PostMapping("/ask")
  public Answer askQuestion(@RequestBody Question question) {
    return vertexAiService.getAnswer(question);
  }

}
