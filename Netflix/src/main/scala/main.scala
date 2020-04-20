import ModuloSistema._

object main extends App{

    var sis = new ModuloSistema();
    
    sis.RegistrarUsuario("S", "123", "123", "12", "@", true)

    println(sis.LogUsuario("@", "123"));

}