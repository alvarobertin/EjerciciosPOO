package Colegas
import IMediador._
class Helicoptero extends Colega {

    
    def this(c : IMediador)
    {
        this()
        Mediador = c
    }

   
    def AvisarRobo(direccion : String) : Unit = {
        this.Mediador.Send(direccion, this)
    }



}