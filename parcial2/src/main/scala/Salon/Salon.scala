package Salon
import Reserva._

import scala.util.Random

class Salon{

    /* Constructor solo con temperatura porque el resto no importa*/

    def this(temp : Int) = {
		this();
        _temperatura = temp
    }

    var _id : String = this.generarId()
    var _luz : Boolean = false
    var _temperatura : Int = _
    var _reservas : List[Reserva] = List()
    var _habilitado : Boolean = true
    var _abierto : Boolean = false
    var _ac : Boolean = false

    /* Getters */

    def id = _id

    def luz = _luz
    def temperatura = _temperatura
    def reservas = _reservas
    def habilitado = _habilitado
    def abierto = _abierto
    def ac = _ac

    /* Setters */

    def luz_ (entrada : Boolean) =  _luz = entrada
    def temperatura_ (entrada : Int) =  _temperatura = entrada
    
    def habilitar () : Unit = {
        if (habilitado == true){
            this._habilitado = false 
        }else{
            this._habilitado = true
        }

    } 



    def abierto_ (entrada : Boolean) =  _abierto = entrada
    def ac_ (entrada : Boolean) =  _ac = entrada

    def AgregarReserva(res : Reserva) : Unit = {
        _reservas = res :: _reservas
    }

    private def generarId() : String = {
        var codigo : String = Random.alphanumeric.take(7).mkString("")
        return codigo
    }

    def MostrarReservas() : Unit = {
        println("LAS RESERVAS SON: \n")
        for(res <- _reservas){
    
            println("|| ID reserva = "+ res.id + " || Descripcion = " + res.descripcion + "|| Franja: " + 
                  res.horaInicio + " a " + res.horaFinal + "||\n")
        
        }
    }


}