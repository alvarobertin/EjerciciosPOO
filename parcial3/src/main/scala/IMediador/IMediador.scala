package IMediador
import Colegas._

trait IMediador {

    def Send(mensaje : String, Sender : Colega) : Unit

}