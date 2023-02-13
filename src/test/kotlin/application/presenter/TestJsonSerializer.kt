/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package application.presenter

import application.presenter.serializer.JsonPatchSerializer
import entities.BloodPressure
import entities.BodyTemperature
import entities.Heartbeat
import entities.MedicalInstrumentID
import entities.PatientID
import entities.RespirationRate
import entities.Saturation
import entities.TelemetryData
import entities.TelemetrySystem
import entities.UnitOfMeasurement
import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class TestJsonSerializer : StringSpec({

    val telemetrySystemID = "telSys1"
    val patientID = "patient1"
    val beatPerMinute = 120
    val diastolicBloodPressure = 1000
    val systolicBloodPressure = 2000
    val breathPerMinute = 60
    val saturation = 70
    val temperature = 36.5
    val bloodPressureUnit = "mmhg"
    val jsonPatch = """
        [
            {
                "op": "add",
                "path": "/blood_pressure/systolic_blood_pressure",
                "value": $systolicBloodPressure
            },
            {
                "op": "add",
                "path": "/blood_pressure/diastolic_blood_pressure",
                "value": $diastolicBloodPressure
            },
            {
                "op": "add",
                "path": "/blood_pressure/unit",
                "value": "$bloodPressureUnit"
            },
            {
                "op": "add",
                "path": "/body_temperature",
                "value": $temperature
            },
            {
                "op": "add",
                "path": "/heart_beat",
                "value": $beatPerMinute
            },
            {
                "op": "add",
                "path": "/respiratory_rate",
                "value": $breathPerMinute
            },
            {
                "op": "add",
                "path": "/saturation_percentage",
                "value": $saturation
            }      
        ]
    """.trimIndent()
    val telemetrySystem = TelemetrySystem(
        MedicalInstrumentID(telemetrySystemID),
        PatientID(patientID),
        TelemetryData(
            BodyTemperature(temperature, UnitOfMeasurement.TemperatureUnit.CELSIUS),
            Saturation(saturation),
            RespirationRate(breathPerMinute),
            Heartbeat(beatPerMinute),
            BloodPressure(diastolicBloodPressure, systolicBloodPressure, UnitOfMeasurement.BloodPressureUnit.MMHG)
        )
    )
    val jsonSerializer = JsonPatchSerializer.TelemetrySystemJSONPatchSerializer()

    "the serializer must generate JsonPatch without throwing exception" {
        shouldNotThrow<Exception> {
            jsonSerializer.serialize(telemetrySystem)
        }
    }

    "the serializer must generate the correct JsonPatch" {
        jsonSerializer.serialize(telemetrySystem).toString() shouldBe jsonPatch
            .replace("\n", "")
            .replace("\t", "")
            .replace(" ", "")
    }
})
