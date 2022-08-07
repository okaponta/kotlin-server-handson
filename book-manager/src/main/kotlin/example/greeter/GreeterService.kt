package example.greeter

class GreeterService : GreeterGrpcKt.GreeterCoroutineImplBase() {
    override suspend fun hello(request: HelloRequest) =
        HelloResponse.newBuilder().setText("Hello ${request.name}").build()
}
