/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package entities

/**
 * The telemetry system present in the operating room.
 * @param telemetrySystemID the id of the telemetry system.
 * @param patientID the id of the patient.
 * @param telemetryData the telemetry data retrieved from the telemetry system.
 */
class TelemetrySystem(
    val telemetrySystemID: TelemetrySystemID,
    val patientID: PatientID,
    val telemetryData: TelemetryData
)

/**
 * The id of the telemetry system.
 * @param id the id of the telemetry system.
 */
data class TelemetrySystemID(val id: Int)

/**
 * The id of the patient in the operating room.
 * @param id the id of the patient.
 */
data class PatientID(val id: Int)
