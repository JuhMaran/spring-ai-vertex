package com.juhmaran.springaivertex.config;

import com.google.cloud.vertexai.VertexAI;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * spring-ai-vertex
 *
 * @author Juliane Maran
 * @since 17/03/2026
 */
@SpringBootTest
class VertexConfigTest {

  @Autowired
  private ApplicationContext context;

  @Value("${spring.ai.vertex.ai.gemini.credentials-uri}")
  private Resource credentialsResource;

  @Test
  @DisplayName("1. Verificar se o arquivo credentials.json existe no classpath")
  void verifyFileExists() {
    assertThat(credentialsResource.exists())
      .withFailMessage("ERRO: O arquivo credentials.json NÃO foi encontrado em: " + credentialsResource.getDescription())
      .isTrue();

    System.out.println("SUCESSO: Arquivo encontrado em: " + credentialsResource.getDescription());
  }

  @Test
  @DisplayName("2. Verificar se o Bean do VertexAI foi criado (Validação de credenciais)")
  void verifyVertexAiBean() {
    // Se o arquivo JSON for inválido ou não existir, o Spring falhará ao criar este Bean
    VertexAI vertexAI = context.getBean(VertexAI.class);

    assertThat(vertexAI).isNotNull();
    System.out.println("SUCESSO: Bean VertexAI instanciado com sucesso. Credenciais aceitas pelo SDK do Google.");
  }

}
