package app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import app.entity.Biblioteca;

@Service
public class BibliotecaService {
	
    private List<Biblioteca> lista = new ArrayList<>();
    
    public Biblioteca findById(int id) {
        for (Biblioteca biblioteca : lista) {
            if (biblioteca.getId() == id) {
                return biblioteca;
            }
        }
        return null; // Retorna null se a biblioteca com o ID especificado não for encontrada
    }
    
    public String save(Biblioteca biblioteca) {
        lista.add(biblioteca);
        return "Salvo com sucesso!";
    }
    
    public List<Biblioteca> listAll() {
        return this.lista;
    }
    
    public String delete(Biblioteca biblioteca) {
        lista.remove(biblioteca);
        return "Excluído com sucesso!";
    }
    
    public String update(Biblioteca biblioteca) {
        var index = lista.indexOf(biblioteca); 
        
        this.lista.set(index, biblioteca);

        return "Atualizado com sucesso!";
    }
}

