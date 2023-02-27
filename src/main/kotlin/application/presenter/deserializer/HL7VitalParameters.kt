/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package application.presenter.deserializer

/**
 * HL7 codes of vital parameters.
 * @param code the code of the vital parameters.
 */
enum class HL7VitalParameters(val code: String) {
    SYSTOLIC_BLOOD_PRESSURE("8480-6"),
    DIASTOLIC_BLOOD_PRESSURE("8462-4"),
    BODY_TEMPERATURE("8310-5"),
    HEART_RATE("8867-4"),
    RESPIRATION_RATE("9279-1"),
    OXYGEN_SATURATION_IN_ARTERIAL_BLOOD("2708-6");
}
