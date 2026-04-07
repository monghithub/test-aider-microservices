package com.example.clientes.service;

import com.example.clientes.model.Cliente;
import com.example.clientes.repository.ClienteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> getAllClientes() {
        return clienteRepository.listAll();
    }

    public Optional<Cliente> getClienteById(Long id) {
        return Optional.ofNullable(clienteRepository.findById(id));
    }

    @Transactional
    public Cliente createCliente(Cliente cliente) {
        clienteRepository.persist(cliente);
        return cliente;
    }

    @Transactional
    public Optional<Cliente> updateCliente(Long id, Cliente clienteDetails) {
        Cliente cliente = clienteRepository.findById(id);
        if (cliente != null) {
            cliente.nombre = clienteDetails.nombre;
            cliente.email = clienteDetails.email;
            cliente.telefono = clienteDetails.telefono;
            return Optional.of(cliente);
        }
        return Optional.empty();
    }

    @Transactional
    public boolean deleteCliente(Long id) {
        Cliente cliente = clienteRepository.findById(id);
        if (cliente != null) {
            clienteRepository.delete(cliente);
            return true;
        }
        return false;
    }
}
