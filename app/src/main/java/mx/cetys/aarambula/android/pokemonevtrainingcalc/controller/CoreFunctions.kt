package mx.cetys.aarambula.android.pokemonevtrainingcalc.controller

import mx.cetys.aarambula.android.pokemonevtrainingcalc.model.EVElementsTable
import mx.cetys.aarambula.android.pokemonevtrainingcalc.model.PokemonBattle

/**
 * Created by AngelArambula on 8/21/17.
 */

class CoreFunctions {
    val lEVElements: MutableList<EVElementsTable> = arrayListOf()

    init {
        InitEVElements()
    }

    fun InitEVElements() {
        lEVElements.add(EVElementsTable(true, true, true))
        lEVElements.add(EVElementsTable(true, true, false))
        lEVElements.add(EVElementsTable(true, false, true))
        lEVElements.add(EVElementsTable(true, false, false))
        lEVElements.add(EVElementsTable(false, true, true))
        lEVElements.add(EVElementsTable(false, true, false))
        lEVElements.add(EVElementsTable(false, false, true))
        lEVElements.add(EVElementsTable(false, false, false))
    }

    fun getBaseEV(nEVSpread: Int, bPokerus: Boolean, bSOS: Boolean, bPowerItem: Boolean): Int {
        val nPokerus = if (bPokerus) 2 else 1
        val nPowerItem = if (bPowerItem) 8 else 0
        val nSOS = if (bSOS) 2 else 1
        return (nEVSpread + nPowerItem) * nPokerus * nSOS
    }

    fun calculatePokemonToDefeat(nEVTarget: Int,
                                 nBaseEV: Int,
                                 nVitamins: Int,
                                 bPokerus: Boolean,
                                 bSOS: Boolean,
                                 bPowerItem: Boolean,
                                 bCalculate: Boolean):
            MutableList<PokemonBattle> {

        val lPokemonToDefeat: MutableList<PokemonBattle> = arrayListOf()
        var nEVReminder = nEVTarget - if (nVitamins >= 10) 100 else nVitamins * 10
        var nCalcBaseEV = 0
        for (oEVElement in lEVElements) {
            //Calculate with the available elements
            if (bCalculate && (bPokerus == false && oEVElement.isbPokerus()
                    || bSOS == false && oEVElement.isbSOS()
                    || bPowerItem == false && oEVElement.isbPowerItem())) {
                continue
            }

            nCalcBaseEV = getBaseEV(nBaseEV,
                    oEVElement.isbPokerus(),
                    oEVElement.isbSOS(),
                    oEVElement.isbPowerItem())

            val nPokemon = nEVReminder / nCalcBaseEV
            nEVReminder %= nCalcBaseEV

            if (nPokemon > 0) {
                val oPokemonResult = PokemonBattle()
                oPokemonResult.setnPokemon(nPokemon)
                oPokemonResult.setsLabel(oEVElement.toString())
                lPokemonToDefeat.add(oPokemonResult)
            }
        }

        return lPokemonToDefeat
    }
}
