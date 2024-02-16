class Rifle(
    municion:Int,
    tipoDeMunicion:String,
    danio:Int,
    radio: TipoRadio
):ArmaDeFuego("Rifle", municion, 2, tipoDeMunicion) {

    override var danio: Int = danio
        set(value) {
            require(danio in 5..10) { "Error" }
            field = value
        }

    override var radio: TipoRadio = radio
        set(value) {
            require(radio == TipoRadio.INTERMEDIO || radio == TipoRadio.CORTO)
            field = value
        }
    init {
        require(radio == TipoRadio.INTERMEDIO || radio == TipoRadio.CORTO)
        require(danio in 5..10) { "Error" }
    }
}