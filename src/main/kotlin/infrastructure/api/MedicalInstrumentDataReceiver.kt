/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package infrastructure.api

import application.MedicalInstrumentController
import application.presenter.deserializer.JsonDeserializer
import infrastructure.Provider
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.request.receiveText
import io.ktor.server.response.respond
import io.ktor.server.routing.post
import io.ktor.server.routing.routing

/**
 * This class is used for receiving data, collected by medical instrument, from a third party system.
 */
class MedicalInstrumentDataReceiver {

    /**
     * Starts ktor embedded server.
     */
    fun start() {
        embeddedServer(Netty, port = 3000, module = this::dispatcher).start(true)
    }

    /**
     * Dispatcher for http requests.
     */
    fun dispatcher(app: Application) {
        with(app) {
            receiveTelemetrySystemData(this)
        }
    }

    /**
     * Receive data about telemetry system.
     */
    private fun receiveTelemetrySystemData(app: Application) {
        with(app) {
            routing {
                post("/telemetrySystem") {
                    if (MedicalInstrumentController(Provider.digitalTwinMedicalInstrumentManager)
                            .updateTelemetrySystem(
                                JsonDeserializer.TelemetrySystemJsonDeserializer().deserialize(call.receiveText()))
                    ) {
                        call.respond(HttpStatusCode.OK)
                    } else {
                        call.respond(HttpStatusCode.Conflict)
                    }
                }
            }
        }
    }
}
