package com.example.helloworld.resources;

import com.example.helloworld.filter.DateRequired;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/filtered")
public class FilteredResource {

    @Inject
    public FilteredResource(){

    }

    @GET
    @DateRequired
    @Path("hello")
    public String sayHello() {
        return "hello";
    }
}
