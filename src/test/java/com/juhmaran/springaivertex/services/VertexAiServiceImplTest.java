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
    String answer = vertexAiService.getAnswer("Write a python script to output numbers from 1 to 100.");
    System.out.println("Answer: " + answer);
  }
}