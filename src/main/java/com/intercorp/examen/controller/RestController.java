package com.intercorp.examen.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intercorp.examen.entity.Matriz;
import com.intercorp.examen.service.MatrizService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(path = "/api/", produces="application/json", consumes = "application/json")
public class RestController {
	
	@Autowired
	private MatrizService matrizService;

	@PostMapping(path = "/matriz")
	public String postPrueba(@RequestBody String matriz) {
		String matrizRotada = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			Matriz matObj = mapper.readValue(matriz, Matriz.class);
			String[][] nuevaMatriz = matrizService.convertirStringAMatriz(matObj.getMatriz());
			matrizRotada = matrizService.rotarMatrizAntihorario(nuevaMatriz);
		} catch (JsonProcessingException e) {
			return "Error de matriz, debe ingresar una matriz cuadrada NxN.";
		}

		return matrizRotada;
	}
}
