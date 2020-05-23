package Alimentos

import Servicios.GeneradorReferencia

class Bebida extends Alimento with IBebida
{
    /*Atributos*/
    override var _tamano : TipoTamano = _
    override var _descripcion : String = _
    override var _referencia : String = GeneradorReferencia.crearReferencia()
    override var _costo : Double = _
    var _conHielo : Boolean = false

    /*Cosntructores Auxiliares*/
    def this(t: TipoTamano, d : String, c : Double)
    {
        this()
        _tamano = t
        _descripcion = d
        _costo = c
    }

    /*Getter*/
    def conHielo = _conHielo

    /*Setter*/
    def conHielo_= (decisionUsuario : Boolean) = _conHielo = decisionUsuario

    /*Métodos*/
    def calcularCosto() : Double = 
    {
        return _costo
    }
}