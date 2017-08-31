package mx.cetys.aarambula.android.pokemonevtrainingcalc.model

/**
 * Created by aarambula on 8/22/2017.
 */
class PokemonBattleRow {
    private var oEVElement: EVElementsTable = EVElementsTable()
    private var sLabel: String = ""
    private var nEVYield: Int = 0
    private var nBaseEV: Int = 0

    constructor()

    constructor(sLabel: String, nBaseEV: Int, nEVYield: Int, oEVElement: EVElementsTable) {
        this.nEVYield = nEVYield
        this.nBaseEV = nBaseEV
        this.sLabel = sLabel
        this.oEVElement = oEVElement
    }

    fun getsLabel(): String {
        return sLabel
    }

    fun setsLabel(sLabel: String) {
        this.sLabel = sLabel
    }

    fun getnBaseEV(): Int {
        return nBaseEV
    }

    fun setnBaseEV(nEVYield: Int) {
        this.nEVYield = nEVYield
    }

    fun getnEVYield(): Int {
        return nEVYield
    }

    fun setnEVYield(nPokemon: Int) {
        this.nEVYield = nPokemon
    }

    fun getoEVElement(): EVElementsTable {
        return oEVElement
    }

    fun setoEVElement(oEVElement: EVElementsTable) {
        this.oEVElement = oEVElement
    }

    override fun toString(): String {
        return "Pokerus"
    }

}