package pl.norb.CarFactory.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import pl.norb.CarFactory.model.Equipment;
import pl.norb.CarFactory.repository.EquipmentRepository;

@Path("equipments")
public class EquipmentResources {

	EquipmentRepository equipmentRepository = new EquipmentRepository();

	@GET
	@Consumes("text/plain,text/html")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Equipment> getAllEquipments(@Context UriInfo uriInfo) {
		List<Equipment> equipments = equipmentRepository.getEquipments();
		for (Equipment equipment : equipments) {
			String uri1 = uriInfo.getAbsolutePathBuilder().build().toString();
			equipment.addLink(uri1, "self", "GET");
			String uri2 = uriInfo.getBaseUriBuilder().path(EquipmentResources.class)
					.path(Integer.toString(equipment.getIdEquipment())).build().toString();
			equipment.addLink(uri2, "equipment", "GET");
		}
		return equipmentRepository.getEquipments();
	}

	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Equipment getEquipment(@PathParam("id") int id, @Context UriInfo uriInfo) {
		Equipment equipment = equipmentRepository.getEquipment(id);
		String uri = uriInfo.getAbsolutePathBuilder().toString();
		equipment.addLink(uri, "self", "GET");
		return equipmentRepository.getEquipment(id);

	}
}
