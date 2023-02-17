/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

import application.MedicalInstrumentController
import infrastructure.DigitalTwinMedicalInstrumentManager
import infrastructure.MedicalInstrumentDataReceiver

/**
 * Template for kotlin projects.
 */
fun main() {

    val medicalInstrumentManager = DigitalTwinMedicalInstrumentManager()
    val medicalInstrumentController = MedicalInstrumentController(medicalInstrumentManager)
    val medicalInstrumentDataReceiver = MedicalInstrumentDataReceiver(medicalInstrumentController)
    val thirdPartySystemSimulator = ThirdPartySystemSimulator(medicalInstrumentDataReceiver)
    thirdPartySystemSimulator.startSimulator()
}
