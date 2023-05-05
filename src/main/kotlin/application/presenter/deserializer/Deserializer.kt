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
interface Deserializer<I, O> {

    /**
     * Deserializes the data.
     * @param data the data to deserialize.
     * @return an object corresponding to the data deserialized.
     */
    fun deserialize(data: I): O
}
