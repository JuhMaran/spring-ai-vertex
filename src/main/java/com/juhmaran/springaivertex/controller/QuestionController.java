package com.juhmaran.springaivertex.controller;

import com.juhmaran.springaivertex.model.*;
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
  public GetCapitalWithInfoResponse getCapitalWithInfo(@RequestBody GetCapitalRequest getCapitalRequest) {
    return this.vertexAiService.getCapitalWithInfo(getCapitalRequest);
  }

  @PostMapping("/capital")
  public GetCapitalResponse getCapital(@RequestBody GetCapitalRequest getCapitalRequest) {
    return this.vertexAiService.getCapital(getCapitalRequest);
  }

  @PostMapping("/ask")
  public Answer askQuestion(@RequestBody Question question) {
    return vertexAiService.getAnswer(question);
  }

}
