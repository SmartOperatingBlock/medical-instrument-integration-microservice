/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package presenter

/**
 * Maintains all the keys present in the json.
 */
object JsonKeys {

    /**
     * The key of the patient id in the json.
     */
    const val PATIENT_ID = "patientID"

    /**
     * The key of the telemetry system id in the json.
     */
    const val TELEMETRY_SYSTEM_ID = "telemetrySystemID"

    /**
     * The key of the heartbeat value in the json.
     */
    const val BEAT_PER_MINUTE = "beatPerMinute"

    /**
     * The key of the blood pressure in the json.
     */
    const val BLOOD_PRESSURE = "bloodPressure"

    /**
     * The key of the diastolic blood pressure in the json.
     */
    const val DIASTOLIC_BLOOD_PRESSURE = "diastolicBloodPressure"

    /**
     * The key of the systolic blood pressure in the json.
     */
    const val SYSTOLIC_BLOOD_PRESSURE = "systolicBloodPressure"

    /**
     * The key of the blood pressure unit of measurement in the json.
     */
    const val BLOOD_PRESSURE_UNIT = "bloodPressureUnit"

    /**
     * The key of the respiration rate in the json.
     */
    const val BREATH_PER_MINUTE = "breathPerMinute"

    /**
     * The key of the saturation value in the json.
     */
    const val SATURATION = "saturation"

    /**
     * The key of the temperature of the body in the json.
     */
    const val BODY_TEMPERATURE = "bodyTemperature"

    /**
     * The key of the temperature value in the json.
     */
    const val TEMPERATURE = "temperature"

    /**
     * The key of the temperature unit of measurement in the json.
     */
    const val TEMPERATURE_UNIT = "temperatureUnit"
}
