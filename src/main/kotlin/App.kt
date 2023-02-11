
import application.MedicalInstrumentController
import infrastructure.DigitalTwinMedicalInstrumentManager
import infrastructure.MedicalInstrumentDataReceiver

/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

/**
 * Template for kotlin projects.
 */
fun main() {
    val medicalInstrumentManager = DigitalTwinMedicalInstrumentManager()
    val medicalInstrumentController = MedicalInstrumentController(medicalInstrumentManager)
    val medicalInstrumentDataReceiver = MedicalInstrumentDataReceiver(medicalInstrumentController)
    val telemetrySystemData = """
        {
        	"telemetrySystemID": "TelemetrySystem",
        	"patientID" : "patient2", 
        	"beatPerMinute" : 30.0, 
        	"bloodPressure" : {
        		"diastolicBloodPressure" : 1000, 
        		"systolicBloodPressure" : 2000, 
        		"bloodPressureUnit" : mmhg
        	}, 
        	"breathPerMinute" : 20.0, 
        	"saturation" : 20, 
        	"bodyTemperature" : {
        		"temperature" : 36.5,
        		"temperatureUnit" : "celsius"
        	}
        }
    """.trimIndent()
    medicalInstrumentDataReceiver.receiveTelemetrySystemData(telemetrySystemData)
}
