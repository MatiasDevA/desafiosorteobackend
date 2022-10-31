package com.example.desafiosorteo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empleadoId;

    @NotNull(message = "Ingrese un nombre")
    @NotBlank(message = "El campo debe ser ingresado")
    private String nombre;

    @NotNull(message = "Ingrse un apellido")
    private String apellido;

    @Min(18)
    @Max(100)
    private int edad;

    @Email(message = "El email ingresado no es correcto")
    private String email;

}
