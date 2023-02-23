/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package usecase.repository

import entities.TelemetrySystem

/**
 * Interface that models the repository for [TelemetrySystem].
 */
interface TelemetrySystemRepository {
    /**
     * Updates the [TelemetrySystem].
     * @retur true if the telemetry system was updated, false otherwise.
     */
    fun updateTelemetrySystem(telemetrySystem: TelemetrySystem): Boolean
}
