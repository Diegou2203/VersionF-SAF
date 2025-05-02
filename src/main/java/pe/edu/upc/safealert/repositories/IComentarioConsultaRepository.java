package pe.edu.upc.safealert.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.safealert.entities.ComentarioConsulta;

import java.util.List;

@Repository
public interface IComentarioConsultaRepository extends JpaRepository<ComentarioConsulta,Integer> {


    @Query(value = "SELECT \n" +
            "    u.username, \n" +
            "    COUNT(*) AS cantidad_comentarios\n" +
            "FROM \n" +
            "    Comentario_Consulta c\n" +
            "INNER JOIN \n" +
            "    Usuario u ON c.id_usuario = u.id_usuario\n" +
            "GROUP BY \n" +
            "    u.username",nativeQuery = true)
    public List<String[]> contarcomentariousuario();

}

