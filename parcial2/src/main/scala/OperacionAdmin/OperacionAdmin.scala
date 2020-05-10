package OperacionAdmin
import scala.util._
trait OperacionAdmin {

    def Deshabilitar (id : String) : Try[Unit]
    def CambiarTiempoLuzOn(time : Int) : Try[Unit]
    def CambiarTiempoLuzOff(time : Int) : Try[Unit]
    def CambiarTiempoAbrir(time : Int) : Try[Unit]
    def CambiarTempAc(temp : Int) : Try[Unit]

}