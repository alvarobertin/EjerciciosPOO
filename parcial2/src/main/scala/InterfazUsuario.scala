package InterfazUsuario

import Edificio._
import Admin._
import scala.io._

import java.util.Calendar

object InterfazUsuario extends App {

    var Edifi : Edificio = new Edificio


     /* Minutes */
    val now = Calendar.getInstance()
    val currentMinute = now.get(Calendar.MINUTE)




    println("===================================Bienvenido===================================")

        println("Cree una contrasena de admin: \n")
        var pass : String = StdIn.readLine()
        var ad : Admin = new Admin(pass)
        Edifi._Admin = ad


    while(true){

        println("Seleccione el menu que desea: \n 1) admin \n 2) user \n")
        var op : Int = StdIn.readInt()
        
        if(op == 1){
            println("Ingrese Contrasena de Admin: \n")
            var p : String = StdIn.readLine()

            if(Edifi._Admin.LogIn(p)){

                var a : Int = 0
                while(a == 0){
                    println("Seleccione lo que desea hacer: \n")
                    println("1) Desahibilitar un Salon \n")
                    println("2) Cambiar los minutos antes para Luz On\n")
                    println("3) Cambiar los minutos despues para Luz Off\n")
                    println("4) Cambiar los minutos antes para Abrir Salones\n")
                    println("5) Cambiar la temperatura adecuada\n")
                    println("6) Salir \n")

                    p = StdIn.readInt()

                    if(p == 1){

                    }else if(p == 2){

                    }else if(p == 3){
                        
                    }else if(p == 4){
                        
                    }else if(p == 5){
                        
                    }else if(p == 6){
                        a = 1
                    }



                }
           
           
            }


        }else if(op == 2){




        }


    }

}