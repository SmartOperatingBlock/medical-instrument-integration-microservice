/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package application.presenter.serializer

import com.azure.core.models.JsonPatchDocument
import entities.TelemetrySystem

/**
 * A json serializer.
 */
object JsonPatchSerializer {

    /**
     *  A json deserializer implementation for [TelemetrySystem].
     */
    class TelemetrySystemJSONPatchSerializer : Serializer<TelemetrySystem, JsonPatchDocument> {

        /**
         * Deserializes the json returning an instance of [TelemetrySystem].
         */
        override fun serialize(entity: TelemetrySystem): JsonPatchDocument {
            return JsonPatchDocument()
                .appendAdd(TelemetrySystemJsonPatchPath.PATIENT_ID, entity.patientID.id)
        }
    }
}
