package dev.jamiethomas.dashboard;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "$type", "timing" })
public class ArrivalPrediction {

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


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Integer getOperationType() {
    return operationType;
  }

  public void setOperationType(Integer operationType) {
    this.operationType = operationType;
  }

  public String getVehicleId() {
    return vehicleId;
  }

  public void setVehicleId(String vehicleId) {
    this.vehicleId = vehicleId;
  }

  public String getNaptanId() {
    return naptanId;
  }

  public void setNaptanId(String naptanId) {
    this.naptanId = naptanId;
  }

  public String getStationName() {
    return stationName;
  }

  public void setStationName(String stationName) {
    this.stationName = stationName;
  }

  public String getLineId() {
    return lineId;
  }

  public void setLineId(String lineId) {
    this.lineId = lineId;
  }

  public String getLineName() {
    return lineName;
  }

  public void setLineName(String lineName) {
    this.lineName = lineName;
  }

  public String getPlatformName() {
    return platformName;
  }

  public void setPlatformName(String platformName) {
    this.platformName = platformName;
  }

  public String getDirection() {
    return direction;
  }

  public void setDirection(String direction) {
    this.direction = direction;
  }

  public String getBearing() {
    return bearing;
  }

  public void setBearing(String bearing) {
    this.bearing = bearing;
  }

  public String getDestinationNaptanId() {
    return destinationNaptanId;
  }

  public void setDestinationNaptanId(String destinationNaptanId) {
    this.destinationNaptanId = destinationNaptanId;
  }

  public String getDestinationName() {
    return destinationName;
  }

  public void setDestinationName(String destinationName) {
    this.destinationName = destinationName;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(LocalDateTime timestamp) {
    this.timestamp = timestamp;
  }

  public Integer getTimeToStation() {
    return timeToStation;
  }

  public void setTimeToStation(Integer timeToStation) {
    this.timeToStation = timeToStation;
  }

  public String getCurrentLocation() {
    return currentLocation;
  }

  public void setCurrentLocation(String currentLocation) {
    this.currentLocation = currentLocation;
  }

  public String getTowards() {
    return towards;
  }

  public void setTowards(String towards) {
    this.towards = towards;
  }

  public LocalDateTime getExpectedArrival() {
    return expectedArrival;
  }

  public void setExpectedArrival(LocalDateTime expectedArrival) {
    this.expectedArrival = expectedArrival;
  }

  public LocalDateTime getTimeToLive() {
    return timeToLive;
  }

  public void setTimeToLive(LocalDateTime timeToLive) {
    this.timeToLive = timeToLive;
  }

  public String getModeName() {
    return modeName;
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
