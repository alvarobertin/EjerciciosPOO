package Edificio

import Reserva._
import Salon._
import Admin._
import scala.util._
import java.util.Calendar
import OperacionAdmin._
import OperacionUser._

class Edificio extends OperacionUser with OperacionAdmin{
    
    /*Atributos*/

    var _Salones : List[Salon] = List()
    var _Admin : Admin = _
    var _TiempoAbrir :  Int = 15
    var _TiempoLuzOn : Int = 5
    var _TiempoLuzOff : Int = 10
    var _TempAc : Int = 23



    /* OperacionAdmin */

    def Deshabilitar (id : String) : Try[Unit] = {
        return Try {
            var flag : Boolean = true
            for(salon <- _Salones){
                if(salon.id == id){
                    salon.habilitar()
                    flag = false
                }
            }
            if(flag){
                throw new Exception("No se encuentra esa Id de Salon")
            }
        }

    }
    def CambiarTempAc (temp : Int) : Try[Unit] = {
        return Try{

            if(temp < 30 && temp > 16){
                this._TempAc = temp
            }else{
                throw new Exception("Temperatura Invalida!")
            }
        }
    }

    def CambiarTiempoLuzOn(time : Int) : Try[Unit] = {
        return Try {
            if(time < 60 && time > 0){
                this._TiempoLuzOn = time
            }else{
                throw new Exception("Tiempo Invalido!")
            }
        }
    }

    def CambiarTiempoLuzOff(time : Int) : Try[Unit] = {
        return Try {
            if(time < 60 && time > 0){
                this._TiempoLuzOff = time
            }else{
                throw new Exception("Tiempo Invalido!")
            }
        }

    }
    def CambiarTiempoAbrir(time : Int) : Try[Unit] = {
        return Try {
            if(time < 60 && time > 0){
                this._TiempoAbrir = time
            }else{
                throw new Exception("Tiempo Invalido!")
            }
        }  
    }

    /* OperacionUser */

    def BuscarSalon(id : String) : Try[Unit] = {
        return Try{
            var flag : Boolean = true
            for(salon <- _Salones){
                if(salon.id == id){
                    println("\nLOS DATOS DEL SALON SON: \n")
                    println("La temperatura del Salon es: " + salon.temperatura + " \n")
                    salon.MostrarReservas()
                }
            }
            if(flag){
                throw new Exception("No se encuentra esa Id de Salon")
            }
        }
    }
    def ReservarSalon (id : String,  res : Reserva) : Try[Unit] = {
        return Try{
            var flag : Boolean = true
            for(salon <- _Salones){
                if(salon.id == id){
                    
                    for(resclase <- salon._reservas){

                        if(res.horaInicio == resclase.horaInicio){
                            throw new Exception("No se encuentra disponible ese horario")
                        }else if(res.horaInicio > resclase.horaInicio && res.horaInicio < resclase.horaFinal){
                            throw new Exception("No se encuentra disponible ese horario")
                        }
                        
                    }
                    /* Si no hay error, se agrega la reserva */
                    salon.AgregarReserva(res)

                }
            }
            if(flag){
                throw new Exception("No se encuentra esa Id de Salon")
            }            

        }

    }

}