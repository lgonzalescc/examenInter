package com.intercorp.examen.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Matriz{
	@JsonProperty("matriz")
	private String matriz;

	public String getMatriz() {
		return matriz;
	}

	public void setMatriz(String matriz) {
		this.matriz = matriz;
	}
	
}
