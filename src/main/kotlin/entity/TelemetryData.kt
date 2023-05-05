/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package entity

/**
 * Represents the telemetry data retrieved from a telemetry system.
 * @param bodyTemperature the temperature of the body.
 * @param saturation the saturation of the blood.
 * @param respirationRate the respiration rate of a person.
 * @param heartbeat the heartbeat of a person.
 * @param bloodPressure the pressure of the blood.
 */
class TelemetryData(
    val bodyTemperature: BodyTemperature,
    val saturation: Saturation,
    val respirationRate: RespirationRate,
    val heartbeat: Heartbeat,
    val bloodPressure: BloodPressure,
)

/**
 * Represents the body temperature.
 * @param temperature the value of temperature.
 * @param temperatureUnit the used unit of measurement of the temperature.
 */
data class BodyTemperature(
    val temperature: Double,
    val temperatureUnit: UnitOfMeasurement.TemperatureUnit = UnitOfMeasurement.TemperatureUnit.CELSIUS,
)

/**
 * Represents the blood oxygen level.
 * @param percentage the percentage of saturation.
 */
data class Saturation(val percentage: Int) {
    init {
        validatePercentage(percentage)
    }

    /**
     * Check that the percentage is between 0 and 100.
     * @param percentage the percentage.
     */
    private fun validatePercentage(percentage: Int) = require(percentage in 1..100)
}

/**
 * Represents how many times a person breathes in a minute.
 * @param breathPerMinute the number of breath in one minute.
 */
data class RespirationRate(val breathPerMinute: Int)

/**
 * Represents the blood pressure of a person.
 * @param diastolicBloodPressure the diastolic blood pressure.
 * @param systolicBloodPressure the systolic blood pressure.
 */
data class BloodPressure(
    val diastolicBloodPressure: Int,
    val systolicBloodPressure: Int,
)

/**
 * Represents the hearth beat of a person.
 * @param beatPerMinute the beat per minute.
 */
data class Heartbeat(val beatPerMinute: Int)

/**
 * Object that contains enum for unit of measurement.
 */
object UnitOfMeasurement {

    /**
     * Enum class for temperature unit.
     */
    enum class TemperatureUnit {
        CELSIUS,
        FAHRENHEIT,
    }
}
