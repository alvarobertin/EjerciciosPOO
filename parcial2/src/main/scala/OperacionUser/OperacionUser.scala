package OperacionUser

import scala.util._
import Reserva._

trait OperacionUser{

    def BuscarSalon(id : String) : Try[Unit]
    def ReservarSalon (id : String,  res : Reserva) : Try[Unit]

}