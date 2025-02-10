

package org.example.oncocoderswebapp.service;

import org.example.oncocoderswebapp.model.User;
import org.example.oncocoderswebapp.model.UserFormResponse;
import org.example.oncocoderswebapp.repository.UserFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserFormService {

    @Autowired
    private UserFormRepository userFormRepository;


    public void save(User usuario, String pregunta1, String pregunta2, String pregunta3) {
       UserFormResponse respuestaFormulario = new UserFormResponse();

        respuestaFormulario.setUsuario(usuario);
        respuestaFormulario.setPregunta1(pregunta1);
        respuestaFormulario.setPregunta2(pregunta2);
        respuestaFormulario.setPregunta3(pregunta3);

        respuestaFormulario.setFechaRespuesta(LocalDateTime.now());

        userFormRepository.save(respuestaFormulario);

    }


}
