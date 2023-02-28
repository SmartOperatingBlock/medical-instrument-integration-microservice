/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package application.presenter.deserializer
import ca.uhn.fhir.context.FhirContext
import entity.BloodPressure
import entity.BodyTemperature
import entity.Heartbeat
import entity.MedicalInstrumentID
import entity.PatientID
import entity.RespirationRate
import entity.Saturation
import entity.TelemetryData
import entity.TelemetrySystem
import org.hl7.fhir.r4.model.Observation

/**
 * A json deserializer.
 */
object JsonDeserializer {

    /**
     * A json deserializer implementation for Telemetry System.
     */
    class TelemetrySystemHl7JsonDeserializer : Deserializer<String, TelemetrySystem> {

        /**
         * Deserializes the json returning an instance of [TelemetrySystem].
         *
         */
        override fun deserialize(data: String): TelemetrySystem {
            val parser = FhirContext.forR4().newJsonParser()
            val observation = parser.parseResource(Observation::class.java, data)
            val telemetrySystemId = MedicalInstrumentID(observation.device.reference)
            val patientID = PatientID(observation.subject.reference)
            val bodyTemperature =
                BodyTemperature(observation.getValueFromCode(HL7VitalParameters.BODY_TEMPERATURE.code).toDouble())
            val saturation = Saturation(
                observation.getValueFromCode(HL7VitalParameters.OXYGEN_SATURATION_IN_ARTERIAL_BLOOD.code).toInt()
            )
            val respirationRate =
                RespirationRate(observation.getValueFromCode(HL7VitalParameters.RESPIRATION_RATE.code).toInt())
            val heartbeat = Heartbeat(observation.getValueFromCode(HL7VitalParameters.HEART_RATE.code).toInt())
            val systolicBloodPressure =
                observation.getValueFromCode(HL7VitalParameters.SYSTOLIC_BLOOD_PRESSURE.code).toInt()
            val diastolicBloodPressure =
                observation.getValueFromCode(HL7VitalParameters.DIASTOLIC_BLOOD_PRESSURE.code).toInt()
            val bloodPressure = BloodPressure(diastolicBloodPressure, systolicBloodPressure)
            val telemetryData = TelemetryData(bodyTemperature, saturation, respirationRate, heartbeat, bloodPressure)
            return TelemetrySystem(telemetrySystemId, patientID, telemetryData)
        }
    }

    /**
     * Maps code of a parameter with its value.
     */
    private fun Observation.listOfCodes() =
        component.map {
            it.code.coding.first().code
        }

    private fun Observation.getValueFromCode(code: String) = component[listOfCodes().indexOf(code)].valueQuantity.value
}
