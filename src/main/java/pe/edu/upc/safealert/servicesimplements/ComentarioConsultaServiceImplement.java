package pe.edu.upc.safealert.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.safealert.entities.ComentarioConsulta;
import pe.edu.upc.safealert.repositories.IComentarioConsultaRepository;
import pe.edu.upc.safealert.servicesinterfaces.IComentarioConsultaService;

import java.util.List;

@Service
public class ComentarioConsultaServiceImplement implements IComentarioConsultaService {

    @Autowired
    private IComentarioConsultaRepository coR;

    @Override
    public List<ComentarioConsulta> list() {return coR.findAll();}

    @Override
    public void insert(ComentarioConsulta co) {coR.save(co);}

    @Override
    public ComentarioConsulta listarId(int idComentario) {
        return coR.findById(idComentario).orElse(new ComentarioConsulta());
    }

    @Override
    public void delete(int idComentario) {coR.deleteById(idComentario);}

    @Override
    public void update(ComentarioConsulta co) {
        coR.save(co);}



    @Override
    public List<String[]> contarcomentariousuario() {
        return coR.contarcomentariousuario();
    }
}
