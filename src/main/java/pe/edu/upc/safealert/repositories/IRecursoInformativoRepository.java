package pe.edu.upc.safealert.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.safealert.entities.RecursoInformativo;

import java.util.List;

@Repository
public interface IRecursoInformativoRepository extends JpaRepository<RecursoInformativo, Integer> {
    @Query(value = "SELECT u.username, COUNT(id_recurso_informativo)\n" +
            "FROM usuario u INNER JOIN recurso_informativo ri ON u.id_usuario=ri.id_usuario\n" +
            "GROUP BY u.username", nativeQuery = true)
    public List<String[]> cantidadRecursosPorUsuario();
}
