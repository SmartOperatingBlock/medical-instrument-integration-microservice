/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package application.presenter

import application.presenter.serializer.JsonPatchSerializer
import entity.BloodPressure
import entity.BodyTemperature
import entity.Heartbeat
import entity.MedicalInstrumentID
import entity.PatientID
import entity.RespirationRate
import entity.Saturation
import entity.TelemetryData
import entity.TelemetrySystem
import entity.UnitOfMeasurement
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
    val jsonPatch = """
        [
            {
                "op": "add",
                "path": "/systolic_blood_pressure",
                "value": $systolicBloodPressure
            },
            {
                "op": "add",
                "path": "/diastolic_blood_pressure",
                "value": $diastolicBloodPressure
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
            BloodPressure(diastolicBloodPressure, systolicBloodPressure)
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
