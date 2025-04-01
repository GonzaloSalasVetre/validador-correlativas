import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;

@Getter
@Setter
public class Inscripcion {
    private Alumno alumno;
    private List<Materia> asignaturas;
    private boolean estaAprobada;

    public Inscripcion(Alumno alumno, List<Materia> asignaturas) {
        this.alumno = alumno;
        this.asignaturas = asignaturas;
        this.estaAprobada = false;
    }

    public boolean aprobada() {

        estaAprobada = asignaturas.stream().allMatch(materia -> new HashSet<>(alumno.getMateriasAprobadas()).containsAll(materia.getCorrelativas()));

        return estaAprobada;
    }
}