/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package entity
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class TestTelemetryData : StringSpec({

    "Create saturation with a percentage lower than 0 to the saturation throw an invalid argument exception" {
        shouldThrow<RuntimeException> {
            Saturation(-5)
        }
    }

    "Create saturation with a percentage greater than 100 to the saturation throw an invalid argument exception" {
        shouldThrow<RuntimeException> {
            Saturation(101)
        }
    }
})
