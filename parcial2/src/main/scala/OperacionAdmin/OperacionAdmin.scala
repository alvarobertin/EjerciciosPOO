package OperacionAdmin
import scala.util._
import Salon._
trait OperacionAdmin {

    def AgregarSalon(sal : Salon) : Unit
    def Deshabilitar (id : String) : Try[Unit]
    def CambiarTiempoLuzOn(time : Int) : Try[Unit]
    def CambiarTiempoLuzOff(time : Int) : Try[Unit]
    def CambiarTiempoAbrir(time : Int) : Try[Unit]
    def CambiarTiempoAcOff(time : Int) : Try[Unit]
    def CambiarTiempoAcOn(time : Int) : Try[Unit]
    def CambiarTempAc(temp : Int) : Try[Unit]

}