/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package application

import application.presenter.deserializer.JsonDeserializer
import com.azure.core.models.JsonPatchDocument

/**
 * A controller for medical instrument.
 */
class MedicalInstrumentController(private val manager: MedicalInstrumentManager<JsonPatchDocument>) {

    /**
     * Received data about a medical instrument.
     */
    fun medicalInstrumentDataReceived(data: String) {
        val deserializer = JsonDeserializer.TelemetrySystemJsonDeserializer()
        val medicalInstrument = deserializer.deserialize(data)
        manager.update(medicalInstrument.medicalInstrumentID.id, medicalInstrument)
    }
}
