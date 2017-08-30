package mx.cetys.aarambula.android.pokemonevtrainingcalc.model

/**
 * Created by aarambula on 8/29/2017.
 */
class EVYieldOption {
    private var bEVYield1: Boolean = false
    private var bEVYield2: Boolean = false
    private var bEVYield3: Boolean = false
    var lEVYields: MutableList<Int> = mutableListOf()

    constructor(bEVYield1: Boolean, bEVYield2: Boolean, bENVYield3: Boolean) {
        this.bEVYield1 = bEVYield1
        this.bEVYield2 = bEVYield2
        this.bEVYield3 = bENVYield3

        initEVYields()

    }

    private fun initEVYields() {
        if (bEVYield1) {
            lEVYields.add(1)
        }
        if (bEVYield2) {
            lEVYields.add(2)
        }
        if (bEVYield3) {
            lEVYields.add(3)
        }
    }

    fun getEVYields(): MutableList<Int> {
        return lEVYields
    }

}