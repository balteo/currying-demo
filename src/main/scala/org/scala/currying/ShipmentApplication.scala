package org.scala.currying

trait ShipmentStrategy {
  def calculateShipmentCost(weight: Double): Double
}

class AirMailShipmentStrategy extends ShipmentStrategy {
  def calculateShipmentCost(weight: Double): Double = weight * 10 + 25
}

class SeaLandMailShipmentStrategy extends ShipmentStrategy {
  def calculateShipmentCost(weight: Double): Double = weight * 5
}

object ShipmentApplication {

  private[this] val shipmentCost: (ShipmentStrategy, Double) => Double = (s, w) => s.calculateShipmentCost(w)

  val airMailShipmentCost = shipmentCost.curried(new AirMailShipmentStrategy)
  val seaLandMailShipmentCost = shipmentCost.curried(new SeaLandMailShipmentStrategy)

}

object Run extends App {
 
  import org.scala.currying.ShipmentApplication._  

  println(airMailShipmentCost(50))
  println(seaLandMailShipmentCost(50))
}