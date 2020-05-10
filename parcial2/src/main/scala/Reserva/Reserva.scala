package Reserva

class Reserva { 

    /*LAS RESERVAS SON DE DOS HORAS*/
    
    var _id : String = _
    var _horaInicio : Int = _
    var _horaFinal : Int = _
    var _descripcion : String = _

    /* Getters */

    def id = _id
    def horaInicio = _horaInicio
    def horaFinal = _horaFinal
    def descripcion = _descripcion

    /* Setters */

    def id_ (entrada : String) =  _id = entrada
    def horaInicio_ (entrada : Int) =  _horaInicio = entrada
    def horaFinal_ (entrada : Int) =  _horaFinal = entrada
    def descripcion_ (entrada : String) =  _descripcion = entrada


}