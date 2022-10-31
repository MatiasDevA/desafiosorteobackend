package com.example.desafiosorteo.Controller;


import com.example.desafiosorteo.Exception.EmpleadoAlreadyExistsException;
import com.example.desafiosorteo.Exception.EmpleadoEmailAlreadyExistsException;
import com.example.desafiosorteo.Exception.EmpleadoNotFoundException;
import com.example.desafiosorteo.Service.EmpleadoService;
import com.example.desafiosorteo.entity.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;



    @GetMapping("/empleado")
    public ResponseEntity<List<Empleado>> findAllEmpleados(){
        return ResponseEntity.ok(empleadoService.findAllEmpleados());
    }

    @PostMapping("/empleado")
    public ResponseEntity<Empleado> guardarEmpleado(@RequestBody  @Valid Empleado empleado) throws EmpleadoAlreadyExistsException, EmpleadoEmailAlreadyExistsException {
        return new ResponseEntity<>(empleadoService.saveEmpleado(empleado), HttpStatus.CREATED);
    }

    @GetMapping("/empleado/{id}")
    public ResponseEntity<Empleado> getEmpleado(@PathVariable("id") Long id) throws EmpleadoNotFoundException {
        return ResponseEntity.ok(empleadoService.empleadoUnica(id));
    }
}
