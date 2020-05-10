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
    var _TiempoAcOn : Int = 10
    var _TiempoAcOff : Int = 5
    var _TempAc : Int = 23



    /* OperacionAdmin */
    def AgregarSalon(sal : Salon) : Unit = {
        _Salones = sal :: _Salones
    }

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
    def CambiarTiempoAcOff(time : Int) : Try[Unit] = {
        return Try {
            if(time < 60 && time > 0){
                this._TiempoAcOff = time
            }else{
                throw new Exception("Tiempo Invalido!")
            }
        }
    }

    def CambiarTiempoAcOn(time : Int) : Try[Unit] = {
        return Try {
            if(time < 60 && time > 0){
                this._TiempoAcOn = time
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
                    if(!salon.habilitado){
                        throw new Exception("El salon se encuentra Deshabilitado")
                    }

                    println("\nLOS DATOS DEL SALON SON: \n")

                    println("La temperatura del Salon es: " + salon.temperatura + " \n")
                    salon.MostrarReservas()
                    flag = false
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
            /*Sacamos la hora actual, para poder verificar que no se hagan reservas
                en una hora que ya pasó*/
            val now = Calendar.getInstance()
            val currentHour = now.get(Calendar.HOUR_OF_DAY)
            
            for(salon <- _Salones){
                if(salon.id == id){
                    if(!salon.habilitado){
                        throw new Exception("El salon se encuentra deshabilitado!")
                    }

                    if( res.horaInicio < 7 || res.horaInicio > 17){
                            throw new Exception("El horario es de 7 am a 7 pm")
                    }
                    if(res.horaInicio <= currentHour){
                            throw new Exception("Ya paso esa hora, no puedes reservar en el pasado!")
                    }


                    for(resclase <- salon._reservas){

                        if(res.horaInicio == resclase.horaInicio){
                            throw new Exception("No se encuentra disponible ese horario")
                        }else if(res.horaInicio > resclase.horaInicio && res.horaInicio < resclase.horaFinal){
                            throw new Exception("No se encuentra disponible ese horario")
                        }
                        
                    }

                    /* Si no hay error, se agrega la reserva */
                    salon.AgregarReserva(res)
                    flag = false

                }
            }
            if(flag){
                throw new Exception("No se encuentra esa Id de Salon...")
            }            

        }

    }


    def OpeSistema() : Unit = {

        println("\n||||Realizando silenciosamente operaciones del sistema |||||||\n")
        
        val now = Calendar.getInstance()
        val currentMinute = now.get(Calendar.MINUTE)
        val currentHour = now.get(Calendar.HOUR_OF_DAY)

        for(salon <- _Salones){
            
            for(res <- salon._reservas){

                /*Falta menos de una hora para la clase*/
                if(currentHour + 1 == res.horaInicio){
                    /*Abren los Salones*/
                    if(currentMinute == 60 - this._TiempoAbrir){
                        salon.abierto_(true)
                    }
                    /*Prende la luz en los Salones*/
                    if(currentMinute == 60 - this._TiempoLuzOn){
                        salon.luz_(true)
                    }
                    /*Prende el AC en los Salones*/
                    if(currentMinute == 60 - this._TiempoAcOn){
                        salon.ac_(true)
                    }

                }/* Ya finalizo la clase */
                else if(currentHour == res.horaFinal){

                    /*Apaga la luz en los Salones*/
                    if(currentMinute == this._TiempoLuzOff){
                        salon.luz_(false)
                    }
                    /*Apaga el AC en los Salones*/
                    if(currentMinute == this._TiempoAcOff){
                        salon.ac_(false)
                    }

                }

            }


        }

    }

}