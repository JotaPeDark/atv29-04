package com.example.adapter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PessoaCsvAdapter implements RepositorioDePessoas {

    private String caminhoDoArquivo;

    public PessoaCsvAdapter(String caminhoDoArquivo) {
        this.caminhoDoArquivo = caminhoDoArquivo;
    }

    @Override
    public List<Pessoa> listarPessoas() {
        List<Pessoa> pessoas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoDoArquivo))) {
            String linha;
            boolean primeiraLinha = true;

            while ((linha = br.readLine()) != null) {
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue; // Ignora o cabeçalho
                }

                String[] campos = linha.split(",");

                if (campos.length >= 3) {
                    String nome = campos[0].trim();
                    int idade = Integer.parseInt(campos[1].trim());
                    String email = campos[2].trim();

                    Pessoa pessoa = new Pessoa(nome, idade, email);
                    pessoas.add(pessoa);
                }
            }
        } {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return pessoas;
    }
}
