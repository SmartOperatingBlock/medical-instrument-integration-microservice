/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

import entities.PatientID
import infrastructure.MedicalInstrumentDataReceiver
import kotlin.concurrent.timer
import kotlin.random.Random

/**
 * Min beat per minute.
 */
const val MIN_BEAT_PER_MINUTE = 30

/**
 * Max beat per minute.
 */
const val MAX_BEAT_PER_MINUTE = 40

/**
 * Min diastolic blood pressure.
 */
const val MIN_DIASTOLIC_BLOOD_PRESSURE = 60

/**
 * Max diastolic blood pressure.
 */
const val MAX_DIASTOLIC_BLOOD_PRESSURE = 80

/**
 * Min diastolic blood pressure.
 */
const val MIN_SYSTOLIC_BLOOD_PRESSURE = 90

/**
 * Max diastolic blood pressure.
 */
const val MAX_SYSTOLIC_BLOOD_PRESSURE = 130

/**
 * Min breath per minute.
 */
const val MIN_BREATH_PER_MINUTE = 6

/**
 * Max breath per minute.
 */
const val MAX_BREATH_PER_MINUTE = 25

/**
 * Min blood saturation.
 */
const val MIN_SATURATION = 90

/**
 * Max blood saturation.
 */
const val MAX_SATURATION = 100

/**
 * Min body temperature.
 */
const val MIN_TEMPERATURE = 36.0

/**
 * Max body temperature.
 */
const val MAX_TEMPERATURE = 40.0

/**
 * Represents a third party system that sends to our system data about medical devices.
 */
class ThirdPartySystemSimulator(private val medicalInstrumentDataReceiver: MedicalInstrumentDataReceiver) {
    private val patients = listOf(PatientID("patient1"))

    /**
     * Starts the simulator.
     */
    fun startSimulator() {
        timer(initialDelay = 0, period = 500) {
            patients.forEach {
                val telemetrySystemData = """
                    {
                        "telemetrySystemID": "TelemetrySystem",
                        "patientID" : "${it.id}", 
                        "beatPerMinute" : ${Random.nextInt(MIN_BEAT_PER_MINUTE, MAX_BEAT_PER_MINUTE)}, 
                        "bloodPressure" : {
                            "diastolicBloodPressure" : ${Random.nextInt(MIN_DIASTOLIC_BLOOD_PRESSURE, MAX_DIASTOLIC_BLOOD_PRESSURE)}, 
                            "systolicBloodPressure" : ${Random.nextInt(MIN_SYSTOLIC_BLOOD_PRESSURE, MAX_SYSTOLIC_BLOOD_PRESSURE)}, 
                        }, 
                        "breathPerMinute" : ${Random.nextInt(MIN_BREATH_PER_MINUTE, MAX_BREATH_PER_MINUTE)}, 
                        "saturation" : ${Random.nextInt(MIN_SATURATION, MAX_SATURATION)}, 
                        "bodyTemperature" : {
                            "temperature" : ${Random.nextDouble(MIN_TEMPERATURE, MAX_TEMPERATURE)},
                            "temperatureUnit" : "celsius"
                        }
                    }
                """.trimIndent()
                medicalInstrumentDataReceiver.receiveTelemetrySystemData(telemetrySystemData)
            }
        }
    }
}
