package com.juhmaran.springaivertex.model;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

/**
 * spring-ai-vertex
 *
 * @author Juliane Maran
 * @since 18/03/2026
 */
public record GetCapitalResponse(@JsonPropertyDescription("This is the city name") String answer) {
}

// Vinculando a resposta do Vertex AI Gemini ao esquema JSON