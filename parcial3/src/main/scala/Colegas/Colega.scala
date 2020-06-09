package Colegas
import IMediador._

abstract class Colega {

    def this(c : IMediador)
    {
        this()
        Mediador = c
    }

    var Mediador : IMediador = _

    def HandleEvent (evento : String) : Unit

}