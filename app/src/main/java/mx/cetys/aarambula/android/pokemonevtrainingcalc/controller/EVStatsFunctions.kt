package mx.cetys.aarambula.android.pokemonevtrainingcalc.controller

/**
 * Created by aarambula on 9/1/2017.
 */
class EVStatsFunctions {
    fun getStat(nBaseStat: Int, nIV: Int, nEV: Int, nLevel: Int, xNature: Double): Double {
        return Math.floor(((Math.floor((2 * nBaseStat) + nIV + Math.floor(nEV / 4.00)) * nLevel / 100) + 5) * xNature)
    }

    fun getEVStat(nBaseStat: Int, nIV: Int, nStat: Double, nLevel: Int, xNature: Double): Long {
        return 4 * (Math.round(((Math.round(nStat / xNature) - 5)) * 100.00 / nLevel) - (2 * nBaseStat) - nIV)
    }
}