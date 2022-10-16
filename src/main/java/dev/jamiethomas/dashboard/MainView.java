package dev.jamiethomas.dashboard;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.commons.compress.utils.Lists;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
@CssImport(
    themeFor = "vaadin-grid",
    value = "./arrival-grid.css"
)
public class MainView extends VerticalLayout {

  private static final long serialVersionUID = 1L;

  public MainView() {
    add(new H2("Dashboard"));
    add(new H3("Canning Town Departures"));

    List<Arrival> arrivalPredictions = Lists.newArrayList();
    arrivalPredictions.addAll(getArrivalPredictions("jubilee", "940GZZLUCGT"));
    arrivalPredictions.addAll(getArrivalPredictions("dlr", "940GZZDLCGT"));
    arrivalPredictions.sort((a,b) -> a.getTimeToStation().compareTo(b.getTimeToStation()));

    Grid<Arrival> grid = new Grid<>(Arrival.class, false);
    grid.addColumn(Arrival::getDestinationStation).setHeader("Destination");
    grid.addColumn(Arrival::getMinutesToArrival).setHeader("Arriving in");
    grid.setItems(arrivalPredictions);
    grid.setClassNameGenerator(Arrival::getLineId);
    add(grid);
  }


  private List<Arrival> getArrivalPredictions(String line, String stopPoint) {
    try {
      // URL
      URL url = new URL("https://api.tfl.gov.uk/Line/" + line + "/Arrivals/" + stopPoint);
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();

      // Headers
      connection.setRequestProperty("Cache-Control", "no-cache");
      connection.setRequestMethod("GET");

      // Call and map
      ObjectMapper mapper = new ObjectMapper();
      mapper.findAndRegisterModules();
      List<Arrival> arrivalPredictions = mapper.readValue(connection.getInputStream(), new TypeReference<List<Arrival>>(){});

      // Disconnect
      connection.disconnect();
      return arrivalPredictions;

    } catch (Exception e) {
      System.out.print("Something went wrong! " + e.getMessage());
      return Lists.newArrayList();
    }
  }
}