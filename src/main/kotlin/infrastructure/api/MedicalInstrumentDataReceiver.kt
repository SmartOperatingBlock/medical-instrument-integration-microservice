/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package infrastructure

import application.MedicalInstrumentController

/**
 * This class is used for receiving data, collected by medical instrument, from a third party system.
 */
class MedicalInstrumentDataReceiver(private val controller: MedicalInstrumentController) {

    /**
     * Receive data about telemetry system.
     */
    fun receiveTelemetrySystemData(data: String) {
        controller.medicalInstrumentDataReceived(data)
    }
}
