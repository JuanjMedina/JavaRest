package com.example.apirestjava.controller;


import com.example.apirestjava.model.dto.ClienteDto;
import com.example.apirestjava.model.entity.Cliente;
import com.example.apirestjava.model.payload.MensajeResponse;
import com.example.apirestjava.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {

    @Autowired
    private IClientService clienteService;


    @PostMapping("cliente")
    public ResponseEntity<?> create(@RequestBody ClienteDto clienteDto) {
        Cliente clienteSave = null;
        try {
            clienteSave = clienteService.save(clienteDto);
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("Guardado correctamente")
                    .object(ClienteDto.builder()
                            .idCliente(clienteSave.getIdCliente())
                            .nombre(clienteSave.getNombre())
                            .apellido(clienteSave.getApellido())
                            .correo(clienteSave.getCorreo())
                            .fechaRegistro(clienteSave.getFechaRegistro())
                            .build())
                    .build()
                    , HttpStatus.CREATED);
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje(exDt.getMessage())
                            .object(null)
                            .build()
                    , HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @PutMapping("cliente/{id}")
    public ResponseEntity<?> update(@RequestBody ClienteDto clienteDto, @PathVariable Integer id) {
        Cliente clienteUpdate = null;
        try {
            if (!clienteService.existsById(id)) {
                return new ResponseEntity<>(
                        MensajeResponse.builder()
                                .mensaje("Cliente no encontrado")
                                .object(null)
                                .build()
                        , HttpStatus.NOT_FOUND);

            }
            clienteDto.setIdCliente(id);
            clienteUpdate = clienteService.save(clienteDto);
            return new ResponseEntity<>(
                    MensajeResponse.builder().mensaje("Objeto actualizado correctamente").object(
                                    ClienteDto.builder()
                                            .idCliente(clienteUpdate.getIdCliente())
                                            .nombre(clienteUpdate.getNombre())
                                            .apellido(clienteUpdate.getApellido())
                                            .correo(clienteUpdate.getCorreo())
                                            .fechaRegistro(clienteUpdate.getFechaRegistro())
                                            .build())
                            .build()
                    , HttpStatus.OK);

        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje(exDt.getMessage())
                            .object(null)
                            .build()
                    , HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }


    @DeleteMapping("cliente/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            Cliente clienteDelete = clienteService.findById(id);
            clienteService.delete(clienteDelete);
            return new ResponseEntity<>(clienteDelete, HttpStatus.NO_CONTENT);
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje(exDt.getMessage())
                            .object(null)
                            .build(), HttpStatus.INTERNAL_SERVER_ERROR);


        }
    }


    @GetMapping("cliente/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> searchById(@PathVariable Integer id) {
        Cliente cliente = clienteService.findById(id);
        if (cliente == null) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje("Registro invalido")
                            .object(null)
                            .build(), HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity<>(
                MensajeResponse.builder()
                        .mensaje("")
                        .object(ClienteDto.builder()
                                .idCliente(cliente.getIdCliente())
                                .nombre(cliente.getNombre())
                                .apellido(cliente.getApellido())
                                .correo(cliente.getCorreo())
                                .fechaRegistro(cliente.getFechaRegistro())
                                .build())
                        .build()
                , HttpStatus.OK);
    }
}
