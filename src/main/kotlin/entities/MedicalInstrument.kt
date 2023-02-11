/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package entities

/**
 * A generic interface of a medical instrument.
 */
interface MedicalInstrument {
    /**
     * The id of the medical instrument.
     */
    val medicalInstrumentID: MedicalInstrumentID

    /**
     * the id of the patient in the operating room.
     */
    val patientID: PatientID
}

/**
 * The id of the medical instrument.
 * @param id the id of the medical instrument.
 */
data class MedicalInstrumentID(val id: String)

/**
 * The id of the patient in the operating room.
 * @param id the id of the patient.
 */
data class PatientID(val id: String)
