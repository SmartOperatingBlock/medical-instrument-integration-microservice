/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package application.presenter.serializer

import application.presenter.serializer.TelemetrySystemJsonPatchPath.BEAT_PER_MINUTE
import application.presenter.serializer.TelemetrySystemJsonPatchPath.BODY_TEMPERATURE
import application.presenter.serializer.TelemetrySystemJsonPatchPath.BREATH_PER_MINUTE
import application.presenter.serializer.TelemetrySystemJsonPatchPath.DIASTOLIC_BLOOD_PRESSURE
import application.presenter.serializer.TelemetrySystemJsonPatchPath.SATURATION
import application.presenter.serializer.TelemetrySystemJsonPatchPath.SYSTOLIC_BLOOD_PRESSURE
import com.azure.core.models.JsonPatchDocument
import entity.TelemetrySystem

/**
 * A json serializer.
 */
object JsonPatchSerializer {

    /**
     *  A json deserializer implementation for [TelemetrySystem].
     */
    class TelemetrySystemJSONPatchSerializer : Serializer<TelemetrySystem, List<JsonPatchDocument>> {

        override fun serialize(entity: TelemetrySystem): List<JsonPatchDocument> {
            return listOf(
                JsonPatchDocument()
                    .appendAdd(SYSTOLIC_BLOOD_PRESSURE, entity.telemetryData.bloodPressure.systolicBloodPressure),
                JsonPatchDocument()
                    .appendAdd(DIASTOLIC_BLOOD_PRESSURE, entity.telemetryData.bloodPressure.diastolicBloodPressure),
                JsonPatchDocument().appendAdd(BODY_TEMPERATURE, entity.telemetryData.bodyTemperature.temperature),
                JsonPatchDocument().appendAdd(BEAT_PER_MINUTE, entity.telemetryData.heartbeat.beatPerMinute),
                JsonPatchDocument().appendAdd(BREATH_PER_MINUTE, entity.telemetryData.respirationRate.breathPerMinute),
                JsonPatchDocument().appendAdd(SATURATION, entity.telemetryData.saturation.percentage),
            )
        }
    }
}
