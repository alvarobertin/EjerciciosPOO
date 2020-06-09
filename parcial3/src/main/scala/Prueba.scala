import IMediador._
import Colegas._


object Prueba extends App
{

    var centroComando : CentroComando = new CentroComando() 

    var tanque : Tanque = new Tanque(centroComando)
    var carro : Carro = new Carro(centroComando)
    var heli : Helicoptero = new Helicoptero(centroComando)

    centroComando.addUnidad(tanque)
    centroComando.addUnidad(carro)
    centroComando.addUnidad(heli)

    println("############################################################################# \n")
    
    
    carro.AvisarRobo("Calle 30 #20 - 40 Barrio Rojo, Sujetos Disparando")
    
    
    println("\n############################################################################# \n")

}