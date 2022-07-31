/*
ESTA CLASE VA A ENCARGASE DE RECIBIR TODAS LAS PETICIONES QUE REALICE EL CLIENTE
Y SE ENCArGA DE DAR LAS RESPUESTAS. 
CREAAANDO UNA APII
 */


package com.ejemplo.SpringBoot.Controller;

import com.ejemplo.SpringBoot.model.Persona;
import com.ejemplo.SpringBoot.service.IPersonaService;
//import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController//anotashion 
 //Nuestra clase controladora. En plan pibot de basquet.       

public class Controller {
    
    @Autowired// inyeccion de dependecias. 
    private IPersonaService persoServ;
    
 
    @PostMapping("/new/persona")
    public void agregarPersona(@RequestBody Persona pers){ //anotashion requestBody, la persona en cuestion va a venir en el cuerpo de la solicitud. 
                                                            //viene eun jason con los datos de la persona a gregar. 
       persoServ.crearPersona(pers);
    }
    
    @GetMapping ("/ver/personas")
    @ResponseBody                   //respuesta del servidor al cliente. 
    public List<Persona> verPersona (){
        
      return persoServ.verPersona();
    }
    
    @DeleteMapping ("/dele/{id}")
    public void borrarPersona(@PathVariable Long id){
        persoServ.borrarPersona(id);
    }
}


/* primeritas pruebas de input     
    List<Persona> listaPersonas = new ArrayList();

    método
    anotashion get, y proporcionamos parametros 
    @GetMapping ("/hola/{nombre}/{apellido}/{edad}")
    
    public String decirHola(@PathVariable String nombre,
                            @PathVariable String apellido,
                            @PathVariable int edad){
        
        return "Hola Mundo " + nombre + " apellido: "+ apellido + " Edad: " + edad;
    }
    
    
    //metodo con get mapping pero con RequestParam
    @GetMapping ("/chau")
    public String decirChau(@RequestParam String nombre,
                            @RequestParam String apellido,
                            @RequestParam int edad){
        
        return "Chau Mundo " + nombre + " apellido: "+ apellido + " Edad: " + edad;
    }
    
*/