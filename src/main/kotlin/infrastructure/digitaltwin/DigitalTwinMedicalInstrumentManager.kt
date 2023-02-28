/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package infrastructure.digitaltwin
import application.MedicalInstrumentManager
import application.presenter.serializer.JsonPatchSerializer
import com.azure.core.models.JsonPatchDocument
import com.azure.digitaltwins.core.DigitalTwinsClient
import com.azure.digitaltwins.core.DigitalTwinsClientBuilder
import com.azure.digitaltwins.core.implementation.models.ErrorResponseException
import com.azure.identity.ClientSecretCredentialBuilder
import entity.MedicalInstrument
import entity.TelemetrySystem

/**
 * The Azure endpoint.
 */
const val ENDPOINT = "https://digital-twin-layer.api.neu.digitaltwins.azure.net"

/**
 * The Azure tenant id.
 */
const val TENANT_ID = "8e97c84a-c23e-4463-8faf-d9a974450bc1"

/**
 * The Azure client id.
 */
const val CLIENT_ID = "52e143e0-1993-436f-ac31-8ba5787445e4"

/**
 * The Azure client secret.
 */
const val CLIENT_SECRET = "zuu8Q~0JA2NnKpnXEDMyew4WdBcw.XIjYWwK8b1R"

/**
 * Manager that manage the update of the digital twin on Azure digital twin platform.
 */
class DigitalTwinMedicalInstrumentManager : MedicalInstrumentManager<JsonPatchDocument> {

    private val client: DigitalTwinsClient = DigitalTwinsClientBuilder()
        .credential(
            ClientSecretCredentialBuilder()
                .tenantId(TENANT_ID)
                .clientId(CLIENT_ID)
                .clientSecret(CLIENT_SECRET)
                .build()
        )
        .endpoint(ENDPOINT)
        .buildClient()

    /**
     * Updates the digital twin.
     * @param medicalInstrumentID the id of the digital twin to update.
     * @param command the json with the instruction to update the digital twin.
     */
    override fun updateMedicalInstrumentDigitalTwin(medicalInstrument: MedicalInstrument): Boolean {
        return try {
            client.updateDigitalTwin(medicalInstrument.patientID.id, createCommand(medicalInstrument))
            true
        } catch (e: ErrorResponseException) {
            println(e)
            false
        }
    }

    /**
     * Given the medical instrument, creates the command serializing the content.
     * @param medicalInstrument the medical instrument.
     */
    private fun createCommand(medicalInstrument: MedicalInstrument): JsonPatchDocument {
        val serializer = JsonPatchSerializer.TelemetrySystemJSONPatchSerializer()
        when (medicalInstrument) {
            is TelemetrySystem -> return serializer.serialize(medicalInstrument)
            else -> throw UnsupportedOperationException()
        }
    }
}
