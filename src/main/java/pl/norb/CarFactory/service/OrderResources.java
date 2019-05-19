package pl.norb.CarFactory.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pl.norb.CarFactory.model.Order;
import pl.norb.CarFactory.repository.OrderRpository;

@Path("orders")
public class OrderResources {
	OrderRpository orderRpository = new OrderRpository();

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Order> getAllOlders() {
		return orderRpository.getOrders();
	}

	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Order getOrder(@PathParam("id") int id) {
		return orderRpository.getOrder(id);
	}
}
