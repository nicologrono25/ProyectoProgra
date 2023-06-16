import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class Interfaz extends JFrame {
    private JPanel mainPanel;
    private JTabbedPane tabbedPane1;
    private JTabbedPane tabbedPane2;
    private JTextField textIngresonombre;
    private JTextField textNumIdentificacion;
    private JTextField textFechaNacimiento;
    private JTextArea textAmostrar;
    private JButton agregarButton;
    private JButton quemarDatosButton;
    private JButton limpiarButton;
    private JTextField textModifNombre;
    private JButton buscarModifButton;
    private JTextField textModifDireccion;
    private JTextField textModifCorreo;
    private JButton modificarButton;
    private JTextArea textAmodif;
    private JComboBox<String> comboBox1;
    private JButton mostrarButton;
    private JButton buscarButton1;
    private JTextField textFieldbuscar;
    private JTextArea textAMostrar;
    private JTextField textDireccion;
    private JTextField textGenero;
    private JTextField textCorreo;
    private JButton limpiarButton1;
    private JTextField textFieldNombre1;
    private JTextField textFieldMedico;
    private JTextField textFieldEspecialidad;
    private JButton agendarButton;
    private JTextArea textArea1;
    private JTextField textFieldFecha;
    private JTextField textFieldHora;
    private JButton buscarButtonCita;
    private JTextField textFieldFecha1;
    private JTextField textFieldHora1;
    private JButton modificarButton1;
    private JButton limpiarButton2;
    private JTextArea textArea2;
    private JTextField textFieldNombre2;
    private JTextField textFieldNombre3;
    private JButton buscarButtonCancelarCita;
    private JButton cancelarCitaButton;
    private JTextArea textArea3;
    private JComboBox comboBox2;
    private JButton mostrarButton1;
    private JTextField textField1;
    private JButton buscarButton;
    private JTextArea textArea4;
    private PacienteManager pacienteManager;
    private CitaManager citaManager;



    public Interfaz() {
        pacienteManager = new PacienteManager();
        citaManager = new CitaManager();
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = textIngresonombre.getText();
                int numeroIdentificacion = Integer.parseInt(textNumIdentificacion.getText());
                LocalDate fechaNacimiento = LocalDate.parse(textFechaNacimiento.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                String direccion = textDireccion.getText();
                boolean genero = Boolean.parseBoolean(textGenero.getText());
                String correo = textCorreo.getText();

                // Determinar el valor del género a mostrar
                String generoTexto = genero ? "Femenino" : "Masculino";

                // Crear un nuevo objeto Paciente con los datos ingresados
                Paciente paciente = new Paciente(nombre, numeroIdentificacion, fechaNacimiento, direccion, correo, genero);
                pacienteManager.registrarPaciente(paciente);

                textAmostrar.append("Paciente ingresado:\n"
                        + "Nombre: " + paciente.getNombre() + "\n"
                        + "Número de Identificación: " + paciente.getNumeroIdentificacion() + "\n"
                        + "Fecha de Nacimiento: " + paciente.getFechaNacimiento() + "\n"
                        + "Dirección: " + paciente.getDireccion() + "\n"
                        + "Correo: " + paciente.getCorreo() + "\n"
                        + "Género: " + generoTexto + "\n\n");
            }
        });

        quemarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Paciente paciente1 = new Paciente("Maria", 1763023231, LocalDate.of(1988, 4, 2), "La pradera", "maria@gmail.com", true);
                Paciente paciente2 = new Paciente("Luis", 1750731263, LocalDate.of(2014, 5, 3), "El bosque", "luis@gmail.com", false);
                Paciente paciente3 = new Paciente("Juan", 1800216327, LocalDate.of(2002, 1, 21), "La Armenia", "juan@gmail.com", false);
                Paciente paciente4 = new Paciente("Melany", 1416278926, LocalDate.of(1999, 6, 25), "Chillogallo", "melany@gmail.com", true);
                Paciente paciente5 = new Paciente("Roberto", 1286342722, LocalDate.of(2000, 4, 15), "Atahualpa", "roberto@gmail.com", false);

                pacienteManager.registrarPaciente(paciente1);
                pacienteManager.registrarPaciente(paciente2);
                pacienteManager.registrarPaciente(paciente3);
                pacienteManager.registrarPaciente(paciente4);
                pacienteManager.registrarPaciente(paciente5);

                textAmostrar.append("Datos quemados agregados:\n"
                        + paciente1.toString() + "\n"
                        + paciente2.toString() + "\n"
                        + paciente3.toString() + "\n"
                        + paciente4.toString() + "\n"
                        + paciente5.toString() + "\n");
            }
        });

        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Limpiar los campos de texto y el área de texto
                textIngresonombre.setText("");
                textNumIdentificacion.setText("");
                textFechaNacimiento.setText("");
                textDireccion.setText("");
                textGenero.setText("");
                textCorreo.setText("");
                textAmostrar.setText("");
            }
        });

        buscarModifButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = textModifNombre.getText();
                Paciente paciente = pacienteManager.buscarPacientePorNombre(nombre);

                if (paciente != null) {
                    textModifDireccion.setText(paciente.getDireccion());
                    textModifCorreo.setText(paciente.getCorreo());
                    textModifDireccion.setEditable(true);
                    textModifCorreo.setEditable(true);
                } else {
                    textAmodif.append("Paciente no encontrado.\n");
                }
            }
        });

        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = textModifNombre.getText();
                Paciente paciente = pacienteManager.buscarPacientePorNombre(nombre);

                if (paciente != null) {
                    String nuevaDireccion = textModifDireccion.getText();
                    String nuevoCorreo = textModifCorreo.getText();
                    paciente.setDireccion(nuevaDireccion);
                    paciente.setCorreo(nuevoCorreo);
                    textAmodif.append("Paciente modificado:\n"
                            + "Nombre: " + paciente.getNombre() + "\n"
                            + "Dirección modificada: " + paciente.getDireccion() + "\n"
                            + "Correo modificado: " + paciente.getCorreo() + "\n\n");
                    // Limpiar los campos de texto y deshabilitar la edición
                    textModifNombre.setText("");
                    textModifDireccion.setText("");
                    textModifCorreo.setText("");
                    textModifDireccion.setEditable(false);
                    textModifCorreo.setEditable(false);
                } else {
                    textAmodif.append("Paciente no encontrado.\n");
                }
            }
        });

        limpiarButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textModifNombre.setText("");
                textModifDireccion.setText("");
                textModifCorreo.setText("");
                textAmodif.setText("");

            }
        });

        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder sb = new StringBuilder();
                List<Paciente> pacientesOrdenados = new ArrayList<>();

                switch (comboBox1.getSelectedIndex()) {
                    case 0:
                        pacientesOrdenados = pacienteManager.ordenarPacientesPorNombre();
                        break;
                    case 1:
                        pacientesOrdenados = pacienteManager.ordenarPorIdentificacion(pacienteManager.getPacientes());
                        break;
                    case 2:
                        pacientesOrdenados = pacienteManager.ordenarPacientesPorFechaNacimiento();
                        break;
                }

                for (Paciente paciente : pacientesOrdenados) {
                    sb.append(paciente.toString());
                    sb.append("\n\n");
                }
                textAMostrar.setText(sb.toString());
            }
        });

        buscarButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textoBusqueda = textFieldbuscar.getText();
                List<Paciente> pacientesEncontrados = pacienteManager.buscarPacientes(textoBusqueda);
                StringBuilder sb = new StringBuilder();

                for (Paciente paciente : pacientesEncontrados) {
                    sb.append(paciente.toString());
                    sb.append("\n\n");
                }
                textAMostrar.setText(sb.toString());
            }
        });

        agendarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = textFieldNombre1.getText();
                String medico = textFieldMedico.getText();
                String especialidad = textFieldEspecialidad.getText();
                LocalDate fecha = LocalDate.parse(textFieldFecha.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                LocalTime hora = LocalTime.parse(textFieldHora.getText(), DateTimeFormatter.ofPattern("HH:mm"));
                LocalDateTime fechaHora = LocalDateTime.of(fecha, hora);

                // Crea un objeto Paciente con los datos ingresados
                Paciente paciente = new Paciente(nombre, 0, null, null, null, false);
                // Crea un objeto Medico con los datos ingresados
                Medico medicoObj = new Medico(medico, especialidad);

                // Llama al método agendarCita de citaManager para agendar la cita
                citaManager.agendarCita(paciente, medicoObj, fechaHora);

                // Mostrar la información en el JTextArea
                String citaInfo = "Cita agendada:\n"
                        + "Paciente: " + nombre + "\n"
                        + "Médico: " + medico + "\n"
                        + "Especialidad: " + especialidad + "\n"
                        + "Fecha: " + fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\n"
                        + "Hora: " + hora.format(DateTimeFormatter.ofPattern("HH:mm")) + "\n\n";
                textArea1.append(citaInfo);

                // Limpiar los campos de texto
                textFieldNombre1.setText("");
                textFieldMedico.setText("");
                textFieldEspecialidad.setText("");
                textFieldFecha.setText("");
                textFieldHora.setText("");
            }
        });
        buscarButtonCita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombrePaciente = textFieldNombre2.getText();

                // Verificar si se ingresó el nombre del paciente
                if (!nombrePaciente.isEmpty()) {
                    // Realizar la búsqueda de la cita por el nombre del paciente
                    Cita cita = null;
                    List<Cita> citasPaciente = citaManager.consultarCitasPaciente(nombrePaciente);
                    if (!citasPaciente.isEmpty()) {
                        // Mostrar la información de las citas encontradas
                        StringBuilder citaInfo = new StringBuilder("Citas encontradas para el paciente " + nombrePaciente + ":\n");
                        for (Cita c : citasPaciente) {
                            citaInfo.append("Médico: ").append(c.getMedico().getNombre()).append("\n");
                            citaInfo.append("Especialidad: ").append(c.getMedico().getEspecialidad()).append("\n");
                            citaInfo.append("Fecha: ").append(c.getFechaHora().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))).append("\n");
                            citaInfo.append("Hora: ").append(c.getFechaHora().format(DateTimeFormatter.ofPattern("HH:mm"))).append("\n\n");
                        }
                        textArea2.setText(citaInfo.toString());
                    } else {
                        textArea2.setText("No se encontraron citas para el paciente " + nombrePaciente + ".");
                    }
                } else {
                    textArea2.setText("Por favor, ingrese el nombre del paciente.");
                }
            }
        });


        modificarButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombrePaciente = textFieldNombre2.getText();
                String nuevaFecha = textFieldFecha1.getText();
                String nuevaHora = textFieldHora1.getText();

                // Verificar si se ingresó el nombre del paciente y la nueva fecha/hora
                if (!nombrePaciente.isEmpty() && !nuevaFecha.isEmpty() && !nuevaHora.isEmpty()) {
                    LocalDate fechaModificada = LocalDate.parse(nuevaFecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    LocalTime horaModificada = LocalTime.parse(nuevaHora, DateTimeFormatter.ofPattern("HH:mm"));
                    LocalDateTime nuevaFechaHora = LocalDateTime.of(fechaModificada, horaModificada);

                    // Buscar la cita correspondiente al nombre del paciente
                    Cita cita = null;
                    List<Cita> citasPaciente = citaManager.consultarCitasPaciente(nombrePaciente);
                    for (Cita c : citasPaciente) {
                        cita = c;
                        break;
                    }

                    if (cita != null) {
                        // Modificar la fecha y hora de la cita
                        cita.setFechaHora(nuevaFechaHora);

                        // Mostrar la información de la cita modificada
                        String citaInfo = "Cita modificada:\n"
                                + "Paciente: " + cita.getPaciente().getNombre() + "\n"
                                + "Médico: " + cita.getMedico().getNombre() + "\n"
                                + "Especialidad: " + cita.getMedico().getEspecialidad() + "\n"
                                + "Fecha: " + cita.getFechaHora().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\n"
                                + "Hora: " + cita.getFechaHora().format(DateTimeFormatter.ofPattern("HH:mm")) + "\n";
                        textArea2.setText(citaInfo);
                    } else {
                        textArea2.setText("No se encontró ninguna cita para el paciente " + nombrePaciente + ".");
                    }
                } else {
                    textArea2.setText("Por favor, ingrese el nombre del paciente y la nueva fecha/hora válidas.");
                }
            }
        });

        limpiarButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea2.setText(""); // Limpiar el contenido del textArea2
            }
        });
        buscarButtonCancelarCita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombrePaciente = textFieldNombre3.getText();

                // Verificar si se ingresó el nombre del paciente
                if (!nombrePaciente.isEmpty()) {
                    // Realizar la búsqueda de la cita por el nombre del paciente
                    Cita cita = null;
                    List<Cita> citasPaciente = citaManager.consultarCitasPaciente(nombrePaciente);
                    if (!citasPaciente.isEmpty()) {
                        // Mostrar la información de las citas encontradas
                        StringBuilder citaInfo = new StringBuilder("Citas encontradas para el paciente " + nombrePaciente + ":\n");
                        for (Cita c : citasPaciente) {
                            citaInfo.append("Médico: ").append(c.getMedico().getNombre()).append("\n");
                            citaInfo.append("Especialidad: ").append(c.getMedico().getEspecialidad()).append("\n");
                            citaInfo.append("Fecha: ").append(c.getFechaHora().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))).append("\n");
                            citaInfo.append("Hora: ").append(c.getFechaHora().format(DateTimeFormatter.ofPattern("HH:mm"))).append("\n\n");
                        }
                        textArea3.setText(citaInfo.toString());
                    } else {
                        textArea3.setText("No se encontraron citas para el paciente " + nombrePaciente + ".");
                    }
                } else {
                    textArea3.setText("Por favor, ingrese el nombre del paciente.");
                }


            }
        });
        cancelarCitaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombrePaciente = textFieldNombre3.getText(); // Asume que tienes un JTextField llamado nombreTextField para ingresar el nombre del paciente
                Cita cita = citaManager.buscarCitaPorNombre(nombrePaciente);

                if (cita != null) {
                    int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea cancelar la cita?", "Cancelar cita", JOptionPane.YES_NO_OPTION);

                    if (opcion == JOptionPane.YES_OPTION) {
                        if (cita.getFechaHora().isAfter(LocalDateTime.now())) {
                            citaManager.cancelarCita(cita);
                            textArea3.setText("La cita fue cancelada."); // Muestra "La cita fue cancelada" en el textarea3 en lugar de usar el JOptionPane
                        } else {
                            JOptionPane.showMessageDialog(null, "No se puede cancelar una cita que ya ha pasado.");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró una cita con el nombre del paciente ingresado.");
                }
            }
        });

        mostrarButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder sb = new StringBuilder();
                List<Cita> citasOrdenadas = new ArrayList<>();

                int selectedIndex = comboBox2.getSelectedIndex();


                switch (selectedIndex) {
                    case 0:
                        citaManager.ordenarCitasPorNombrePacienteBurbuja();
                        citasOrdenadas = citaManager.getCitas();
                        break;
                    case 1:
                        citaManager.ordenarCitasPorMedicoInsercion();
                        citasOrdenadas = citaManager.getCitas();
                        break;
                    case 2:
                        citaManager.ordenarCitasPorFechaHoraBurbuja();
                        citasOrdenadas = citaManager.getCitas();
                        break;
                }

                for (Cita cita : citasOrdenadas) {
                    Paciente paciente = cita.getPaciente();
                    if (paciente != null) {
                        sb.append("Paciente: ").append(paciente.getNombre()).append("\n");
                    }
                    Medico medico = cita.getMedico();
                    if (medico != null) {
                        sb.append("Médico: ").append(medico.getNombre()).append("\n");
                    }
                    sb.append("Fecha y hora: ").append(cita.getFechaHora()).append("\n");
                    sb.append("\n");
                }
                textArea4.setText(sb.toString());
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String busqueda = textField1.getText(); // Obtén el texto ingresado por el usuario para la búsqueda
                List<Cita> citasEncontradas = new ArrayList<>();

                if (!busqueda.isEmpty()) {
                    for (Cita cita : citaManager.getCitas()) {
                        Paciente paciente = cita.getPaciente();
                        Medico medico = cita.getMedico();
                        String fechaHora = cita.getFechaHora().toString();

                        if ((paciente != null && paciente.getNombre().toLowerCase().contains(busqueda.toLowerCase())) ||
                                (medico != null && medico.getNombre().toLowerCase().contains(busqueda.toLowerCase())) ||
                                fechaHora.contains(busqueda)) {
                            citasEncontradas.add(cita);
                        }
                    }
                }

                StringBuilder sb = new StringBuilder();
                for (Cita cita : citasEncontradas) {
                    Paciente paciente = cita.getPaciente();
                    if (paciente != null) {
                        sb.append("Paciente: ").append(paciente.getNombre()).append("\n");
                    }
                    Medico medico = cita.getMedico();
                    if (medico != null) {
                        sb.append("Médico: ").append(medico.getNombre()).append("\n");
                    }
                    sb.append("Fecha y hora: ").append(cita.getFechaHora()).append("\n");
                    sb.append("\n");
                }
                textArea4.setText(sb.toString());

                // Verificar si el texto ingresado contiene números
                if (busqueda.matches(".*\\d.*")) {
                    // Validar el formato de fecha ingresado
                    try {
                        LocalDate.parse(busqueda, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    } catch (DateTimeParseException ex) {
                        JOptionPane.showMessageDialog(null, "El formato de fecha ingresado no es válido. Ingrese la fecha en formato aaaa-mm-dd.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

    }


    public JPanel getMainPanel() {
        return mainPanel;
    }
}
