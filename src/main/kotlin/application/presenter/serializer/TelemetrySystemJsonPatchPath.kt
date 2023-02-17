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
     * The path of the heartbeat value in the jsonPatch.
     */
    const val BEAT_PER_MINUTE = "/heart_beat"

    /**
     * The path of the diastolic blood pressure in the jsonPatch.
     */
    const val DIASTOLIC_BLOOD_PRESSURE = "/diastolic_blood_pressure"

    /**
     * The path of the systolic blood pressure in the jsonPatch.
     */
    const val SYSTOLIC_BLOOD_PRESSURE = "/systolic_blood_pressure"

    /**
     * The path of the respiration rate in the jsonPatch.
     */
    const val BREATH_PER_MINUTE = "/respiratory_rate"

    /**
     * The path of the saturation value in the jsonPatch.
     */
    const val SATURATION = "/saturation_percentage"

    /**
     * The path of the temperature of the body in the jsonPatch.
     */
    const val BODY_TEMPERATURE = "/body_temperature"
}
