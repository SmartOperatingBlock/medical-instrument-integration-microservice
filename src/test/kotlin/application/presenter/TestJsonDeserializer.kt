/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package application.presenter
import application.presenter.deserializer.JsonDeserializer
import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.core.spec.style.StringSpec

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
    val jsonDeserializer = JsonDeserializer.TelemetrySystemJsonDeserializer()

    "the deserializer must generate the Telemetry System without throwing exception" {
        shouldNotThrow<Exception> {
            jsonDeserializer.deserialize(jsonData)
        }
    }
})
