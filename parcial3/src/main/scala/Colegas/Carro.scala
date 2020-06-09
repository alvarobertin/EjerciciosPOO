package Colegas
import IMediador._
class Carro extends Colega {
    
    def this(c : IMediador)
    {
        this()
        Mediador = c
    }

    override def HandleEvent (evento : String) : Unit = {
        println("Carro va en camino a: " + evento)
    }

    def AvisarRobo(direccion : String) : Unit = {
        this.Mediador.Send(direccion, this)
    }



}