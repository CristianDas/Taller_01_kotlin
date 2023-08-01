package  cristian
import java.util.*

class Retonequi {
    private val numeroCelularCorrecto = "3147888196"
    private val pinCorrecto = "1234"
    private var saldoDisponible = 100.0

    fun ejecutar() {
        var intentos = 3

        while (intentos > 0) {

            println("Ingresa tu número de celular:")
            val numeroCelularInput = readLine()
            println("Ingresa tu clave de 4 dígitos:")
            val pinInput = readLine()

            if (numeroCelularInput == numeroCelularCorrecto && pinInput == pinCorrecto) {
                println("¡Acceso permitido!")
                mostrarSaldo()

                while (true) {
                    mostrarMenu()
                    val opcion = readLine()

                    when (opcion) {
                        "1" -> sacarDinero()
                        "2" -> enviarDinero()
                        "3" -> recargarSaldo()
                        "4" -> break
                        else -> println("Opción no válida, intenta de nuevo.")
                    }
                }
                break
            } else {
                intentos--
                println("¡Upps! Parece que tus datos de acceso no son correctos. Tienes $intentos intentos más.")
            }
        }

        if (intentos == 0) {
            println("Has agotado tus intentos. La sesión ha sido bloqueada.")
        }
    }

    private fun mostrarMenu() {
        println("\n--- Menú ---")
        println("1. Sacar dinero")
        println("2. Enviar dinero")
        println("3. Recargar saldo")
        println("4. Salir")
        println("Elige una opción:")
    }

    private fun mostrarSaldo() {
        println("Saldo disponible: $saldoDisponible")
    }

    private fun sacarDinero() {
        if (saldoDisponible < 2000) {
            println("No te alcanza para hacer el retiro.")
        } else {
            println("¿Cuánto deseas retirar?")
            val cantidadARetirar = readLine()?.toDoubleOrNull()

            if (cantidadARetirar != null && cantidadARetirar <= saldoDisponible) {
                saldoDisponible -= cantidadARetirar
                println("Retiro exitoso. Código de 6 dígitos generado para el retiro.")
            } else {
                println("Monto inválido o insuficiente. Inténtalo de nuevo.")
            }
        }
    }

    private fun enviarDinero() {
        println("Ingresa el número de teléfono al que deseas enviar dinero:")
        val numeroTelefono = readLine()
        println("Ingresa el valor a enviar:")
        val cantidadAEnviar = readLine()?.toDoubleOrNull()

        if (cantidadAEnviar != null && cantidadAEnviar <= saldoDisponible) {
            saldoDisponible -= cantidadAEnviar
            println("Envío exitoso.")
        } else {
            println("Monto inválido no tienes suficientes fondos.intenta de nuevo")
        }
    }

    private fun recargarSaldo() {
        println("Ingresa el valor a recargar:")
        val valorRecarga = readLine()?.toDoubleOrNull()

        if (valorRecarga != null) {
            println("¿Deseas confirmar la recarga? (Sí/No)")
            val confirmacion = readLine()

            if (confirmacion?.toLowerCase(Locale.ROOT) == "sí") {
                saldoDisponible += valorRecarga
                println("Recarga exitosa. Saldo actual: $saldoDisponible")
            } else {
                println("Recarga cancelada.")
            }
        } else {
            println("Valor inválido")
        }
    }
}

fun main() {
    val nequi = Retonequi()
    nequi.ejecutar()
}
