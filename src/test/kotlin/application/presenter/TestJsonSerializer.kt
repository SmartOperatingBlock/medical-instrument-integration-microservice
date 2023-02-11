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
    val beatPerMinute = 120.0
    val diastolicBloodPressure = 1000
    val systolicBloodPressure = 2000
    val breathPerMinute = 60.0
    val saturation = 70
    val temperature = 36.0
    val jsonPatch = """
        [
          {
            "op": "add",
            "path": "/patientID",
            "value": "$patientID"
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
