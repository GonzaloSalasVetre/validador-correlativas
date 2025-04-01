import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InscripcionTest {

    @Test
    @DisplayName("Inscripcion aprobada")
    public void test1() {
        Materia algoritmos =  new Materia("Algoritmos");
        Materia discreta =  new Materia("Matematica Discreta");
        Materia paradigmas =  new Materia("Paradigmas de Programación");
        Materia sintaxis = new Materia("Sintaxis");

        paradigmas.agregarCorrelativa(algoritmos);
        paradigmas.agregarCorrelativa(discreta);

        sintaxis.agregarCorrelativa(algoritmos);
        sintaxis.agregarCorrelativa(discreta);

        Alumno alumno = new Alumno("Gonzalo");
        alumno.agregarMateriaAprobada(algoritmos);
        alumno.agregarMateriaAprobada(discreta);

        List<Materia> materiasAInscribir = new ArrayList<Materia>();
        materiasAInscribir.add(paradigmas);
        materiasAInscribir.add(sintaxis);

        Inscripcion inscripcion = new Inscripcion(alumno, materiasAInscribir);

        assertTrue(inscripcion.aprobada());
    }

    @Test
    @DisplayName("Inscripcion rechazada")
    public void test2() {
        Materia algoritmos =  new Materia("Algoritmos");
        Materia discreta =  new Materia("Matematica Discreta");
        Materia paradigmas =  new Materia("Paradigmas de Programación");
        Materia sintaxis = new Materia("Sintaxis");

        paradigmas.agregarCorrelativa(algoritmos);
        paradigmas.agregarCorrelativa(discreta);

        sintaxis.agregarCorrelativa(algoritmos);
        sintaxis.agregarCorrelativa(discreta);

        Alumno alumno = new Alumno("Gonzalo");
        alumno.agregarMateriaAprobada(algoritmos);

        List<Materia> materiasAInscribir = new ArrayList<Materia>();
        materiasAInscribir.add(paradigmas);
        materiasAInscribir.add(sintaxis);

        Inscripcion inscripcion = new Inscripcion(alumno, materiasAInscribir);

        assertFalse(inscripcion.aprobada());
    }

}