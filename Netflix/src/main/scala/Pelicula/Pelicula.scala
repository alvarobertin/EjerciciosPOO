package Pelicula

class Pelicula{
    var _titulo : String = _
    var _genero : String =_
    var _codigo : String =_
    var _duracion : Double = _
    protected var _reproducciones : Int = 0

    def getRepro_()={
        _reproducciones
    }
    
    def GetTitulo_()={
        _titulo
    }

    def aumentarRepro() = _reproducciones += 1

	def this(titulo : String, genero : String, duracion : Double, codigo : String) = {
		this();
		_titulo = titulo;
		_genero = genero;
		_duracion = duracion;
		_codigo = codigo;
		_reproducciones = 0;
	}


}


