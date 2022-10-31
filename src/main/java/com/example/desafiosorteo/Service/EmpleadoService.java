package com.example.desafiosorteo.Service;

import com.example.desafiosorteo.Exception.EmpleadoAlreadyExistsException;
import com.example.desafiosorteo.Exception.EmpleadoEmailAlreadyExistsException;
import com.example.desafiosorteo.Exception.EmpleadoNotFoundException;
import com.example.desafiosorteo.entity.Empleado;

import java.util.List;
import java.util.Optional;

public interface EmpleadoService {

    List<Empleado> findAllEmpleados();

    Empleado saveEmpleado(Empleado empleado) throws EmpleadoAlreadyExistsException, EmpleadoEmailAlreadyExistsException;

    Empleado empleadoUnica(Long id) throws EmpleadoNotFoundException;

    void empleadoEliminar(Long id);

    void editarEmpleado(Empleado empleado);
}
