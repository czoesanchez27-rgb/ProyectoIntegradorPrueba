package org.integracode.chatapp.rest;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.integracode.chatapp.controller.CalReciclaje;
import org.integracode.chatapp.model.Reciclaje;

@Path("reciclaje")
public class RESTCalReciclaje {

    @GET
    @Path("calcular")
    @Produces(MediaType.APPLICATION_JSON)
    public Response calcular(
            @QueryParam("material") @DefaultValue("") String material,
            @QueryParam("cantidad") @DefaultValue("0") double cantidad
    ) {
        
        Reciclaje r = new Reciclaje();
        r.setMaterial(material);
        r.setCantidad(cantidad);

       
        CalReciclaje cal = new CalReciclaje();
        cal.calcular(r);

       
        String json = """
        {
          "material" : "%s",
          "cantidad" : %.2f,
          "puntos" : %.2f
        }
        """;

        json = String.format(
                json,
                r.getMaterial(),
                r.getCantidad(),
                r.getPuntos()
        );

        return Response.ok(json).build();
    }
}


