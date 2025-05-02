package pe.edu.upc.safealert.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.safealert.entities.Ubicacion;

@Repository
public interface IUbicacionRepository extends JpaRepository<Ubicacion, Integer> {
}
