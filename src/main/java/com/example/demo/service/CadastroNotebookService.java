package com.example.demo.service;

import com.example.demo.model.Notebook;
import com.example.demo.repository.NotebookRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class CadastroNotebookService {
    private static NotebookRepository notebookRepository;

    public CadastroNotebookService(NotebookRepository notebookRepository) {
        this.notebookRepository = notebookRepository;
    }

    public static String cadastrarNotebook(String numero, String numeroPatrimonio){
        boolean podeSalvar = true;
        String mensagem = "";
        numero = GenericoService.limparNumero(numero);
        numeroPatrimonio = GenericoService.limparNumero(numeroPatrimonio);

        if(GenericoService.campoVazio(numero)){
            podeSalvar = false;
            mensagem += "O número do notebook precisa ser informado!";
        }
        if(GenericoService.campoVazio(numeroPatrimonio)){
            podeSalvar = false;
            mensagem += "O número do patrimônio precisa ser informado!";
        }

        if(podeSalvar==true){
            Notebook notebookModel = new Notebook();
           notebookModel.setNumero(Integer.parseInt(numero));
           notebookModel.setPatrimonio(Long.parseLong(numeroPatrimonio));
           notebookModel.setAtivo(true);

            try{
                notebookRepository.save(notebookModel);
                mensagem = "Notebook registrado com sucesso";
            }catch(DataIntegrityViolationException e){
                mensagem += "Falha ao inserir registro no banco de dados";
            }

        }
        return mensagem;
    }
}