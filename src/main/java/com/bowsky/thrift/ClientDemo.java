package com.bowsky.thrift;


import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;


/**
 * Thrift Client 测试类
 * @author Administrator
 */
public class ClientDemo
{
    /**
     * @param args 默认函数
     * @throws TException 异常
     */
    public static void main(String[] args)
        throws TException
    {
        // 传输层
        TTransport transport = new TSocket("127.0.0.1", 9000);
        transport.open();
        // 协议层
        TProtocol protocol = new TBinaryProtocol(transport);

        // 创建RPC客户端
        HelloService.Client client = new HelloService.Client(protocol);

        // 调用服务
        String result = client.hello("zs");
        System.out.printf("-->" + result);

        // 关闭通道
        transport.close();
    }
}
