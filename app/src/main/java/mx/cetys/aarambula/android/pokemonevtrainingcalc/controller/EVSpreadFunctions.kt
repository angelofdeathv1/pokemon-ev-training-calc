package mx.cetys.aarambula.android.pokemonevtrainingcalc.controller

import mx.cetys.aarambula.android.pokemonevtrainingcalc.model.EVElementsTable
import mx.cetys.aarambula.android.pokemonevtrainingcalc.model.EVYieldOption
import mx.cetys.aarambula.android.pokemonevtrainingcalc.model.PokemonBattleRow

/**
 * Created by AngelArambula on 8/21/17.
 */

class EVSpreadFunctions {
    private val lEVElements: MutableList<EVElementsTable> = mutableListOf()
    private lateinit var lEVBattles: MutableList<PokemonBattleRow>
    private lateinit var lEVAllowed: MutableList<PokemonBattleRow>
    private var bStop: Boolean = false

    init {
        InitEVElements()
    }

    fun validateEVOptions(nEVTarget: Int,
                          bEVYield1: Boolean,
                          bEVYield2: Boolean,
                          bEVYield3: Boolean,
                          nVitamins: Int,
                          bPokerus: Boolean,
                          bSOS: Boolean,
                          bPowerItem: Boolean): Boolean {
        var nEVReminder: Int = nEVTarget - if (nVitamins >= 10) 100 else nVitamins * 10
        var nCalcBaseEV: Int

        val oOptions = EVYieldOption(bEVYield1, bEVYield2, bEVYield3)
        InitAllowedValues(oOptions.getEVYields(), bPokerus, bSOS, bPowerItem)

        for (oAllowed in lEVAllowed) {
            nCalcBaseEV = oAllowed.getnEVYield()
            nEVReminder %= nCalcBaseEV
            if (nEVReminder == 0) {
                return true
            }
        }

        return false
    }

    fun calculatePokemonToDefeat(nEVTarget: Int,
                                 nVitamins: Int):
            MutableList<PokemonBattleRow> {
        var lPokemonToDefeat: MutableList<PokemonBattleRow>
        val nEVReminder = nEVTarget - if (nVitamins >= 10) 100 else nVitamins * 10
        bStop = false
        lEVBattles = mutableListOf()
        lPokemonToDefeat = getPartitionEVSpread(nEVReminder, nEVReminder)
        val oTest=lPokemonToDefeat.groupBy { it.getsLabel() }

        return lPokemonToDefeat
    }

    private fun getPartitionEVSpread(nEVReminder: Int, nEVTarget: Int): MutableList<PokemonBattleRow> {
        if (nEVReminder == 0) {
            bStop = true
        }

        for (i in Math.min(nEVTarget, nEVReminder) downTo 1) {
            var nIndex = lEVAllowed.indexOfFirst { it.getnEVYield() == i }
            if (nIndex >= 0 && !bStop) {
                val oTmpPokemonBattle = lEVAllowed[nIndex]
                val oTmpEVElement = oTmpPokemonBattle.getoEVElement()
                val oTmpBattleRow = PokemonBattleRow(oTmpEVElement.toString(), oTmpPokemonBattle.getnBaseEV(), i, oTmpEVElement)
                lEVBattles.add(oTmpBattleRow)
                getPartitionEVSpread(nEVReminder - i, i)
            } else {
                continue
            }
        }
        return lEVBattles
    }

    private fun InitAllowedValues(lEVYields: MutableList<Int>, bPokerus: Boolean, bSOS: Boolean, bPowerItem: Boolean) {
        lEVAllowed = mutableListOf()
        var nIndex: Int = 0
        for (i in lEVYields.indices) {
            for (oEVElement in lEVElements) {
                if (bPokerus != oEVElement.isbPokerus()) {
                    continue
                }

                if (!bSOS && oEVElement.isbSOS()
                        || !bPowerItem && oEVElement.isbPowerItem()) {
                    continue
                }

                val nBaseEV = getBaseEV(lEVYields[i], oEVElement.isbPokerus(), oEVElement.isbSOS(), oEVElement.isbPowerItem())
                val oPokemonBattle = PokemonBattleRow(nIndex.toString(), lEVYields[i], nBaseEV, oEVElement)
                lEVAllowed.add(oPokemonBattle)
                nIndex += 1

            }
        }
        lEVAllowed.sortByDescending { it.getnEVYield() }
        lEVAllowed.distinctBy { it.getnEVYield() }
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

    private fun getBaseEV(nEVSpread: Int, bPokerus: Boolean, bSOS: Boolean, bPowerItem: Boolean): Int {
        val nPokerus = if (bPokerus) 2 else 1
        val nPowerItem = if (bPowerItem) 8 else 0
        val nSOS = if (bSOS) 2 else 1
        return (nEVSpread + nPowerItem) * nPokerus * nSOS
    }

}
