package com.impulsart.ImpulsArtApp.controller;

import com.impulsart.ImpulsArtApp.entities.Oferta;
import com.impulsart.ImpulsArtApp.service.imp.OfertaImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping(path = "/api/oferta/", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.HEAD})
@CrossOrigin("*")

public class OfertaController {

    @Autowired
    private OfertaImp ofertaImp;

      @PostMapping("create")
      public ResponseEntity<Map<String, Object>> create(@RequestBody Map<String, Objects> request){

          Map<String, Object> response = new HashMap<>();

          try{

              System.out.println("@@@"+request);
              Oferta oferta = new Oferta();
              //oferta.setPkCod_oferta(Long.parseLong(request.get("id").toString()));
              oferta.setMonto(Integer.parseInt(request.get("Monto").toString()));
              this.ofertaImp.create(oferta);
              response.put("status","success");
              response.put("data","Registro Exitoso");

          } catch (Exception e){

            response.put("status", HttpStatus.BAD_GATEWAY);
            response.put("data",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_GATEWAY);

          }

          return new ResponseEntity<>(response, HttpStatus.OK);

      }

      /*
      @GetMapping("all")
      public ResponseEntity<Map<String, Object>> findAll(){

      }

       */

}


