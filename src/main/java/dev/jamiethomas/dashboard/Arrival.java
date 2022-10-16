package dev.jamiethomas.dashboard;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "$type", "timing" })
public class Arrival {

  /**
   * The identifier for the prediction
   */
  private String id;

  /**
   * The type of the operation (1: is new or has been updated, 2: should be
   * deleted from any client cache)
   */
  private Integer operationType;

  /**
   * The actual vehicle in transit (for train modes, the leading car of the
   * rolling set)
   */
  private String vehicleId;

  /**
   * Identifier for the prediction
   */
  private String naptanId;

  /**
   * Station name
   */
  private String stationName;

  /**
   * Unique identifier for the Line
   */
  private String lineId;

  /**
   * Line Name
   */
  private String lineName;

  /**
   * Platform name (for bus, this is the stop letter)
   */
  private String platformName;

  /**
   * Direction (unified to inbound/outbound)
   */
  private String direction;

  /**
   * Bearing (between 0 to 359)
   */
  private String bearing;

  /**
   * Naptan Identifier for the prediction's destination
   */
  private String destinationNaptanId;

  /**
   * Name of the destination
   */
  private String destinationName;

  /**
   * Timestamp for when the prediction was inserted/modified (source column drives
   * what objects are broadcast on each iteration)
   */
  private LocalDateTime timestamp;

  /**
   * Prediction of the Time to station in seconds
   */
  private Integer timeToStation;

  /**
   * The current location of the vehicle.
   */
  private String currentLocation;

  /**
   * Routing information or other descriptive text about the path of the vehicle
   * towards the destination
   */
  private String towards;

  /**
   * The expected arrival time of the vehicle at the stop/station
   */
  private LocalDateTime expectedArrival;

  /**
   * The expiry time for the prediction
   */
  private LocalDateTime timeToLive;

  /**
   * The mode name of the station/line the prediction relates to
   */
  private String modeName;


  public String getDestinationStation() {
    // Strip out unnecessary terms
    return destinationName.replace("Underground Station", "").replace("DLR Station", "");
  }

  public Integer getTimeToStation() {
    return timeToStation;
  }

  public String getMinutesToArrival() {
    StringBuilder builder = new StringBuilder();
    builder.append(timeToStation / 60);
    builder.append(" ");
    builder.append(timeToStation / 60 != 1 ? "mins" : "min");
    return builder.toString();
  }

  public String getLineId() {
    return lineId;
  }


  public void setId(String id) {
    this.id = id;
  }

  public void setOperationType(Integer operationType) {
    this.operationType = operationType;
  }

  public void setVehicleId(String vehicleId) {
    this.vehicleId = vehicleId;
  }

  public void setNaptanId(String naptanId) {
    this.naptanId = naptanId;
  }

  public void setStationName(String stationName) {
    this.stationName = stationName;
  }

  public void setLineId(String lineId) {
    this.lineId = lineId;
  }

  public void setLineName(String lineName) {
    this.lineName = lineName;
  }

  public void setPlatformName(String platformName) {
    this.platformName = platformName;
  }

  public void setDirection(String direction) {
    this.direction = direction;
  }

  public void setBearing(String bearing) {
    this.bearing = bearing;
  }

  public void setDestinationNaptanId(String destinationNaptanId) {
    this.destinationNaptanId = destinationNaptanId;
  }

  public void setDestinationName(String destinationName) {
    this.destinationName = destinationName;
  }

  public void setTimestamp(LocalDateTime timestamp) {
    this.timestamp = timestamp;
  }

  public void setTimeToStation(Integer timeToStation) {
    this.timeToStation = timeToStation;
  }

  public void setCurrentLocation(String currentLocation) {
    this.currentLocation = currentLocation;
  }

  public void setTowards(String towards) {
    this.towards = towards;
  }

  public void setExpectedArrival(LocalDateTime expectedArrival) {
    this.expectedArrival = expectedArrival;
  }

  public void setTimeToLive(LocalDateTime timeToLive) {
    this.timeToLive = timeToLive;
  }

  public void setModeName(String modeName) {
    this.modeName = modeName;
  }


  @Override
  public String toString() {
    return "ArrivalPrediction [id=" + id + ", operationType=" + operationType + ", vehicleId=" + vehicleId
        + ", naptanId=" + naptanId + ", stationName=" + stationName + ", lineId=" + lineId + ", lineName=" + lineName
        + ", platformName=" + platformName + ", direction=" + direction + ", bearing=" + bearing
        + ", destinationNaptanId=" + destinationNaptanId + ", destinationName=" + destinationName + ", timestamp="
        + timestamp + ", timeToStation=" + timeToStation + ", currentLocation=" + currentLocation + ", towards="
        + towards + ", expectedArrival=" + expectedArrival + ", timeToLive=" + timeToLive + ", modeName=" + modeName
        + "]";
  }

}
