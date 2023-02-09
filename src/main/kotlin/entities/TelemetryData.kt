/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package entities

/**
 * Object that represents the telemetry data.
 * @param bodyTemperature the temperature of the body.
 * @param saturation the saturation of the blood.
 * @param respirationRate the respiration rate of a person.
 * @param heartBeat the heartbeat of a person.
 * @param bloodPressure the pressure of the blood. 
 */
class TelemetryData(
    val bodyTemperature: BodyTemperature,
    val saturation: Saturation,
    val respirationRate: RespirationRate,
    val heartBeat: HeartBeat,
    val bloodPressure: BloodPressure
)

/**
 * Represents the body temperature.
 * @param temperature the value of temperature.
 * @param temperatureUnit the used unit of measurement of the temperature.
 */
data class BodyTemperature(val temperature: Double, val temperatureUnit: UnitOfMeasurement.TemperatureUnit)

/**
 * Represents the blood oxygen level.
 * @param percentage the percentage of saturation.
 */
data class Saturation(val percentage: Int)

/**
 * Represents how many times a person breathes in a minute.
 * @param breathPerMinute the number of breath in one minute.
 */
data class RespirationRate(val breathPerMinute: Int)

/**
 * Represents the blood pressure of a person.
 * @param diastolicBloodPressure the diastolic blood pressure.
 * @param systolicBloodPressure the systolic blood pressure.
 * @param bloodPressureUnit the blood pressure unit.
 */
data class BloodPressure(
    val diastolicBloodPressure: Int,
    val systolicBloodPressure: Int,
    val bloodPressureUnit: UnitOfMeasurement.BloodPressureUnit
)

/**
 * Represents the hearth beat of a person.
 * @param beatPerMinute the beat per minute.
 */
data class HeartBeat(val beatPerMinute: Int)

/**
 * Object that contains enum for unit of measurement.
 */
object UnitOfMeasurement {

    /**
     * Enum class for blood pressure unit.
     */
    enum class BloodPressureUnit {
        MMHG
    }

    /**
     * Enum class for temperature unit.
     */
    enum class TemperatureUnit {
        CELSIUS,
        FAHRENHEIT
    }
}
