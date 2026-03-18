# Spring AI com Vertex AI Gemini

Este repositório é um projeto de referência técnica focado na implementação de soluções de Inteligência Artificial
Generativa utilizando o ecossistema **Spring AI** em conjunto com o **Google Cloud Vertex AI (Gemini)**. O projeto
demonstra como construir uma arquitetura robusta, tipada e pronta para integração com interfaces modernas.

## Visão Geral

A aplicação foi projetada para servir como uma ponte entre sistemas legados/modernos e os modelos de linguagem de última
geração do Google. Diferente de implementações básicas, este laboratório explora a estruturação de dados, validação de
esquemas e a extração de métricas de performance da IA.

## Tecnologias

O projeto utiliza as versões mais recentes do ecossistema Java para garantir suporte a longo prazo e alta performance:

* **Java 25 (LTS)**
* **Spring Boot 4.0.3**
    * Atualizado para a versão **4.1.0-SNAPSHOT**
* **Spring Framework 7**
* **Spring WebMVC**
* **Spring AI 2.0.0-M2** (BOM para gestão de dependências)
    * Atualizado para a **versão 2.0.0-M3** (lançamento em 16/03/2026)
* **Google Vertex AI Gemini 2.5 Flash**
* **Protocolo de Transporte:** REST

## Pré-requisitos e Configuração

### Google Cloud Platform (GCP)

* **Project ID:** Necessário um projeto ativo no GCP com a API Vertex AI habilitada.
* **Location:** Configurado por padrão em `us-central1`.
* **Autenticação:** O sistema requer uma Service Account com o papel de Vertex AI User, exportada em formato JSON.

### Ambiente de Desenvolvimento

* Instalação do JDK 25.
* Configuração do arquivo de credenciais em `src/main/resources/credentials.json`.
* Ajuste do `project-id` no arquivo de propriedades da aplicação (`application.yaml`).

## Arquitetura do Projeto

_em construção_

## Funcionalidades Principais

_em construção_

## Qualidade e Testes

O projeto segue práticas de desenvolvimento orientadas a testes (TDD), incluindo:

* Testes de integração para validação de conectividade com a API do Google.
* Validação de esquemas de resposta para garantir conformidade com o JSON Schema definido.

---

<h2>Juliane Maran</h2>

<p>
  Software Architecture & Development
</p>

---

_Este é um projeto experimental focado em explorar as fronteiras da IA generativa com tecnologias Java de ponta._