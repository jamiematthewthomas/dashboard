package dev.jamiethomas.dashboard;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.commons.compress.utils.Lists;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {

  private static final long serialVersionUID = 1L;

  public MainView() {
    List<ArrivalPrediction> arrivalPredictions = getArrivalPredictions("jubilee", "940GZZLUCGT");



    add(new Text(arrivalPredictions.toString()));
  }


  private List<ArrivalPrediction> getArrivalPredictions(String line, String stopPoint) {
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
      List<ArrivalPrediction> arrivalPredictions = mapper.readValue(connection.getInputStream(), new TypeReference<List<ArrivalPrediction>>(){});

      // Disconnect
      connection.disconnect();
      return arrivalPredictions;

    } catch (Exception e) {
      System.out.print("Something went wrong! " + e.getMessage());
      return Lists.newArrayList();
    }
  }
}