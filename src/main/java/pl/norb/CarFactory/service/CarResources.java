package pl.norb.CarFactory.service;

import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import pl.norb.CarFactory.model.Car;
import pl.norb.CarFactory.repository.CarDepot;
import pl.norb.CarFactory.repository.CarRepository;

@Path("cars")
public class CarResources {

	CarDepot carDepot = new CarDepot();
	CarRepository carRepository = new CarRepository();

	@GET
	@Path("portfolio")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Car> getAllProdCars(@Context UriInfo uriInfo) {
		List<Car> cars = carRepository.getAllProducedCars();
		for (Car car : cars) {
			// cars/portfolio
			String uri1 = uriInfo.getBaseUriBuilder().path(CarResources.class)
					.path(CarResources.class, "getAllProdCars").build().toString();
			car.addLink(uri1, "self", "GET");
			// cars/portfolio/id
			String uri2 = uriInfo.getBaseUriBuilder().path(CarResources.class)
					.path(CarResources.class, "getAllProdCars").path(Integer.toString(car.getIdCar())).build()
					.toString();
			car.addLink(uri2, "car", "GET");
			// cars/portfolio/id/produce
			String uri3 = uriInfo.getBaseUriBuilder().path(CarResources.class)
					.path(CarResources.class, "getAllProdCars").path(Integer.toString(car.getIdCar())).path("produce")
					.build().toString();
			car.addLink(uri3, "Car_to_produce", "POST");
			// cars/onDepot
			String uri4 = uriInfo.getBaseUriBuilder().path(CarResources.class).path(CarResources.class, "getAllCars")
					.build().toString();
			car.addLink(uri4, "Cars_on_Depot", "GET");
			// equipments
			String uri5 = uriInfo.getBaseUriBuilder().path(EquipmentResources.class).build().toString();
			car.addLink(uri5, "Equipments", "GET");
			// options
			String uri6 = uriInfo.getBaseUriBuilder().path(OptionResources.class).build().toString();
			car.addLink(uri6, "Equipments", "GET");

		}

		return carRepository.getAllProducedCars();
	}

	@GET
	@Path("portfolio/{id}")
	@Consumes("text/plain")
	@Produces({ MediaType.APPLICATION_JSON })
	public Car getCar(@PathParam("id") int id, @Context UriInfo uriInfo) {
		Car car = carRepository.getCarToProduction(id);
		String uri1 = uriInfo.getBaseUriBuilder().path(CarResources.class).path(CarResources.class, "getAllProdCars")
				.path(Integer.toString(car.getIdCar())).build().toString();
		car.addLink(uri1, "self", "GET");
		String uri2 = uriInfo.getAbsolutePathBuilder().path("produce").build().toString();
		car.addLink(uri2, "To_produce", "POST");
		return carRepository.getCarToProduction(id);

	}

	@GET
	@Path("onDepot")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes("text/plain")
	public List<Car> getAllCars(@Context UriInfo uriInfo) {
		List<Car> cars = carDepot.getAllCars();
		for (Car car : cars) {
			String uri = uriInfo.getBaseUriBuilder().path(CarResources.class).path(CarResources.class, "getAllCars")
					.build().toString();
			car.addLink(uri, "self", "GET");
			String uri1 = uriInfo.getBaseUriBuilder().path(CarResources.class).path(CarResources.class, "getAllCars")
					.path(Integer.toString(car.getIdCar())).build().toString();
			car.addLink(uri1, "Car_depot", "GET");
			String uri2 = uriInfo.getBaseUriBuilder().path(CarResources.class).path(CarResources.class, "getAllCars")
					.path(Integer.toString(car.getIdCar())).path("order").build().toString();
			car.addLink(uri2, "To_order", "PUT");
		}
		return carDepot.getAllCars();
	}

	@GET
	@Path("/onDepot/{idCar}")
	@Consumes("text/plain,text/html")
	@Produces({ MediaType.APPLICATION_JSON })
	public Car getDepotCar(@PathParam("idCar") Integer id, @Context UriInfo uriInfo) {
		Car car = carDepot.getCarFromDepo(id);
		String uri = uriInfo.getAbsolutePathBuilder().toString();
		car.addLink(uri, "self", "GET");
		String uri1 = uriInfo.getAbsolutePathBuilder().path("order").toString();
		car.addLink(uri1, "order", "PUT");
		return carDepot.getCarFromDepo(id);
	}

	@PUT
	@Path("onDepot/{id}/order")
	@Consumes("text/plain,text/html")
	@Produces({ MediaType.APPLICATION_JSON })
	public Car order(@PathParam("id") int idCar, @Context UriInfo uriInfo) throws URISyntaxException {
		Car car = carDepot.orderCar(idCar);
		String uri = uriInfo.getAbsolutePathBuilder().toString();
		car.addLink(uri, "self", "PUT");
		return carDepot.orderCar(idCar);
	}

	@POST
	@Path("portfolio/{id}/produce")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes("text/plain,text/html")
	public Car produceNewCar(@PathParam("id") int id, @Context UriInfo uriInfo) {
		Car car = carRepository.getCarToProduction(id);
		String uri = uriInfo.getAbsolutePathBuilder().toString();
		car.addLink(uri, "self", "POST");
		carDepot.addToProduction(car);
		return carDepot.getCarFromDepo(id);
	}

}