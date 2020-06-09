package Colegas
import IMediador._
class Tanque extends Colega {

    
    def this(c : IMediador)
    {
        this()
        Mediador = c
    }

    override def HandleEvent (evento : String) : Unit = {
        println("Tanque va en camino a: " + evento)
    }

    def AvisarRobo(direccion : String) : Unit = {
        this.Mediador.Send(direccion, this)
    }



}