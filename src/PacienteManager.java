
import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class PacienteManager {
    private List<Paciente> pacientes;

    public PacienteManager() {
        pacientes = new ArrayList<>();
    }

    public void registrarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public void modificarPaciente(int numeroIdentificacion, Paciente pacienteModificado) {
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).getNumeroIdentificacion() == numeroIdentificacion) {
                pacientes.set(i, pacienteModificado);
                break;
            }
        }
    }


    public Paciente buscarPacientePorNombre(String nombre) {
        for (Paciente paciente : pacientes) {
            if (paciente.getNombre().equalsIgnoreCase(nombre)) {
                return paciente;
            }
        }
        return null; // Si no se encuentra el paciente
    }



    public List<Paciente> ordenarPacientesPorNombre() {
        for (int i = 0; i < pacientes.size() - 1; i++) {
            for (int j = 0; j < pacientes.size() - 1 - i; j++) {
                if (pacientes.get(j).getNombre().compareTo(pacientes.get(j + 1).getNombre()) > 0) {
                    Paciente temp = pacientes.get(j);
                    pacientes.set(j, pacientes.get(j + 1));
                    pacientes.set(j + 1, temp);
                }
            }
        }
        return pacientes;
    }

    public List<Paciente> ordenarPacientesPorFechaNacimiento() {
        for (int i = 0; i < pacientes.size() - 1; i++) {
            for (int j = 0; j < pacientes.size() - 1 - i; j++) {
                if (pacientes.get(j).getFechaNacimiento().compareTo(pacientes.get(j + 1).getFechaNacimiento()) > 0) {
                    Paciente temp = pacientes.get(j);
                    pacientes.set(j, pacientes.get(j + 1));
                    pacientes.set(j + 1, temp);
                }
            }
        }
        return pacientes;
    }

    public static List<Paciente> ordenarPorIdentificacion(List<Paciente> pacientes) {
        for (int i = 0; i < pacientes.size() - 1; i++) {
            for (int j = 0; j < pacientes.size() - 1 - i; j++) {
                if (pacientes.get(j + 1).getNumeroIdentificacion() < pacientes.get(j).getNumeroIdentificacion()) {
                    Paciente temp = pacientes.get(j);
                    pacientes.set(j, pacientes.get(j + 1));
                    pacientes.set(j + 1, temp);
                }
            }
        }
        return pacientes;
    }
    public List<Paciente> buscarPacientes(String textoBusqueda) {
        List<Paciente> pacientesEncontrados = new ArrayList<>();
        for (Paciente paciente : pacientes) {
            if (paciente.getNombre().toLowerCase().contains(textoBusqueda.toLowerCase()) ||
                    String.valueOf(paciente.getNumeroIdentificacion()).toLowerCase().contains(textoBusqueda.toLowerCase()) ||
                    paciente.getFechaNacimiento().toString().contains(textoBusqueda)) {
                pacientesEncontrados.add(paciente);
            }
        }

        // Verificar si el texto ingresado contiene números, guiones y barras diagonales
        if (textoBusqueda.matches(".*\\d.*") && textoBusqueda.matches(".*[-/].*")) {
            // Validar el formato de fecha ingresado
            try {
                LocalDate.parse(textoBusqueda, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            } catch (DateTimeParseException ex) {
                JOptionPane.showMessageDialog(null, "El formato de fecha ingresado no es válido. Ingrese la fecha en formato aaaa-mm-dd.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        return pacientesEncontrados;
    }
    public List<Paciente> getPacientes() {
        return pacientes;
    }


    public void generarInformePacientes() {

    }
}