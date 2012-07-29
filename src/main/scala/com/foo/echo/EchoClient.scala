package com.foo.echo

import com.twitter.finagle.builder.ClientBuilder
import java.net.InetSocketAddress
import com.twitter.finagle.Service
import com.twitter.finagle.thrift.{ThriftClientFramedCodec, ThriftClientBufferedCodec, ThriftClientRequest}
import org.apache.thrift.protocol.TBinaryProtocol
import com.foo.echo.thrift.Echo

object EchoClient {
  def main(args: Array[String]) {

    val service: Service[ThriftClientRequest, Array[Byte]] = ClientBuilder()
      .hosts(new InetSocketAddress(8080))
      .codec(ThriftClientFramedCodec())
      .hostConnectionLimit(1)
      .build()

    val client = new Echo.FinagledClient(service, new TBinaryProtocol.Factory())

    client.echo("foo") onSuccess { response =>
      println("Received response: " + response)
    } ensure {
      service.release()
    }
  }
}
