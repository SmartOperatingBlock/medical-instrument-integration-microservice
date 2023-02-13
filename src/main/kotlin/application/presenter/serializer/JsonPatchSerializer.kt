/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package application.presenter.serializer

import application.presenter.serializer.TelemetrySystemJsonPatchPath.BEAT_PER_MINUTE
import application.presenter.serializer.TelemetrySystemJsonPatchPath.BLOOD_PRESSURE_UNIT
import application.presenter.serializer.TelemetrySystemJsonPatchPath.BODY_TEMPERATURE
import application.presenter.serializer.TelemetrySystemJsonPatchPath.BREATH_PER_MINUTE
import application.presenter.serializer.TelemetrySystemJsonPatchPath.DIASTOLIC_BLOOD_PRESSURE
import application.presenter.serializer.TelemetrySystemJsonPatchPath.SATURATION
import application.presenter.serializer.TelemetrySystemJsonPatchPath.SYSTOLIC_BLOOD_PRESSURE
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
                .appendAdd(SYSTOLIC_BLOOD_PRESSURE, entity.telemetryData.bloodPressure.systolicBloodPressure)
                .appendAdd(DIASTOLIC_BLOOD_PRESSURE, entity.telemetryData.bloodPressure.diastolicBloodPressure)
                .appendAdd(BLOOD_PRESSURE_UNIT, entity.telemetryData.bloodPressure.bloodPressureUnit.name.lowercase())
                .appendAdd(BODY_TEMPERATURE, entity.telemetryData.bodyTemperature.temperature)
                .appendAdd(BEAT_PER_MINUTE, entity.telemetryData.heartbeat.beatPerMinute)
                .appendAdd(BREATH_PER_MINUTE, entity.telemetryData.respirationRate.breathPerMinute)
                .appendAdd(SATURATION, entity.telemetryData.saturation.percentage)
        }
    }
}
