/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package application.presenter.serializer

/**
 * Interface of a generic data serializer.
 */
interface Serializer<I, O> {

    /**
     * Serializes an entity.
     * @param entity the entity to serialize.
     * @return the serialized entity.
     */
    fun serialize(entity: I): O
}
