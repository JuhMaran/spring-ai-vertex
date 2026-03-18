package com.juhmaran.springaivertex.services;

import com.juhmaran.springaivertex.model.*;

/**
 * Service
 *
 * @author Juliane Maran
 * @since 17/03/2026
 */
public interface VertexAiService {

  GetCapitalWithInfoResponse getCapitalWithInfo(GetCapitalRequest getCapitalRequest);

  GetCapitalResponse getCapital(GetCapitalRequest getCapitalRequest);

  String getAnswer(String question);

  Answer getAnswer(Question question);
}
