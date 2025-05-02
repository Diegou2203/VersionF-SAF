package pe.edu.upc.safealert.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.safealert.entities.TipoFenomeno;

@Repository
public interface ITipoFenomenoRepository extends JpaRepository<TipoFenomeno, Integer> {
}