package com.atguigu.netty.protocoltcp;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;


public class MyClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {

        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new MyMessageDecoder()); //加入解码器
        pipeline.addLast(new MyMessageEncoder()); //加入编码器
        pipeline.addLast(new MyClientHandler());
    }

    public static void main(String[] args) {

        String s = "{\"@class\":\"com.ruijie.software.inap.iotp.model.edu.cache.StudentInfo\",\"studentId\":25,\"studenName\":\"侯俊杰\",\"studenNumber\":\"162070925\",\"terminalId\":10,\"terminalType\":13,\"terminalMac\":\"BB-00-00-00-03-3F\",\"classId\":1,\"className\":\"初二（9）\",\"parentName\":null,\"teacherName\":\"兰雅文\",\"terminalType2Tw\":13,\"extraMac\":null}";
        System.out.println(s.getBytes().length);
    }
}
