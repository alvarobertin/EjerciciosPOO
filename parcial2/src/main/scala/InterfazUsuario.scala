package InterfazUsuario

import Edificio._
import Salon._
import Admin._
import Reserva._
import scala.io._
import scala.util._

import java.util.Calendar

object InterfazUsuario extends App {

    var Edifi : Edificio = new Edificio


     /* Minutes */
    val now = Calendar.getInstance()
    val currentMinute = now.get(Calendar.MINUTE)


    println("===================================Bienvenido===================================")

        println("Cree una contrasena de admin: ")
        var pass : String = StdIn.readLine()
        var ad : Admin = new Admin(pass)
        Edifi._Admin = ad

    var opc : Int = 0

    while(opc != 3){

        /* Ejecutar las operaciones del sistema */
        Edifi.OpeSistema()

        println("Seleccione el menu que desea: \n 1) admin \n 2) user \n 3) Salir")
        opc = StdIn.readInt()
        
        if(opc == 1){
            println("Ingrese Contrasena de Admin: ")
            var z : String = StdIn.readLine()

            if(Edifi._Admin.LogIn(z)){

                var a : Int = 0
                while(a == 0){
                    /* Ejecutar las operaciones del sistema */
                    Edifi.OpeSistema()


                    println("=====================================Menu Admin=============================")
                    println("Seleccione lo que desea hacer: ")
                    println("0) Crear un Salon ")
                    println("1) Desahibilitar un Salon ")
                    println("2) Cambiar los minutos antes para Luz On")
                    println("3) Cambiar los minutos despues para Luz Off")
                    println("4) Cambiar los minutos antes para Abrir Salones")
                    println("5) Cambiar los minutos antes para prender el AC en los salones")
                    println("6) Cambiar los minutos despues para apagar el AC en los salones")
                    println("7) Cambiar la temperatura adecuada")
                    println("8) Salir ")
                    println("==================================================================")

                    var p : Int = StdIn.readInt()

                    if(p == 0){

                        var sal : Salon = new Salon(Edifi._TempAc)
                        Edifi.AgregarSalon(sal)

                        println("Salon: " + sal.id )


                    }else if(p == 1){
                        println("Para Deshabilitar, ingrese id de salon: ")
                        var i : String = StdIn.readLine()

                        var prueba = Edifi.Deshabilitar(i)
                        prueba match{
                            case Success(s) => println("\nSalon corrrectamente desahiblitado\n")
                            case Failure(f) => println(f)
                        }


                    }else if(p == 2){
                        println("Ingrese el numero de minutos antes para que se encienda la luz de los salones: ")
                        p = StdIn.readInt()
                        var p2 = Edifi.CambiarTiempoLuzOn(p)

                        p2 match{
                            case Success(s) => println("Cambiado Correctamente ")
                            case Failure(f) => println(f)
                        }
                        
                    }else if(p == 3){
                        println("Ingrese el numero de minutos despues para que se apague la luz de los salones: ")
                        p = StdIn.readInt()
                        var p2 = Edifi.CambiarTiempoLuzOff(p)

                        p2 match{
                            case Success(s) => println("Cambiado Correctamente ")
                            case Failure(f) => println(f)
                        }                        
                    }else if(p == 4){
                        println("Ingrese el numero de minutos antes para que se abran los salones: ")
                        p = StdIn.readInt()
                        var p2 = Edifi.CambiarTiempoAbrir(p)

                        p2 match{
                            case Success(s) => println("Cambiado Correctamente ")
                            case Failure(f) => println(f)
                        }      

                    }else if(p == 5){
                        println("Ingrese el numero de minutos antes para que se prenda el AC en los salones ")
                        p = StdIn.readInt()
                        var p2 = Edifi.CambiarTiempoAcOff(p)

                        p2 match{
                            case Success(s) => println("Cambiado Correctamente ")
                            case Failure(f) => println(f)
                        }      

                    }else if(p == 6){
                        println("Ingrese el numero de minutos antes para que se prenda el AC en los salones ")
                        p = StdIn.readInt()
                        var p2 = Edifi.CambiarTiempoAcOn(p)

                        p2 match{
                            case Success(s) => println("Cambiado Correctamente ")
                            case Failure(f) => println(f)
                        }      

                    }else if(p == 7){
                        println("Ingrese la nueva temperatura adecuada: ")
                        p = StdIn.readInt()
                        var p2 = Edifi.CambiarTempAc(p)

                        p2 match{
                            case Success(s) => println("Cambiado Correctamente ")
                            case Failure(f) => println(f)
                        }

                    }else if(p == 8){
                        a = 1
                    }


                }
           
           
            }else{
                println("Contrasena incorrecta! ")
            }


        }else if(opc == 2){
            var a : Int = 0
            while(a == 0){

                /* Ejecutar las operaciones del sistema */
                    Edifi.OpeSistema()
                
                println("================================Menu User==================================")
                println("Seleccione lo que desea hacer: ")
                println("1) Reservar un Salon ")
                println("2) Buscar un Salon ")
                println("3) Salir ")
                println("==================================================================")

                var op : Int = StdIn.readInt()

                if(op == 1){
                    println("Ingrese el id del salon que desea reservar: ")
                    var sal : String = StdIn.readLine()
                    
                    var test = Edifi.BuscarSalon(sal)
                    var flag : Boolean = false

                    test match{
                        case Success(s) => flag = true
                        case Failure(f) => println(f)
                    }

                    if(flag){
         
                        println("Ingrese una descripcion para la reserva: ")
                        var des : String = StdIn.readLine()

                        println("Ahora seleccione una hora a la que desea reservar (los bloques son de 2 horas): ")
                        var hora : Int = StdIn.readInt()

                        var res : Reserva = new Reserva(hora, hora + 2, des)

                        var test1 = Edifi.ReservarSalon(sal, res)
                        
                        test1 match{
                            case Success(s) => println("\nReserva realizada correctamente")
                            case Failure(f) => println(f)
                        }
                    }




                }else if(op == 2){
                    println("Ingrese el id del salon que desea buscar: ")
                    var sal : String = StdIn.readLine()
                    
                    var test = Edifi.BuscarSalon(sal)

                    test match{
                        case Success(s) => println("Encontrado!")
                        case Failure(f) => println(f)
                    }                    

                }else if(op == 3){
                    a = 1
                }

            }

        }

    }

}