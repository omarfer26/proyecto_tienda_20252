package com.ufps.prueba.controllers;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ufps.prueba.dto.EmailRequestDto;
import com.ufps.prueba.services.EmailService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/enviar")
    public String enviarCorreo(@RequestBody EmailRequestDto request) {
        try {
            Map<String, Object> variables = new HashMap<>();
            variables.put("titulo", request.getTitulo() != null ? request.getTitulo() : "¡Hola " + request.getNombre() + "!");
            variables.put("mensaje", request.getMensaje() != null ? request.getMensaje() : "Gracias por usar nuestros servicios.");

            emailService.enviarCorreoConTemplate(
                    request.getDestino(),
                    "Notificación de la aplicación",
                    "email-template",
                    variables
            );

            return "Correo enviado exitosamente a " + request.getDestino();
        } catch (MessagingException e) {
            e.printStackTrace();
            return "Error al enviar el correo: " + e.getMessage();
        }
    }
}