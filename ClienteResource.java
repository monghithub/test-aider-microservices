package com.example.clientes.resource;

import com.example.clientes.model.Cliente;
import com.example.clientes.service.ClienteService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteResource {

    private final ClienteService clienteService;

    public ClienteResource(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GET
    public List<Cliente> getAllClientes() {
        return clienteService.getAllClientes();
    }

    @GET
    @Path("/{id}")
    public Response getClienteById(@PathParam("id") Long id) {
        Optional<Cliente> cliente = clienteService.getClienteById(id);
        if (cliente.isPresent()) {
            return Response.ok(cliente.get()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    public Response createCliente(Cliente cliente) {
        Cliente createdCliente = clienteService.createCliente(cliente);
        return Response.status(Response.Status.CREATED).entity(createdCliente).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateCliente(@PathParam("id") Long id, Cliente cliente) {
        Optional<Cliente> updatedCliente = clienteService.updateCliente(id, cliente);
        if (updatedCliente.isPresent()) {
            return Response.ok(updatedCliente.get()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCliente(@PathParam("id") Long id) {
        boolean deleted = clienteService.deleteCliente(id);
        if (deleted) {
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
