package com.example.desafiosorteo.Service;

import com.example.desafiosorteo.Exception.EmpleadoAlreadyExistsException;
import com.example.desafiosorteo.Exception.EmpleadoEmailAlreadyExistsException;
import com.example.desafiosorteo.Exception.EmpleadoNotFoundException;
import com.example.desafiosorteo.Repository.EmpleadoRepository;
import com.example.desafiosorteo.entity.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public List<Empleado> findAllEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado saveEmpleado(Empleado empleado) throws EmpleadoAlreadyExistsException, EmpleadoEmailAlreadyExistsException {
        if( empleadoRepository.existsByNombreAndApellidoAllIgnoreCase(empleado.getNombre(),empleado.getApellido()))
            throw new EmpleadoAlreadyExistsException("Empleado : " + empleado.getNombre() + empleado.getApellido() +"  ya existe");
        if(empleadoRepository.existsByEmail(empleado.getEmail()))
            throw new EmpleadoEmailAlreadyExistsException( "EL email : " + empleado.getEmail() + "  Ya existe");
            return empleadoRepository.save(empleado);



    }

    @Override
    public Empleado empleadoUnica(Long id) throws EmpleadoNotFoundException {
        Empleado empleado = empleadoRepository.findByEmpleadoId(id);
        if(empleado != null ) {
            return empleado;
        }else {
            throw new EmpleadoNotFoundException("Empleado no encontrado con ese id  :" +id);
        }
    }

    @Override
    public void empleadoEliminar(Long id) {
        empleadoRepository.deleteById(id);
    }

    @Override
    public void editarEmpleado(Empleado empleado) {
        empleadoRepository.save(empleado);
    }
}
