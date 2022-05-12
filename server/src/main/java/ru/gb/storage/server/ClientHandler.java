package ru.gb.storage.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ClientHandler extends SimpleChannelInboundHandler<String> {

        @Override
        public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
            System.out.println("Канал зарегистрирован");
        }

        @Override
        public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
            System.out.println("Канал разрегистрирован");
        }

        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            System.out.println("Канал активирован");
        }

        @Override
        public void channelInactive(ChannelHandlerContext ctx) throws Exception {
            System.out.println("Канал деактивирован");
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
        }

        @Override
        protected void channelRead0(ChannelHandlerContext channelHandlerContext, String str) throws Exception {

        }
}
