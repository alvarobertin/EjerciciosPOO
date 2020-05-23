package Alimentos
import Adicionales._

import Servicios.GeneradorReferencia

class Hamburguesa extends Alimento with ISalsas
{
    /*Atributos*/
    override var _tamano : TipoTamano = _
    override var _descripcion : String = _
    override var _referencia : String = GeneradorReferencia.crearReferencia()
    private var _esAgrandable : Boolean = false
    override var _costo : Double = _
    var _tieneSalsas : Boolean = false
    var _salsas : List[Salsa] = List()

    /*Cosntructores Auxiliares*/
    def this(t: TipoTamano, d : String, c : Double, tsalsas : Boolean, salsas : List[Salsa])
    {
        this()
        _tamano = t
        _descripcion = d
        _costo = c
        _tieneSalsas = tsalsas
        _salsas = salsas
    }

    /*Getter*/
    def esAgrandable = _esAgrandable

    /*Setter*/
    def esAgrandable_= (decisionUsuario : Boolean) = _esAgrandable = decisionUsuario

    /*Métodos*/
    def calcularCosto() : Double = 
    {
        if(_esAgrandable)
        {
            _costo = _costo + (_costo * 0.2)
        }
        return _costo     
    }

    def agregarSalsa(salsa : Salsa) : Unit = {
        _salsas = salsa :: _salsas
    }
}