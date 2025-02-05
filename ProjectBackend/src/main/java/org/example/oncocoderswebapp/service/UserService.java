package org.example.oncocoderswebapp.service;

import org.example.oncocoderswebapp.model.User;
import org.example.oncocoderswebapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public Optional<User> findByName(String name) {
        return this.userRepository.findByName(name);
    }

    public Optional<User> findById(Long id) {
        return this.userRepository.findById(id);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public boolean isValidUser(User user) {
        Long id = user.getId();
        String name = user.getName();
        String email = user.getEmail();
        String password = user.getEncodedPassword();

        if (id!=null) {
            return false;
        } else if (name==null || name.isEmpty()){
            return false;
        } else if (email==null || email.isEmpty()){
            return false;
        } else if (password==null || password.isEmpty()){
            return false;
        }
        return true;

    }

    public void save(User user) {
        this.userRepository.save(user);
    }

    public List<User> findAvailableDoctors(String comunidadAutonoma, String hospitalReferencia) {
        return this.userRepository.findAvailableDoctors(comunidadAutonoma,hospitalReferencia,"CLINICCUSER");
    }

    public void asignarPacienteAMedico(User paciente, User medico) {
        if (medico.addPaciente(paciente)) {  // Verifica si la relación es válida
            userRepository.save(medico);  // Guarda el médico con la nueva lista de pacientes
            userRepository.save(paciente); // Guarda el paciente con su médico asignado
        }
    }

    public void asignarPacienteAMedico(User paciente) {
        List<User> medicosHospital = userRepository.findAvailableDoctorsByHospital(
                paciente.getComunidadAutonoma(), paciente.getHospitalReferencia());

        User medicoAsignado = encontrarMedicoDisponible(medicosHospital);

        if (medicoAsignado == null) {
            List<User> medicosComunidad = userRepository.findAvailableDoctorsByCommunity(paciente.getComunidadAutonoma());
            medicoAsignado = encontrarMedicoDisponible(medicosComunidad);
        }

        if (medicoAsignado != null) {
            medicoAsignado.addPaciente(paciente);
            paciente.setMedicUser(medicoAsignado);
            userRepository.save(medicoAsignado);
            userRepository.save(paciente);

            System.out.println("Paciente " + paciente.getName() + " asignado a " + medicoAsignado.getName());
        } else {
            System.out.println("No hay médicos disponibles para " + paciente.getName());
        }
    }

    private User encontrarMedicoDisponible(List<User> medicos) {
        for (User medico : medicos) {
            if (medico.getPacientes().size() < 20) {
                return medico;
            }
        }
        return null;
    }

    public void updateUser(User user) {
        Optional<User> existingUserOptional = userRepository.findById(user.getId());

        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();

            if (user.getName() != null && !user.getName().isEmpty()) {
                existingUser.setName(user.getName());
            }

            userRepository.save(existingUser);
        } else {
            throw new IllegalArgumentException("Usuario no encontrado con ID: " + user.getId());
        }
    }



}
