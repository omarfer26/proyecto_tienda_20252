package com.ufps.prueba.dto;

import lombok.Data;

@Data
public class EmailRequestDto {
	
    private String destino;
    private String nombre;
    private String titulo;
    private String mensaje;
    
}
