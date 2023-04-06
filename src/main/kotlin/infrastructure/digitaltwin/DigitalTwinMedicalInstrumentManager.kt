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
import com.azure.digitaltwins.core.DigitalTwinsClientBuilder
import com.azure.digitaltwins.core.implementation.models.ErrorResponseException
import com.azure.identity.DefaultAzureCredentialBuilder
import entity.MedicalInstrument
import entity.TelemetrySystem

/**
 * Manager that manage the update of the digital twin on Azure digital twin platform.
 */
class DigitalTwinMedicalInstrumentManager : MedicalInstrumentManager<JsonPatchDocument> {
    init {
        checkNotNull(System.getenv(dtAppIdVariable)) { "azure client app id required" }
        checkNotNull(System.getenv(dtTenantVariable)) { "azure tenant id required" }
        checkNotNull(System.getenv(dtAppSecretVariable)) { "azure client secret id required" }
        checkNotNull(System.getenv(dtEndpointVariable)) { "azure dt endpoint required" }
    }

    private val client = DigitalTwinsClientBuilder()
        .credential(DefaultAzureCredentialBuilder().build())
        .endpoint(System.getenv(dtEndpointVariable))
        .buildClient()

    /**
     * Updates the digital twin.
     * @param medicalInstrument the medical instrument.
     */
    override fun updateMedicalInstrumentDigitalTwin(medicalInstrument: MedicalInstrument): Boolean {
        return try {
            createCommand(medicalInstrument).forEach {
                client.updateDigitalTwin(medicalInstrument.patientID.id, it)
            }
            true
        } catch (e: ErrorResponseException) {
            println(e)
            false
        }
    }

    /**
     * Given the medical instrument, creates the command serializing the content.
     * @param medicalInstrument the medical instrument.
     * @return a json patch document.
     */
    private fun createCommand(medicalInstrument: MedicalInstrument): List<JsonPatchDocument> {
        val serializer = JsonPatchSerializer.TelemetrySystemJSONPatchSerializer()
        when (medicalInstrument) {
            is TelemetrySystem -> return serializer.serialize(medicalInstrument)
            else -> throw UnsupportedOperationException()
        }
    }

    companion object {
        private const val dtAppIdVariable = "AZURE_CLIENT_ID"
        private const val dtTenantVariable = "AZURE_TENANT_ID"
        private const val dtAppSecretVariable = "AZURE_CLIENT_SECRET"
        private const val dtEndpointVariable = "AZURE_DT_ENDPOINT"
    }
}
