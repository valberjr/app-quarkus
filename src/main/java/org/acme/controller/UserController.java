package org.acme.controller;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.controller.entity.UserEntity;
import org.acme.service.UserService;

import java.util.UUID;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GET
    public Response findAll(@QueryParam("page") @DefaultValue("0") Integer page,
                            @QueryParam("pageSize") @DefaultValue("10") Integer pageSize) {
        return Response.ok(userService.findAll(page, pageSize)).build();
    }

    @GET
    @Path("/{id}")
    public Response findAll(@PathParam("id") UUID userId) {
        return Response.ok(userService.findById(userId)).build();
    }

    @POST
    @Transactional
    public Response createUser(UserEntity userEntity) {
        return Response.ok(userService.createUser(userEntity)).build();
    }

    @PUT()
    @Path("/{id}")
    @Transactional
    public Response updateUser(@PathParam("id") UUID userId, UserEntity userEntity) {
        return Response.ok(userService.updateUser(userId, userEntity)).build();
    }
}
