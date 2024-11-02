package com.example.tp3jenkins.services;

import com.example.tp3jenkins.entities.Etudiant;
import com.example.tp3jenkins.repo.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/etudiant")

public class EtudiantRestController {

    @Autowired
    private EtudiantRepository etdRep;


    @GetMapping(path="/liste",produces= {MediaType.APPLICATION_JSON_VALUE})
    public List<Etudiant> CompteList(){
        return etdRep.findAll();
    }
    @GetMapping(path="/ListeEtudiants/{id}",produces= {MediaType.APPLICATION_JSON_VALUE})

    public Etudiant getOne(@PathVariable(value="id") Long id){
        return etdRep.findById(id).get();
    }
    @PostMapping(path="/ListeEtudiants",produces= {MediaType.APPLICATION_JSON_VALUE})

    public Etudiant save(@RequestBody Etudiant etudiant){
        return etdRep.save(etudiant);
    }

    @PutMapping(path="/ListeEtudiants/{id}",produces= {MediaType.APPLICATION_JSON_VALUE})

    public Etudiant update(@RequestBody Etudiant etudiant, @PathVariable(value="id") Long id){
        etudiant.setIdEtudiant(id);
        return etdRep.save(etudiant);
    }

    @DeleteMapping(path="/ListeEtudiants/{id}",produces= {MediaType.APPLICATION_JSON_VALUE})

    public void delete(@PathVariable(value="id") Long id){
        etdRep.deleteById(id);
    }


}
