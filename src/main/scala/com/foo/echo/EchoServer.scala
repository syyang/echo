package com.foo.echo

import com.twitter.util.Future
import java.net.InetSocketAddress
import com.twitter.finagle.thrift.{ThriftServerFramedCodec, ThriftClientFramedCodec, ThriftServerBufferedCodec}
import com.foo.echo.thrift.Echo
import org.apache.thrift.protocol.TBinaryProtocol
import com.twitter.finagle.builder.ServerBuilder
import com.twitter.finagle.builder.Server

object EchoServer {
  def main(args: Array[String]) {

    val processor = new Echo.FutureIface {
      def echo(message: String) =  {
        println("received: " + message)
        Future.value(message)
      }
    }
    
    val service = new Echo.FinagledService(processor, new TBinaryProtocol.Factory())
    
    val server: Server = ServerBuilder()
      .codec(ThriftServerFramedCodec())
      .name("echoserver")      
      .bindTo(new InetSocketAddress(8080))    
      .build(service)
  }

}