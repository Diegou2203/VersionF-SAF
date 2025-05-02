package pe.edu.upc.safealert.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.safealert.entities.Simulacro;

@Repository
public interface ISimulacroRepository extends JpaRepository<Simulacro, Integer> {
}
