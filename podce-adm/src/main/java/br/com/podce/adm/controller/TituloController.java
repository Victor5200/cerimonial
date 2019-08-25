package br.com.podce.adm.controller;

import br.com.podce.adm.dto.TituloDTO;
import br.com.podce.adm.service.TituloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/titulo")
public class TituloController {

    @Autowired
    private TituloService tituloService;


    @GetMapping(value = "/buscar-todos-titulos")
    public ResponseEntity<List<TituloDTO>> buscaTodosTitulos(){
        return new ResponseEntity<>(tituloService.buscarTodos(), HttpStatus.OK);
    }

    @GetMapping(value = "/buscar-por-descricao/{descricao}")
    public ResponseEntity<List<TituloDTO>> buscarPorDescricao(@PathVariable String descricao){
        return new ResponseEntity<>(tituloService.buscarPorDescricao(descricao), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TituloDTO> buscarPorId(@PathVariable Long id){
        return new ResponseEntity<>(tituloService.buscarPorId(id), HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<TituloDTO> buscarPorId(@RequestBody TituloDTO tituloDTO){
        return new ResponseEntity<>(tituloService.salvar(tituloDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity buscarPorId(@RequestBody TituloDTO tituloDTO, @PathVariable Long id){
        tituloService.deletarTitulo(tituloDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
