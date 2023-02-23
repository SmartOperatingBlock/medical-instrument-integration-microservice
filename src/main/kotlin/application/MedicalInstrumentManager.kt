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
     * @param medicalInstrument the medical instrument with updated data.
     */
    fun updateMedicalInstrumentDigitalTwin(medicalInstrument: MedicalInstrument): Boolean
}
