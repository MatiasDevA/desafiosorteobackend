package com.example.desafiosorteo.Repository;

import com.example.desafiosorteo.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado,Long> {


   boolean existsByNombreAndApellidoAllIgnoreCase(String nombre, String apellido);

    boolean existsByNombre(String nombre);

    boolean existsByEmail(String email);

    Empleado findByEmpleadoId(Long id);
}
