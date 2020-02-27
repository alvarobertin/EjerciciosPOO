package Tarjetas

class TarjetaCredito{

    private var _clave : Int = 1234
    private var _saldo : Double = 50000

    def clave = _clave // Getter

    def clave_ (nuevaClave : Int) =  _clave = nuevaClave

    def verificarClave(nuevaClave : Int) : Boolean = {

        var resultado : Boolean = false

        if (nuevaClave == _clave){
            resultado = true
        }
        
        return resultado
    }





}