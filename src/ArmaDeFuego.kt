import kotlin.random.Random

abstract class ArmaDeFuego(
    private val nombre:String,
    private var municion:Int,
    private val municionARestar: Int,
    private val tipoDeMunicion: String
) {

    abstract val danio: Int
    abstract val radio: TipoRadio
    companion object {
        var cantidadMunicionExtra: Int = Random.nextInt(5, 15)
    }

    fun dispara() {
        if (municion >= municionARestar) {
            municion -= municionARestar
            println("$nombre dispara. Munición restante: $municion.")
        } else if (cantidadMunicionExtra >= municionARestar) {
            recarga()
            dispara()
        } else {
            println("No hay suficiente munición para disparar.")
        }
    }

    fun recarga() {
        val municionARecargar = if (cantidadMunicionExtra >= 2 * municionARestar) 2 * municionARestar else if (cantidadMunicionExtra >= municionARestar) municionARestar else 0
        if (municionARecargar > 0) {
            municion += municionARecargar
            cantidadMunicionExtra -= municionARecargar
            println("$nombre se ha recargado. Munición actual: $municion.")
        } else {
            println("No hay suficiente munición extra para recargar.")
        }
    }

    fun mostrarInfo() {
        println("Nombre: $nombre, Munición: $municion, Tipo de Munición: $tipoDeMunicion, Daño: $danio, Radio: ${radio.desc}.")
    }
    override fun toString(): String {
        return "Nombre: $nombre, Munición: $municion, Tipo de Munición: $tipoDeMunicion, Daño: $danio, Radio: ${radio.desc}."
    }
}