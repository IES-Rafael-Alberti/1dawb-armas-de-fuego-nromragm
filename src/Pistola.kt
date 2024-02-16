class Pistola(
    municion:Int,
    tipoDeMunicion:String,
    danio:Int,
    radio: TipoRadio
):ArmaDeFuego("Pistola", municion, 1, tipoDeMunicion) {

    override var danio: Int = danio
        set(value) {
            require(danio in 1..5) { "Error" }
            field = value
        }

    override var radio: TipoRadio = radio
        set(value) {
            require(radio == TipoRadio.REDUCIDO || radio == TipoRadio.CORTO)
            field = value
        }
    init {
        require(radio == TipoRadio.REDUCIDO || radio == TipoRadio.CORTO)
        require(danio in 1..5) { "Error" }
    }
}