package IMediador
import Colegas._

class CentroComando extends IMediador {

    var Unidades : List[Colega] = List()

    def addUnidad (c : Colega) : Unit = {
        Unidades = c :: Unidades
    }

    def Send(mensaje : String, sender : Colega) : Unit = {

        for (c <- this.Unidades){
            if(c != sender){
                c.HandleEvent(mensaje)
            }
        }
    }
}