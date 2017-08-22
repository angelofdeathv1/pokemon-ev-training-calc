package mx.cetys.aarambula.android.pokemonevtrainingcalc.model

/**
 * Created by AngelArambula on 8/21/17.
 */

class EVElementsTable {
    private var bPokerus: Boolean = false
    private var bSOS: Boolean = false
    private var bPowerItem: Boolean = false

    constructor(bPokerus: Boolean, bSOS: Boolean, bPowerItem: Boolean) {
        this.bPokerus = bPokerus
        this.bSOS = bSOS
        this.bPowerItem = bPowerItem
    }

    fun isbPokerus(): Boolean {
        return bPokerus
    }

    fun isbPowerItem(): Boolean {
        return bPowerItem
    }

    fun isbSOS(): Boolean {
        return bSOS
    }

    fun setbPokerus(bPokerus: Boolean) {
        this.bPokerus = bPokerus
    }

    fun setbPowerItem(bPowerItem: Boolean) {
        this.bPowerItem = bPowerItem
    }

    fun setbSOS(bSOS: Boolean) {
        this.bSOS = bSOS
    }

    override fun toString(): String {
        return "Pokerus:$bPokerus SOS:$bSOS Power Item:$bPowerItem"
    }
}
