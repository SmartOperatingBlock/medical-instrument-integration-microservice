/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package presenter
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
import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.equality.shouldBeEqualToComparingFields

class TestJsonDeserializer : StringSpec({

    val telemetrySystemID = "telSys1"
    val patientID = "patient1"
    val beatPerMinute = 120.0
    val diastolicBloodPressure = 1000
    val systolicBloodPressure = 2000
    val bloodPressureUnit = "mmhg"
    val breathPerMinute = 60.0
    val saturation = 70
    val temperature = 36.0
    val temperatureUnit = "celsius"
    val jsonData = """
        {
        	"telemetrySystemID": $telemetrySystemID,
        	"patientID" : $patientID, 
        	"beatPerMinute" : $beatPerMinute, 
        	"bloodPressure" : {
        		"diastolicBloodPressure" : $diastolicBloodPressure, 
        		"systolicBloodPressure" : $systolicBloodPressure, 
        		"bloodPressureUnit" : $bloodPressureUnit
        	}, 
        	"breathPerMinute" : $breathPerMinute, 
        	"saturation" : $saturation, 
        	"bodyTemperature" : {
        		"temperature" : $temperature,
        		"temperatureUnit" : $temperatureUnit
        	}
        }
    """.trimIndent()
    val jsonDeserializer = JsonDeserializer.JsonDeserializer()

    "the deserializer must generate the Telemetry System without throwing exception" {
        shouldNotThrow<Exception> {
            jsonDeserializer.deserialize(jsonData)
        }
    }

    "the deserializer must generate the Telemetry System with the correct data" {
        val telemetrySystem = TelemetrySystem(
            TelemetrySystemID(telemetrySystemID),
            PatientID(patientID),
            TelemetryData(
                BodyTemperature(temperature, UnitOfMeasurement.TemperatureUnit.CELSIUS),
                Saturation(saturation),
                RespirationRate(breathPerMinute),
                Heartbeat(beatPerMinute),
                BloodPressure(diastolicBloodPressure, systolicBloodPressure, UnitOfMeasurement.BloodPressureUnit.MMHG)
            )
        )
        jsonDeserializer.deserialize(jsonData) shouldBeEqualToComparingFields telemetrySystem
    }
})
