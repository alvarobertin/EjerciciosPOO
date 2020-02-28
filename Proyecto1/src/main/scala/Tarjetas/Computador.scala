package Computador

class Computador{

    private var _estado : Boolean = false
    private var _almacenamiento : Double = 0
    private var _maxAlmacen : Double = 0
    private var _memoriaRAM : Double = 0
    private var _hilosProcesamiento : Double = 0
    private var _bateria : Double = 0

    //GETTERS
    def estado = _estado 
    def almacenamiento = _almacenamiento
    def memoriaRAM = _memoriaRAM
    def hilosProcesamiento = _hilosProcesamiento 
    def bateria = _bateria
    def maxAlmacen = _maxAlmacen

    //SETTERS

    def estado_ (entrada : Boolean) =  _estado = entrada
    def almacenamiento_ (entrada : Double) =  _almacenamiento = entrada
    def memoriaRAM_ (entrada : Double) =  _memoriaRAM = entrada
    def hilosProcesamiento_ (entrada : Double) =  _hilosProcesamiento = entrada
    def bateria_ (entrada : Double) =  _bateria = entrada
    def maxAlmacen_ (entrada : Double) =  _maxAlmacen = entrada



    def Prender() {

        if (!estado)
            estado_(true)
    
    }

    def Apagar() {

        if (estado)
            estado_(false)
    
    }

    def DescargarArchivo(tamanio : Int) {

        if(tamanio + almacenamiento <= maxAlmacen)
            almacenamiento_(tamanio + almacenamiento)

    }

    def EliminarArchivo(tamanio : Int) {

        if(almacenamiento - tamanio >= 0)
            almacenamiento_(almacenamiento - tamanio)

    }


    


}