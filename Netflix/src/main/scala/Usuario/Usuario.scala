package Usuario
import Pelicula._
import Plan._
import ModuloSistema._


class Usuario{

    var _nombre : String  = _
    var _cedula : String = _
    var _contra : String = _
    var _edad : String = _
    var _correo : String = _
    var _esAdmin : Boolean = _
    
    /*private*/ var _peliculasDesc : List[Pelicula] =_
    private var _planActual : Plan = _
    var _estadoUsuario : String = "activo"
    private var _mesesMora : Int =_

    def GetPelisDescargadas_()= {
        _peliculasDesc
    }
    

    def this (nombreNuevo : String, cedulaNueva : String,
		contraNueva : String, edadNueva : String, correoNuevo : String, esadmin : Boolean) = {
		this();
		_nombre = nombreNuevo;
		_cedula = cedulaNueva;
		_contra = contraNueva;
		_edad = edadNueva;
		_correo = correoNuevo;
        _esAdmin = esadmin;

	}

    def SetEstado_(n:Int)={
        if(n == 1) _estadoUsuario = "activo"
        if(n == 0) _estadoUsuario = "inactivo"

    }

    def VerEstado() : Boolean ={
        if (_estadoUsuario == "Activo") true
        else false
    }

    def sinMora() = {
        _mesesMora = 0

    }

    def PagarFactura() = {
        sinMora()
        SetEstado_(1)
    }

    def anexPelicula(pelicula : Pelicula)={
       _peliculasDesc = pelicula :: _peliculasDesc
    }

    def DescargarPelicula(pel:Pelicula) = {
       if(_esAdmin == false){
           if(VerEstado()==true){
               anexPelicula(pel)
            }
       }
    }

    def esContra(con:String):Boolean={
        if(con == _contra) true
        else false
    }

    def ComparPlan(plan:Plan)={
        _planActual = plan
    }

    def verPelicula(pelicula:Pelicula)={
        if(_esAdmin == false){
            pelicula.aumentarRepro()
        }
    }

}