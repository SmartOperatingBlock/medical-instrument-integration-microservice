/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package application

import entities.MedicalInstrument

/**
 * Generic manager of a Medical Instrument.
 */
interface MedicalInstrumentManager<T> {

    /**
     * Integrate the medical instrument Data in our system.
     * @param medicalInstrumentID the id of the medical instrument.
     * @param command the command to integrate the medical instrument.
     */
    fun update(medicalInstrumentID: String, medicalInstrument: MedicalInstrument)
}
