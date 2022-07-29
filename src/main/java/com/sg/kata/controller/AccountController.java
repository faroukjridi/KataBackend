package com.sg.kata.controller;


import com.sg.kata.factory.AccountFactory;
import com.sg.kata.models.AccountStatement;
import com.sg.kata.services.AccountService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/account")
public class AccountController {

    @GET
    @Path("/history")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHistory() {
        AccountService service = AccountFactory.getInstance().buildAccountService();
        List<AccountStatement> statements = service.history();
        return Response.ok().entity(statements).build();
    }

    @POST
    @Path("/deposit/{amount}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deposit(@PathParam("amount") double amount) {
        AccountService service = AccountFactory.getInstance().buildAccountService();
        AccountStatement statement = service.deposit(amount);
        return Response.ok().entity(statement).build();
    }

    @POST
    @Path("/withdrawal/{amount}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response withdrawal(@PathParam("amount") double amount) {
        AccountService service = AccountFactory.getInstance().buildAccountService();
        AccountStatement statement = service.withdrawal(amount);
        return Response.ok().entity(statement).build();
    }
}
