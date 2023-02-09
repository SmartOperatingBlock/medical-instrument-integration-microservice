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
 */
object TelemetryData {

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
}
