/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package presenter
import com.google.gson.Gson
import com.google.gson.JsonObject
import entities.BloodPressure
import entities.BodyTemperature
import entities.Heartbeat
import entities.PatientID
import entities.RespirationRate
import entities.Saturation
import entities.TelemetryData
import entities.TelemetrySystem
import entities.TelemetrySystemID
import entities.UnitOfMeasurement
import presenter.JsonKeys.BEAT_PER_MINUTE
import presenter.JsonKeys.BLOOD_PRESSURE
import presenter.JsonKeys.BLOOD_PRESSURE_UNIT
import presenter.JsonKeys.BODY_TEMPERATURE
import presenter.JsonKeys.BREATH_PER_MINUTE
import presenter.JsonKeys.DIASTOLIC_BLOOD_PRESSURE
import presenter.JsonKeys.PATIENT_ID
import presenter.JsonKeys.SATURATION
import presenter.JsonKeys.SYSTOLIC_BLOOD_PRESSURE
import presenter.JsonKeys.TELEMETRY_SYSTEM_ID
import presenter.JsonKeys.TEMPERATURE
import presenter.JsonKeys.TEMPERATURE_UNIT

/**
 * A json deserializer.
 */
object JsonDeserializer {

    /**
     * A json deserializer implementation.
     */
    class JsonDeserializer : Deserializer {

        /**
         * Deserializes the json returning an instance of [TelemetrySystem].
         */
        override fun deserialize(data: String): TelemetrySystem {
            val jsonObject = Gson().fromJson(data, JsonObject::class.java)
            val telemetrySystemId = TelemetrySystemID(jsonObject.getTelemetrySystemID())
            val patientID = PatientID(jsonObject.getPatientID())
            val bodyTemperature = BodyTemperature(
                jsonObject.getBodyTemperature(),
                UnitOfMeasurement.TemperatureUnit.valueOf(jsonObject.getTemperatureUnit().uppercase())
            )
            val saturation = Saturation(jsonObject.getSaturation())
            val respirationRate = RespirationRate(jsonObject.getBreathPerMinute())
            val heartbeat = Heartbeat(jsonObject.getBeatPerMinute())
            val bloodPressure = BloodPressure(
                jsonObject.getDiastolicBloodPressure(),
                jsonObject.getSystolicBloodPressure(),
                UnitOfMeasurement.BloodPressureUnit.valueOf(jsonObject.getBloodPressureUnit().uppercase())
            )
            val telemetryData = TelemetryData(bodyTemperature, saturation, respirationRate, heartbeat, bloodPressure)
            return TelemetrySystem(telemetrySystemId, patientID, telemetryData)
        }
    }

    /**
     * Gets the patient id from [JsonObject].
     */
    private fun JsonObject.getPatientID(): String = this[PATIENT_ID].asString

    /**
     * Gets the telemetry system id from [JsonObject].
     */
    private fun JsonObject.getTelemetrySystemID(): String = this[TELEMETRY_SYSTEM_ID].asString

    /**
     * Gets the heartbeat from [JsonObject].
     */
    private fun JsonObject.getBeatPerMinute(): Double = this[BEAT_PER_MINUTE].asDouble

    /**
     * Gets the blood saturation from [JsonObject].
     */
    private fun JsonObject.getSaturation(): Int = this[SATURATION].asInt

    /**
     * Gets the diastolic blood pressure from [JsonObject].
     */
    private fun JsonObject.getDiastolicBloodPressure(): Int =
        this[BLOOD_PRESSURE].asJsonObject[DIASTOLIC_BLOOD_PRESSURE].asInt

    /**
     * Gets the systolic blood pressure from [JsonObject].
     */
    private fun JsonObject.getSystolicBloodPressure(): Int =
        this[BLOOD_PRESSURE].asJsonObject[SYSTOLIC_BLOOD_PRESSURE].asInt

    /**
     * Gets the blood pressure unit from [JsonObject].
     */
    private fun JsonObject.getBloodPressureUnit(): String =
        this[BLOOD_PRESSURE].asJsonObject[BLOOD_PRESSURE_UNIT].asString

    /**
     * Gets the respiration rate from [JsonObject].
     */
    private fun JsonObject.getBreathPerMinute(): Double = this[BREATH_PER_MINUTE].asDouble

    /**
     * Gets the body temperature from [JsonObject].
     */
    private fun JsonObject.getBodyTemperature(): Double =
        this[BODY_TEMPERATURE].asJsonObject[TEMPERATURE].asDouble

    /**
     * Gets the temperature unit from [JsonObject].
     */
    private fun JsonObject.getTemperatureUnit(): String =
        this[BODY_TEMPERATURE].asJsonObject[TEMPERATURE_UNIT].asString
}
