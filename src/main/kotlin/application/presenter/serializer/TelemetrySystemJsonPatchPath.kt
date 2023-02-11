/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package application.presenter.serializer

/**
 * Maintains all the path to build a jsonPatch.
 */
object TelemetrySystemJsonPatchPath {

    /**
     * The path of the patient id in the jsonPatch.
     */
    const val PATIENT_ID = "/patientID"

    /**
     * The path of the telemetry system id in the jsonPatch.
     */
    const val TELEMETRY_SYSTEM_ID = "/telemetrySystemID"

    /**
     * The path of the heartbeat value in the jsonPatch.
     */
    const val BEAT_PER_MINUTE = "/beatPerMinute"

    /**
     * The path of the blood pressure in the jsonPatch.
     */
    const val BLOOD_PRESSURE = "/bloodPressure"

    /**
     * The path of the diastolic blood pressure in the jsonPatch.
     */
    const val DIASTOLIC_BLOOD_PRESSURE = "/diastolicBloodPressure"

    /**
     * The path of the systolic blood pressure in the jsonPatch.
     */
    const val SYSTOLIC_BLOOD_PRESSURE = "/systolicBloodPressure"

    /**
     * The path of the blood pressure unit of measurement in the jsonPatch.
     */
    const val BLOOD_PRESSURE_UNIT = "/bloodPressureUnit"

    /**
     * The path of the respiration rate in the jsonPatch.
     */
    const val BREATH_PER_MINUTE = "/breathPerMinute"

    /**
     * The path of the saturation value in the jsonPatch.
     */
    const val SATURATION = "/saturation"

    /**
     * The path of the temperature of the body in the jsonPatch.
     */
    const val BODY_TEMPERATURE = "/bodyTemperature"

    /**
     * The path of the temperature value in the jsonPatch.
     */
    const val TEMPERATURE = "/temperature"

    /**
     * The path of the temperature unit of measurement in the jsonPatch.
     */
    const val TEMPERATURE_UNIT = "/temperatureUnit"
}
