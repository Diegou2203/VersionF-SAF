package pe.edu.upc.safealert.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.safealert.entities.Respuesta;

import java.util.List;

@Repository
public interface IRespuestaRepository extends JpaRepository<Respuesta, Integer> {
    @Query("SELECT \n" +
            "    r\n" +
            "FROM \n" +
            "    Respuesta r\n" +
            "WHERE \n" +
            "    r.titulo LIKE %:titulo%")
    public List<Respuesta> buscartitulo(@Param("titulo") String titulo);

    @Query(value = "SELECT u.username, r.titulo, r.contenido, COUNT(r.id_respuesta) AS cantidad_respuestas\n" +
            "FROM Usuario u\n" +
            "JOIN Respuesta r ON u.id_usuario = r.id_usuario\n" +
            "GROUP BY u.username, r.titulo, r.contenido\n" +
            "ORDER BY cantidad_respuestas DESC",nativeQuery = true)
    public List<String[]> cantidadRespuestasPorUsuario();



}