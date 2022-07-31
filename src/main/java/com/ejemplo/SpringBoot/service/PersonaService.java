/* LÓGICA DE NEGOCIOS 
Clase comun con la implementación de todos los metodos 
que vamos a declarar. 
"HAY QUE HACER UNA INYECCION DE DEPENDECIAS DEL REPOSITORIO CON EL QUE VAMOS 
A TRABAJAR "
 */
package com.ejemplo.SpringBoot.service;

import com.ejemplo.SpringBoot.model.Persona;
import com.ejemplo.SpringBoot.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService{
    
    @Autowired
    public PersonaRepository persoRepo;
    
    
    @Override
    public List<Persona> verPersona() {
       return  persoRepo.findAll();  
    }

    @Override
    public void crearPersona(Persona per) {
        persoRepo.save(per);
    }

    @Override
    public void borrarPersona(Long id) {
        
        persoRepo.deleteById(id);
    }

    @Override
    public Persona buscarPersona(Long id){
        return persoRepo.findById(id).orElse(null);
    }
}
