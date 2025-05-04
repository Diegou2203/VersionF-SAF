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

    @Query(value = "SELECT r.rol, COUNT(*) AS cantidad_respuestas\n" +
            "FROM usuario u\n" +
            "INNER JOIN respuesta rp ON u.id_usuario=rp.id_usuario\n" +
            "INNER JOIN rol r ON u.id_rol=r.id_rol\n" +
            "GROUP BY r.rol",nativeQuery = true)
    public List<String[]> contarrespuesta();

    @Query(value = "SELECT cc.contenido, cc.estado, COUNT(id_respuesta)\n" +
            "FROM comentario_consulta cc\n" +
            "INNER JOIN respuesta r ON r.id_usuario = cc.id_usuario\n" +
            "WHERE cc.estado = 'revisado'\n" +
            "GROUP BY cc.contenido, cc.estado", nativeQuery = true)
    public List<String[]> cantidadRespuestasPorComentario();

}
