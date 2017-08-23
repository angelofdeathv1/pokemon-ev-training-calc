package mx.cetys.aarambula.android.pokemonevtrainingcalc.model

/**
 * Created by aarambula on 8/22/2017.
 */
class PokemonBattleRow {
    private var oEVElement: EVElementsTable = EVElementsTable()
    private var sLabel: String = ""
    private var nPokemon: Int = 0

    constructor()

    constructor(sLabel: String, nPokemon: Int, oEVElement: EVElementsTable) {
        this.nPokemon = nPokemon
        this.oEVElement = oEVElement
        this.sLabel = sLabel
    }

    fun getsLabel(): String {
        return sLabel
    }

    fun setsLabel(sLabel: String) {
        this.sLabel = sLabel
    }

    fun getnPokemon(): Int {
        return nPokemon
    }

    fun setnPokemon(nPokemon: Int) {
        this.nPokemon = nPokemon
    }

    fun getoEVElement(): EVElementsTable {
        return oEVElement
    }

    fun setoEVElement(oEVElement: EVElementsTable) {
        this.oEVElement = oEVElement
    }

    override fun toString(): String {
        return super.toString()
    }

}