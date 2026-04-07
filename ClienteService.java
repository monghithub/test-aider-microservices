package com.example.clientes.service;

import com.example.clientes.model.Cliente;
import com.example.clientes.repository.ClienteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> getAllClientes() {
        return clienteRepository.listAll();
    }

    public Cliente getClienteById(Long id) {
        return clienteRepository.findById(id);
    }

    @Transactional
    public Cliente createCliente(Cliente cliente) {
        clienteRepository.persist(cliente);
        return cliente;
    }

    @Transactional
    public Cliente updateCliente(Long id, Cliente clienteDetails) {
        Cliente cliente = clienteRepository.findById(id);
        if (cliente != null) {
            cliente.nombre = clienteDetails.nombre;
            cliente.email = clienteDetails.email;
            cliente.telefono = clienteDetails.telefono;
            return cliente;
        }
        return null;
    }

    @Transactional
    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
