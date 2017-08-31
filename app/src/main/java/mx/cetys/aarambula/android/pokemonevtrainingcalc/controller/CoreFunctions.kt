package mx.cetys.aarambula.android.pokemonevtrainingcalc.controller

import mx.cetys.aarambula.android.pokemonevtrainingcalc.model.EVElementsTable
import mx.cetys.aarambula.android.pokemonevtrainingcalc.model.EVYieldOption
import mx.cetys.aarambula.android.pokemonevtrainingcalc.model.PokemonBattleRow

/**
 * Created by AngelArambula on 8/21/17.
 */

class CoreFunctions {
    private val lEVElements: MutableList<EVElementsTable> = arrayListOf()
    private val lEVBattles: MutableList<PokemonBattleRow> = mutableListOf()
    private var arrAllowedF: MutableList<PokemonBattleRow> = mutableListOf()
    private var bStop: Boolean = false

    init {
        InitEVElements()
    }

    private fun InitEVElements() {
        lEVElements.add(EVElementsTable(true, true, true))
        lEVElements.add(EVElementsTable(true, true, false))
        lEVElements.add(EVElementsTable(true, false, true))
        lEVElements.add(EVElementsTable(true, false, false))
        lEVElements.add(EVElementsTable(false, true, true))
        lEVElements.add(EVElementsTable(false, true, false))
        lEVElements.add(EVElementsTable(false, false, true))
        lEVElements.add(EVElementsTable(false, false, false))
    }

    private fun InitAllowedValues(lEVYields: MutableList<Int>, bPokerus: Boolean, bSOS: Boolean, bPowerItem: Boolean) {
        arrAllowedF = mutableListOf()
        for (i in lEVYields.indices) {
            for (oEVElement in lEVElements) {
                if (bPokerus != oEVElement.isbPokerus()) {
                    continue
                }

                if (bSOS == false && oEVElement.isbSOS()
                        || bPowerItem == false && oEVElement.isbPowerItem()) {
                    continue
                }

                val nBaseEV = getBaseEV(lEVYields[i], oEVElement.isbPokerus(), oEVElement.isbSOS(), oEVElement.isbPowerItem())
                val oPokemonBattle = PokemonBattleRow("", lEVYields[i], nBaseEV, oEVElement)
                arrAllowedF.add(oPokemonBattle)

            }
        }
    }

    private fun getBaseEV(nEVSpread: Int, bPokerus: Boolean, bSOS: Boolean, bPowerItem: Boolean): Int {
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
            MutableList<PokemonBattleRow> {

        val lPokemonToDefeat: MutableList<PokemonBattleRow> = arrayListOf()
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
                val oPokemonResult = PokemonBattleRow()
                val oElement = EVElementsTable(oEVElement.isbPokerus(), oEVElement.isbSOS(), oEVElement.isbPowerItem())
                oPokemonResult.setoEVElement(oElement)
                oPokemonResult.setnEVYield(nPokemon)
                oPokemonResult.setsLabel(oEVElement.toString())
                lPokemonToDefeat.add(oPokemonResult)
            }
        }

        return lPokemonToDefeat
    }

    fun calculatePokemonToDefeat(nEVTarget: Int,
                                 bEVYield1: Boolean,
                                 bEVYield2: Boolean,
                                 bEVYield3: Boolean,
                                 nVitamins: Int,
                                 bPokerus: Boolean,
                                 bSOS: Boolean,
                                 bPowerItem: Boolean):
            MutableList<PokemonBattleRow> {
        var lPokemonToDefeat: MutableList<PokemonBattleRow> = arrayListOf()
        val nEVReminder = nEVTarget - if (nVitamins >= 10) 100 else nVitamins * 10
        bStop = false

        val oOptions = EVYieldOption(bEVYield1, bEVYield2, bEVYield3)
        InitAllowedValues(oOptions.getEVYields(), bPokerus, bSOS, bPowerItem)
        lPokemonToDefeat = partitionEVSpread(nEVReminder, nEVReminder)

        return lPokemonToDefeat
    }

    fun calculateEVStat(nBaseStat: Int, nIV: Int, nEV: Int, nLevel: Int, xNature: Double): Double {
        return Math.floor(((Math.floor((2 * nBaseStat) + nIV + Math.floor(nEV / 4.00)) * nLevel / 100) + 5) * xNature)
    }

    private fun partitionEVSpread(n: Int, max: Int): MutableList<PokemonBattleRow> {
        if (n == 0) {
            bStop = true
        }

        for (i in Math.min(max, n) downTo 1) {
            var nIndex = arrAllowedF.indexOfFirst { it.getnEVYield() == i }
            if (nIndex >= 0 && bStop == false) {

                val oPokemonBattle = arrAllowedF[nIndex]
                val oEVElement = oPokemonBattle.getoEVElement()
                val oBattleRow = PokemonBattleRow(oEVElement.toString(), oPokemonBattle.getnBaseEV(), i, oEVElement)
                lEVBattles.add(oBattleRow)
                partitionEVSpread(n - i, i)
            } else {
                continue
            }
        }
        return lEVBattles
    }
}
