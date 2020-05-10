package Admin
import scala.util._
class Admin{

    /* Atributos */

    private var _pass : String = _

    def this(pass : String) = {
		this();
        _pass = pass
	}

    def pass = _pass 

    def LogIn(p : String) : Boolean = {
        if(pass == p){
            return true
        }
        else{
            return false
        }
    }
}