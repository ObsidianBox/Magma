/**
 * This file is part of Magma, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2013-2014 ObsidianBox <http://obsidianbox.org/>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.obsidianbox.magma.message;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import org.obsidianbox.magma.addon.Addon;

public interface MessagePipeline {
    /**
     * Registers a {@link org.obsidianbox.magma.message.Message} with its {@link org.obsidianbox.magma.message.MessageHandler}
     * for the pipeline.
     *
     * @param addon The {@link org.obsidianbox.magma.addon.Addon} registering the message
     * @param message The message being registered
     * @param handler The handler of the message. If null, handling is ignored
     * @param <T> Enforces Message implementations
     * @param <U> Enforces MessageHandler implementations
     */
    public <T extends Message, U extends MessageHandler<T>> void register(Addon addon, Class<T> message, Class<U> handler);

    /**
     * Sends a {@link Message} to all {@link net.minecraft.entity.player.EntityPlayer}s on the server.
     *
     * @param message The message to send
     */
    @SideOnly (Side.SERVER)
    public void sendToAll(Message message);

    /**
     * Sends a {@link Message} to the specified {@link net.minecraft.entity.player.EntityPlayer}.
     *
     * @param message The message to send
     * @param player The player to send it to
     */
    @SideOnly (Side.SERVER)
    public void sendTo(Message message, EntityPlayer player);

    /**
     * Sends a {@link Message} to all {@link net.minecraft.entity.player.EntityPlayer}s within a certain range of a {@link cpw.mods.fml.common.network.NetworkRegistry.TargetPoint}.
     *
     * @param message The message to send
     * @param point The point around which to send
     */
    @SideOnly (Side.SERVER)
    public void sendToAllAround(Message message, NetworkRegistry.TargetPoint point);

    /**
     * Sends a {@link Message} to all {@link net.minecraft.entity.player.EntityPlayer}s within the supplied dimension by id.
     *
     * @param message The message to send
     * @param dimensionId The dimension id to target
     */
    @SideOnly (Side.SERVER)
    public void sendToDimension(Message message, int dimensionId);

    /**
     * Sends a {@link Message} to the server.
     *
     * @param message The message to send
     */
    @SideOnly (Side.CLIENT)
    public void sendToServer(Message message);
}
