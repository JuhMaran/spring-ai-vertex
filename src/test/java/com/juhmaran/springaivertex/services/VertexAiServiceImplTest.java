package com.juhmaran.springaivertex.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VertexAiServiceImplTest {

  @Autowired
  VertexAiService vertexAiService;

  @Test
  void getAnswer() {
    String answer = vertexAiService.getAnswer("Olá, conte uma piada!");
    System.out.println("### Answer ###");
    System.out.println(answer);
  }
}