/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package entity

/**
 * The telemetry system present in the operating room.
 * @param telemetrySystemID the id of the telemetry system.
 * @param patientID the id of the patient.
 * @param telemetryData the telemetry data retrieved from the telemetry system.
 */
class TelemetrySystem(
    override val medicalInstrumentID: MedicalInstrumentID,
    override val patientID: PatientID,
    val telemetryData: TelemetryData
) : MedicalInstrument
