/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package application

import com.azure.core.models.JsonPatchDocument
import entity.TelemetrySystem
import usecase.repository.TelemetrySystemRepository

/**
 * A controller for medical instrument.
 */
class MedicalInstrumentController(
    private val manager: MedicalInstrumentManager<JsonPatchDocument>
) : TelemetrySystemRepository {

    /**
     * Updates the telemetry system.
     */
    override fun updateTelemetrySystem(telemetrySystem: TelemetrySystem): Boolean =
        manager.updateMedicalInstrumentDigitalTwin(telemetrySystem)
}
