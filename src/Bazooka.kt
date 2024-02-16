class Bazooka(
    municion:Int,
    tipoDeMunicion:String,
    danio:Int,
    radio: TipoRadio
):ArmaDeFuego("Bazooka", municion, 2, tipoDeMunicion) {

    override var danio: Int = danio
        set(value) {
            require(danio in 10..30) { "Error" }
            field = value
        }

    override var radio: TipoRadio = radio
        set(value) {
            require(radio == TipoRadio.INTERMEDIO || radio == TipoRadio.ENORME || radio == TipoRadio.AMPLIO)
            field = value
        }

    init {
        require(radio == TipoRadio.INTERMEDIO || radio == TipoRadio.ENORME || radio == TipoRadio.AMPLIO)
        require(danio in 10..30) { "Error" }
    }
}