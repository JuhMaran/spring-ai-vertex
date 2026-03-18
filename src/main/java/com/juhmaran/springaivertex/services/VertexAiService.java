package com.juhmaran.springaivertex.services;

import com.juhmaran.springaivertex.model.Answer;
import com.juhmaran.springaivertex.model.GetCapitalRequest;
import com.juhmaran.springaivertex.model.Question;

/**
 * Service
 *
 * @author Juliane Maran
 * @since 17/03/2026
 */
public interface VertexAiService {

  Answer getCapitalWithInfo(GetCapitalRequest getCapitalRequest);

  Answer getCapital(GetCapitalRequest getCapitalRequest);

  Answer getAnswer(Question question);

  String getAnswer(String question);

}
