package pe.edu.upc.safealert.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.safealert.entities.ComentarioConsulta;

import java.util.List;

@Repository
public interface IComentarioConsultaRepository extends JpaRepository<ComentarioConsulta,Integer> {


    @Query(value = "SELECT \n" +
            "    u.username,\n" +
            "    c.contenido,\n" +
            "    c.fecha_comentario\n" +
            "FROM comentario_consulta c\n" +
            "JOIN Respuesta r ON c.id_respuesta = r.id_respuesta\n" +
            "JOIN Usuario u ON r.id_usuario = u.id_usuario\n" +
            "WHERE c.tema = :tema",nativeQuery = true)
    public List<String[]> BusquedaPorTema(@Param("tema")String tema);


    @Query(value = "SELECT cc.contenido, cc.estado, COUNT(cc.id_respuesta)\n" +
            "            FROM comentario_consulta cc\n" +
            "            INNER JOIN respuesta r ON r.id_respuesta = cc.id_respuesta\n" +
            "            WHERE cc.estado = 'revisado'\n" +
            "            GROUP BY cc.contenido, cc.estado", nativeQuery = true)
    public List<String[]> cantidadRespuestasPorComentario();

}

