package com.juhmaran.springaivertex.services;

import com.juhmaran.springaivertex.model.Answer;
import com.juhmaran.springaivertex.model.Question;

/**
 * spring-ai-vertex
 *
 * @author Juliane Maran
 * @since 17/03/2026
 */
public interface VertexAiService {

  Answer getAnswer(Question question);

  String getAnswer(String question);

}
