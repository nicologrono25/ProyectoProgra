import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CitaManager {

    private List<Cita> citas;
    private Stack<Cita> historialCitas;
    public List<Cita> getCitas() {
        return citas;
    }

    public CitaManager() {
        this.citas = new ArrayList<>();
        this.historialCitas = new Stack<>();
    }

    public void agendarCita(Paciente paciente, Medico medico, LocalDateTime fechaHora) {
        Cita cita = new Cita(fechaHora, paciente, medico);
        citas.add(cita);
    }


    public List<Cita> consultarCitasPaciente(int numeroIdentificacion) {
        List<Cita> citasPaciente = new ArrayList<>();
        for (Cita cita : citas) {
            if (cita.getPaciente() != null && cita.getPaciente().getNumeroIdentificacion() == numeroIdentificacion) {
                citasPaciente.add(cita);
            }
        }
        return citasPaciente;
    }

    public List<Cita> consultarCitasPaciente(String nombrePaciente) {
        List<Cita> citasPaciente = new ArrayList<>();
        for (Cita cita : citas) {
            if (cita.getPaciente() != null && cita.getPaciente().getNombre().equalsIgnoreCase(nombrePaciente)) {
                citasPaciente.add(cita);
            }
        }
        return citasPaciente;
    }

    public List<Cita> consultarCitasMedico(String nombreMedico) {
        List<Cita> citasMedico = new ArrayList<>();
        for (Cita cita : citas) {
            if (cita.getMedico().getNombre().equalsIgnoreCase(nombreMedico)) {
                citasMedico.add(cita);
            }
        }
        return citasMedico;
    }

    public void cancelarCita(Cita cita) {
        citas.remove(cita);
    }

    public String generarInformeCitas() {
        StringBuilder informe = new StringBuilder();
        informe.append("Informe de citas:\n");
        for (Cita cita : citas) {
            Paciente paciente = cita.getPaciente();
            if (paciente != null) {
                informe.append("Paciente: ").append(paciente.getNombre()).append("\n");
            }
            Medico medico = cita.getMedico();
            if (medico != null) {
                informe.append("Médico: ").append(medico.getNombre()).append("\n");
            }
            informe.append("Fecha y hora: ").append(cita.getFechaHora()).append("\n\n");
        }
        return informe.toString();
    }

    public Stack<Cita> getHistorialCitas() {
        return historialCitas;
    }

    public Cita buscarCitaPorNombre(String nombrePaciente) {
        for (Cita cita : citas) {
            if (cita.getPaciente().getNombre().equalsIgnoreCase(nombrePaciente)) {
                return cita;
            }
        }
        return null;
    }


    public Cita buscarCitaPorFechaHora(LocalDateTime fechaHora) {
        for (Cita cita : citas) {
            if (cita.getFechaHora().isEqual(fechaHora)) {
                return cita;
            }
        }
        return null;
    }

    public String calcularEstadisticasCitas() {
        int totalCitas = citas.size();
        int citasCanceladas = 0;
        int citasRealizadas = 0;

        if (totalCitas > 0) {
            for (Cita cita : citas) {
                if (cita.getFechaHora().isBefore(LocalDateTime.now())) {
                    citasRealizadas++;
                } else {
                    citasCanceladas++;
                }
            }

            double porcentajeCanceladas = (double) citasCanceladas / totalCitas * 100;
            double porcentajeRealizadas = (double) citasRealizadas / totalCitas * 100;

            String estadisticas = "Estadísticas de citas:\n";
            estadisticas += "Total de citas: " + totalCitas + "\n";
            estadisticas += "Citas canceladas: " + citasCanceladas + " (" + porcentajeCanceladas + "%)\n";
            estadisticas += "Citas realizadas: " + citasRealizadas + " (" + porcentajeRealizadas + "%)\n";

            return estadisticas;
        } else {
            return "No hay citas registradas.";
        }
    }

    public void ordenarCitasPorFechaHoraBurbuja() {
        int n = citas.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                LocalDateTime fechaHora1 = citas.get(j).getFechaHora();
                LocalDateTime fechaHora2 = citas.get(j + 1).getFechaHora();
                if (fechaHora1.isAfter(fechaHora2)) {
                    Cita temp = citas.get(j);
                    citas.set(j, citas.get(j + 1));
                    citas.set(j + 1, temp);
                }
            }
        }
    }

    public void ordenarCitasPorMedicoInsercion() {
        int n = citas.size();
        for (int i = 1; i < n; ++i) {
            Cita key = citas.get(i);
            int j = i - 1;

            while (j >= 0 && citas.get(j).getMedico().getNombre().compareTo(key.getMedico().getNombre()) > 0) {
                citas.set(j + 1, citas.get(j));
                j = j - 1;
            }
            citas.set(j + 1, key);
        }
    }

    public void ordenarCitasPorNombrePacienteBurbuja() {
        int n = citas.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                String nombre1 = citas.get(j).getPaciente().getNombre();
                String nombre2 = citas.get(j + 1).getPaciente().getNombre();
                if (nombre1.compareTo(nombre2) > 0) {
                    Cita temp = citas.get(j);
                    citas.set(j, citas.get(j + 1));
                    citas.set(j + 1, temp);
                }
            }
        }
    }
}
