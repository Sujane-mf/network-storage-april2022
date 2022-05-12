package ru.gb.storage.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import javafx.event.ActionEvent;

public class Controller {

    public void login() {
        connect();
    }

    private void connect() {
        final NioEventLoopGroup group = new NioEventLoopGroup(1);
        try{
            Bootstrap bootstrap = new Bootstrap()
                    .group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(
                                    new ChannelInboundHandlerAdapter(){
                                        @Override
                                        public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
                                            System.out.println("Клиент зарегистрирован");
                                        }

                                        @Override
                                        public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
                                            System.out.println("Клиент отрегистрирован");
                                        }

                                        @Override
                                        public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                            System.out.println("Клиент активен");
                                        }

                                        @Override
                                        public void channelInactive(ChannelHandlerContext ctx) throws Exception {
                                            System.out.println("Клиент отключен");
                                        }

                                        @Override
                                        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                            super.channelRead(ctx, msg);
                                        }
                                    }
                            );
                        }
                    });

            Channel channel = bootstrap.connect("localhost", 8189).sync().channel();
            channel.closeFuture().sync();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        finally {
            group.shutdownGracefully();
        }
    }
}
