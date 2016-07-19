package com.example.helloworld.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.codahale.metrics.annotation.Timed;
import com.example.helloworld.database.Manager;
import com.example.helloworld.database.ManagerDAO;

@Path("/Manager")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NewManager {
	private ManagerDAO managerDAO;

	public NewManager(ManagerDAO dao) {
		managerDAO = dao;
	}

	@GET
	@Path("/{id}")
	@Timed
	public Manager getUser(@PathParam("id") Integer id) {
		Manager u = managerDAO.findById(id);

		if (u != null) {
			return u;
		} else {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
	}

	@GET
	@Timed
	public List<Manager> listManagers() {
		return managerDAO.getAll();
	}

	@POST
	@Timed
	public void save(Manager manager) {
		if (manager != null) {
			managerDAO.insert(manager);
			throw new WebApplicationException(Response.Status.OK);
		} else {
			throw new WebApplicationException(Status.BAD_REQUEST);
		}
	}

	@PUT
	@Path("/{id}")
	public void update(@PathParam("id") int id, Manager manager) {
		if (manager != null) {
			managerDAO.update(manager, id);
			throw new WebApplicationException(Response.Status.OK);
		} else {
			throw new WebApplicationException(Status.BAD_REQUEST);
		}
	}

	@DELETE
	@Path("/{id}")
	@Timed
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN })
	public void deleteManager(@PathParam("id") Integer id) {
		if (managerDAO.findById(id) != null) {
			managerDAO.deleteById(id);
			throw new WebApplicationException(Response.Status.OK);
		} else {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
	}

}
