/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package application.presenter.deserializer

/**
 * Interface of a generic data deserializer.
 */
interface Deserializer <I, O> {

    /**
     * Deserializes the data.
     */
    fun deserialize(data: I): O
}
