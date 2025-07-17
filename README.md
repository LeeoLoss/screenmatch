# 🎬 Buscador de Filmes com Java e OMDb API

Este projeto é uma aplicação Java que permite ao usuário buscar informações sobre filmes, séries e outros títulos diretamente no console, consumindo a API pública da OMDb. Os dados retornados são convertidos de JSON para objetos Java e armazenados localmente em um arquivo `.json`.

---

## 🚀 Funcionalidades

- 🔍 Busca interativa de filmes pelo terminal  
- 🌐 Consumo da API OMDb via requisições HTTP  
- 📦 Conversão de JSON para objetos Java usando Gson  
- 📁 Armazenamento dos títulos buscados em um arquivo `filmes.json`  
- 💥 Tratamento de exceções para dados inconsistentes ou inválidos  

---

## 🧪 Exemplo de uso

```bash
Digite um item para busca (ou 'sair' para encerrar): interestelar
JSON recebido da API:
{ "Title": "Interstellar", "Year": "2014", ... }
Objeto TituloOmdb criado: TituloOmdb{...}
Título convertido com sucesso: Interstellar (2014)
```

---

## 🛠️ Tecnologias utilizadas

- Java 17+
- API HTTP nativa (`java.net.http.HttpClient`)
- Biblioteca [Gson](https://github.com/google/gson)
- API OMDb ([www.omdbapi.com](https://www.omdbapi.com/))

---

## 📂 Estrutura do Projeto

```
├── principal/
│   └── PrincipalComBusca.java
│   └── PrincipalComBusca.java
│   └── PrincipalComBusca.java

├── calculos/
│   ├── CalculadoraDeTempo.java
│   ├── Classificavel.java
│   ├── Recomendacao.java

├── screenmatch/
│   ├── Episodio.java
│   ├── Filme.java
│   ├── Serie.java
│   ├── Titulo.java
│   └── TituloOmdb.java

├── excecao/
│   └── ErroDeConversaoDeAnoException.java
├── filmes.json  ← gerado após a execução
├── README.md
```

---

## ⚙️ Como executar o projeto

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/leonardoloss/buscador-filmes-java.git
   cd buscador-filmes-java
   ```

2. **Compile e execute:**
   - Se estiver usando um IDE (Eclipse, IntelliJ...), basta rodar a classe `PrincipalComBusca`.
   - Ou pelo terminal:
     ```bash
     javac principal/PrincipalComBusca.java
     java principal.PrincipalComBusca
     ```

---

## 📌 Observações

- A API OMDb requer uma **chave de API gratuita**, já incluída neste exemplo como `apikey=270ce4b5`.
- Em projetos reais, o ideal é **ocultar essa chave** em variáveis de ambiente ou arquivos externos.

---

## 🤝 Contribuições

Sinta-se à vontade para abrir issues ou enviar pull requests!  
Sugestões para transformar esse projeto em uma aplicação com interface gráfica ou API REST são muito bem-vindas.
