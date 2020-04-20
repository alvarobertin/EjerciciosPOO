package ModuloSistema
import Usuario._
import Pelicula._

class ModuloSistema{

	//Atributos
	private var _usuarios : List[Usuario] = List()
	private var _peliculas : List[Pelicula] = List()

	//Getters
	def usuarios = _usuarios;
	def peliculas = _peliculas;

	//Setters
	def usuarios_ (usuarios : List[Usuario]) = _usuarios = usuarios;
	def peliculas_ (peliculas : List[Pelicula]) = _peliculas = peliculas;

	//Metodos
	//+ RegistrarUsuario() : Unit
	//+ LogUsuario( Correo : string, Contraseña : string) : Boolean

	def RegistrarUsuario (Nombre: String, Cedula: String, Contra : String, Edad : String, 
						  Correo : String, EsAdmin : Boolean) : Unit = {

		var User = new Usuario(Nombre, Cedula, Contra, Edad, 
						  Correo, EsAdmin)

		if(_usuarios.isEmpty)
			_usuarios = List(User);
		else
			_usuarios = User :: _usuarios;

	}

	def LogUsuario ( Correo : String, Contra : String) : Boolean = {
		for(u <- usuarios){
			if( u._correo  == Correo){
				if(u.esContra(Contra)){
					return true
				}
			}
		}
		return false
	}

	//Admin

	def GenerarReporte(EsAdmin : Boolean) : List[Pelicula] = {
		def sortByRe(a : Pelicula, b : Pelicula) : Boolean = {
			return a.getRepro_() > b.getRepro_();
		}

		var aux : List[Pelicula] = _peliculas.sortWith(sortByRe);

		var reporte : List[Pelicula] = List(aux(aux.length - 2));
		reporte = (aux(aux.length - 1)) :: reporte;
		reporte = aux(1) :: reporte;
		reporte = aux(0) :: reporte;

		return reporte;
	}

	def CrearPelicula(EsAdmin : Boolean, Titulo : String, Genero : String, 
					 Duracion_Min : Double, Codigo : String) : Boolean = {
		if(EsAdmin == true){
			var peli : Pelicula = new Pelicula(Titulo, Genero, Duracion_Min, Codigo);
			if(_peliculas.isEmpty)
				_peliculas = List(peli);
			else
				_peliculas = peli :: _peliculas

			return true
		}
			
		return false
	}

	def EliminarPelicula(EsAdmin : Boolean, Titulo : String): Boolean = {
		if(EsAdmin){
			var aux : List[Pelicula] = List();
			for(peli <- _peliculas){
				if(peli._titulo != Titulo)
					aux = peli :: aux;
			}
			_peliculas = aux;

			return true;
		}
		return false;
	}

	def EliminarUsuario(EsAdmin : Boolean, Cedula : String) : Boolean = {
		if(EsAdmin == true){
			var aux : List[Usuario] = List();

			for(user <- _usuarios){
				if(user._cedula != Cedula)
					aux = user :: aux;
			}
			_usuarios = aux;

			return true;
		}

		return false;
	}

	def InhabilitarUsuario(EsAdmin : Boolean, Cedula : String) : Boolean = {
		if(EsAdmin == true){
			for(user <- _usuarios){
				if(user._cedula == Cedula){
					user.SetEstado_(0);
				}
			}

			return true;
		}

		return false;
	}

}