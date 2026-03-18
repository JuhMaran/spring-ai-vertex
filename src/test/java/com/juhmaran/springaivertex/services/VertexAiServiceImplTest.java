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
    String answer = vertexAiService.getAnswer("Olá, como você pode me ajudar?");
    System.out.println("### Answer ###");
    System.out.println(answer);
  }
}