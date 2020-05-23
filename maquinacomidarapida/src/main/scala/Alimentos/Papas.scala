package Alimentos
import Adicionales._
import Servicios.GeneradorReferencia

class Papas extends Alimento
{
    /*Atributos*/
    override var _tamano : TipoTamano = _
    override var _descripcion : String = _
    override var _referencia : String = GeneradorReferencia.crearReferencia()
    override var _costo : Double = _
    private var _conQueso : Boolean = false
    var _tieneSalsas : Boolean = false
    var _salsas : List[Salsa] = List()

    /*Cosntructores Auxiliares*/
    def this(t: TipoTamano, d : String, c : Double, queso : Boolean, tsalsas : Boolean, salsas : List[Salsa])
    {
        this()
        _tamano = t
        _descripcion = d
        _costo = c
        _conQueso = queso
        _tieneSalsas = tsalsas
        _salsas = salsas
    }

    /*Getter*/
    def conQueso = _conQueso

    /*Setter*/
    def conQueso_= (decisionUsuario : Boolean) = _conQueso = decisionUsuario

    /*Métodos*/
    def calcularCosto() : Double = 
    {
        if(_conQueso)
        {
            _costo = _costo + (_costo * 0.12)
        }
        return _costo   
    }
    def agregarSalsa(salsa : Salsa) : Unit = {
        _salsas = salsa :: _salsas
    }    
}