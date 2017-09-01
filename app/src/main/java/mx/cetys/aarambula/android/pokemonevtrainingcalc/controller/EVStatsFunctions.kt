package mx.cetys.aarambula.android.pokemonevtrainingcalc.controller

/**
 * Created by aarambula on 9/1/2017.
 */
class EVStatsFunctions {
    fun calculateEVStat(nBaseStat: Int, nIV: Int, nEV: Int, nLevel: Int, xNature: Double): Double {
        return Math.floor(((Math.floor((2 * nBaseStat) + nIV + Math.floor(nEV / 4.00)) * nLevel / 100) + 5) * xNature)
    }
}