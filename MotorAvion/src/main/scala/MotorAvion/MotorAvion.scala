package MotorAvion

class MotorAvion{

    private var _estado : Boolean = false
    private var _Gasolina : Double = 0
    private var _maxGasolina : Double = 100
    private var _temperatura : Double = 0
    private var _maxTemperatura : Double = 100

    //GETTERS
    def estado = _estado 
    def Gasolina = _Gasolina
    def maxGasolina = _maxGasolina
    def temperatura = _temperatura
    def maxTemperatura = _maxTemperatura

    //SETTERS

    def estado_ (entrada : Boolean) =  _estado = entrada
    def Gasolina_ (entrada : Double) =  _Gasolina = entrada
    def maxGasolina_ (entrada : Double) =  _maxGasolina = entrada
    def temperatura_ (entrada : Double) = _temperatura = entrada
    def maxTemperatura_ (entrada : Double) = _maxTemperatura = entrada

    def Prender() {

        if (!estado)
            estado_(true)
        Gasolina_(50)
        temperatura_(40)
    
    }

    def Apagar() {

        if (estado)
            estado_(false)
    
    }

    def LlenarTanque(tamanio : Int) {

        if(tamanio + Gasolina <= maxGasolina)
            Gasolina_(tamanio + Gasolina)

    }

    def Acelerar() {

        if(Gasolina - 5 >= 0 && temperatura + 10 <= maxTemperatura){
            Gasolina_(Gasolina - 5)
            temperatura_(temperatura + 10)
        }

    }

    
    def DesAcelerar() {
        if(temperatura - 10 >= 40)
            temperatura_(temperatura - 10)

    }

}